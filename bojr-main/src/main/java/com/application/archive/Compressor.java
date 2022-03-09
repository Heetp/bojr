package com.application.archive;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * A compressor facades a specific compression library, allowing for simple compression and decompression of files.
 */
public interface Compressor {

    /**
     * Compresses the given input file to the given destination directory or file.
     * <br>
     * Requires the source the be an existing and readable File, and the destination to be either a file or a directory.
     * If you pass a directory, the name of the source file is used, with the appended filename extension suffix of the
     * compression type.
     * 
     * @param source the source file to compress
     * @param destination the destination file
     * @throws IllegalArgumentException if the source is not readable or the destination is not writable
     * @throws IOException when an I/O error occurs
     */
    void compress(File source, File destination) throws IllegalArgumentException, IOException;

    /**
     * Decompresses the given source file to the given destination directory or file.
     * <br>
     * Requires the source the be an existing and readable File, and the destination to be either a file or a directory.
     * If you pass a directory, the name of the source file is used, with the removed filename extension suffix of the
     * compression type.
     * 
     * @param source the compressed source file to decompress
     * @param destination the destination file
     * @throws IllegalArgumentException if the source is not readable or the destination is not writable
     * @throws IOException when an I/O error occurs
     */
    void decompress(File source, File destination) throws IllegalArgumentException, IOException;

    /**
     * Accept a stream and wrap it in a decompressing stream suitable for the current compressor.
     * @param compressedStream the stream of compressed data.
     * @throws IOException an I/O error.
     */
    InputStream decompressingStream(InputStream compressedStream) throws IOException;

    /**
     * Returns the filename extension that indicates the file format this compressor handles. E.g .gz". or ".bz2".
     * 
     * @return a filename extension with a preceding dot
     */
    String getFilenameExtension();
}
