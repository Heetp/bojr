package com.application.archive;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExtractingReport {
	
	private List<String> fileNameList;
	
	public ExtractingReport() {
		fileNameList = new ArrayList<String>();
	}
	
	public void addToFileNameList(final String fileName) {
		fileNameList.add(fileName);
	}
	
	public void createReportFile(final File destination) throws IOException {
				
		sortTheFileNames();
		
		final String reportingFileName = "extractingReport.dat";
		FileWriter reportingFileWriter = null;
		
		try {
			File reportingFile = new File(destination.getPath());
			reportingFile.createNewFile();
			reportingFileWriter = new FileWriter(destination.getPath() + "/"+ reportingFileName);
			
			reportingFileWriter.write("   Extracted file and folders\n");
			reportingFileWriter.write("================================\n");			
			
			for (final String fileName : fileNameList) {
				reportingFileWriter.write(fileName + "\n");
			}	
		} finally {
			reportingFileWriter.close();
		} 
	}
	
	private void sortTheFileNames() {
		for (int i = 1; i < fileNameList.size(); i++) {
			String insertValue = fileNameList.get(i);
			
		    int j;
		    for (j = i - 1; j > 0 && insertValue.compareTo(fileNameList.get(j)) < 0; j--) {
		    	fileNameList.set(j + 1, fileNameList.get(j));
		    }	
		    
		    if (j != i - 1) {
		    	fileNameList.set(j + 1, insertValue);
		    }		    
		}
	}
}
