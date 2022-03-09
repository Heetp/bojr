### INSTRUCTIONS FOR CANDIDATES
1. Unzip and create the BOJR repository into your own GitHub account (*make sure your new repo is private*)
2. Use gitpod.io to openup an online IDE eg. gitpod.io/#https://github.com/username/bojr ( replace *username* with your username ) 
3. Analyze and identify the root causes of the following three issues and add your fixes to the code 
4. Submit all three fixes as a SINGLE pull request ***in your own private repo***
5. Add 'GAC89' as a collaborator and share the link to your PR as your submission response

Although this repository is written in java, we have designed the test such that it does not require any language specific knowledge. No matter what your primary techstack is, you should be able to exercise your debugging skills and fix the root cause.

*Hint: The purpose of this assessment is to see how well you can identify and fix root causes in code. For each challenge, seek to identify the root cause and fix it directly (a fix should be permanent and work for ALL possibilities). Workarounds that provide the correct output, but fail to fix the underlying issue, will be marked as zero. Once you have identified the root cause, the actual fix should be short and simple (i.e. no need to write new classes or methods).*

### Real Work Analysis
1. Extracting the **dkl** folder

```SETUP: Run the ExtractArchive.java file in the test folder.```

When attempting to extract the **test.zip** archive, you'll hit a "java.io.FileNotFoundException" exception. All other files are succesfully extracted to their folders up to this point. 

```
Please fix this issue so that all files and folders can be extracted (for any combination of files & folders). 

Do this by identifying a root cause and fixing it in the existing code - rather than writing a new method/function.
```

2.  The **test.zip** file

```SETUP: Run the ExtractArchive.java file in the test folder.```

Once ExtractArchive.java has succesfully executed, you'll find the **extractingReport.dat** file inside the testZipExtracted directory. This file has information about the extracted files and folders in the "test.zip" archive. We expect the file and folder names to be ordered alphabetically, but one item in the list is not. 

```
Please fix this issue so that all file and folder names are correctly ordered within the "extractingReport.dat" file. 

Do this by identifying a root cause and fixing it - rather than applying a new sorting algorithm.
```

3.  The read-only **destination** folder

```
SETUP: Create a destination folder without write permissions in the BOJR root directory. For example:

mkdir destination
chmod 0444 destination

This will create a folder called 'destination' in the root folder of your cloned repo and set the correct permissions to duplicate the issue. 

Run the CreateArchive.java file in the test folder (NOTE: you may have to edit CreateArchive.java to reflect whichever 'destination' folder you created in the previous step.)
```

When creating a new archive, by attempting to write to a read-only **destination** folder, you'll hit a "java.io.IOException: Permission denied" exception. This is because there are no *write* permissions for the **destination** folder.

However, we do not want to rely on low-level IO errors and would rather catch the problem earlier, with a clear message. 

```
Please fix this by throwing an "IllegalArgumentException" exception. 

Identify the most appropriate existing method/class to add your code (no need to create an entirely new method/class).
```
