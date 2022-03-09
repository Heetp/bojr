package com.application.archive;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * An Archiver facades a specific archiving library, allowing for simple archiving of files and directories, and
 * extraction of archives.
 * <br>
 * Some archivers might use an additional {@link Compressor} to compress and decompress their respective archive files.
 */
public interface Archiver {

    /**
     * Creates an archive from the given source file or directory, and saves it into the given destination.
     * <br>
     * If the source is a directory, the archive will contain all the files in that directory, but not the directory
     * itself.
     * <br>
     * If the archive parameter has no file extension (e.g. "archive" instead of "archive.zip"), the concrete archiver
     * implementation should append it according to its file format (.zip, .tar, .tar.gz, ...).
     * 
     * @param archive the name of the archive to create
     * @param destination the destination directory where to place the created archive
     * @param source the input file or directory to archive
     * @return the newly created archive file
     * @throws IOException propagated I/O errors by {@code java.io}
     */
    File create(String archive, File destination, File source) throws IOException;

    /**
     * Creates an archive from the given source files or directories, and saves it into the given destination.
     * <br>
     * If the source is a directory, the archive will contain all the files in that directory, but not the directory
     * itself.
     * <br>
     * If the archive parameter has no file extension (e.g. "archive" instead of "archive.zip"), the concrete archiver
     * implementation should append it according to its file format (.zip, .tar, .tar.gz, ...).
     *
     * @param archive the name of the archive to create
     * @param destination the destination directory where to place the created archive
     * @param sources the input files or directories to archive
     * @return the newly created archive file
     * @throws IOException propagated I/O errors by {@code java.io}
     */
    File create(String archive, File destination, File... sources) throws IOException;

    /**
     * Extracts the given archive file into the given destination directory.
     * <br>
     * The destination is expected to be a writable directory.
     * 
     * @param archive the archive file to extract
     * @param destination the directory to which to extract the files
     * @throws IOException propagated I/O errors by {@code java.io}
     */
    void extract(File archive, File destination) throws IOException;

    /**
     * Extracts the given archive supplied as an input stream into the given destination directory.
     * <br>
     * The destination directory is expected to be a writable directory.
     *
     * @param archive the archive contents as a stream.
     * @param destination the destination directory.
     * @throws IOException
     */
    void extract(InputStream archive, File destination) throws IOException;

    /**
     * Reads the given archive file as an {@link ArchiveStream} which is used to access individual {@link ArchiveEntry}
     * objects within the archive without extracting the archive onto the file system.
     * 
     * @param archive the archive file to stream
     * @return a new archive stream for the given archive
     * @throws IOException propagated I/O errors by {@code java.io}
     */
    ArchiveStream stream(File archive) throws IOException;

    /**
     * Returns the filename extension that indicates the file format this archiver handles. E.g .tar" or ".zip". In case
     * of compressed archives, it will return the composite filename extensions, e.g. ".tar.gz"
     * 
     * @return a filename extension with a preceding dot
     */
    String getFilenameExtension();
}
