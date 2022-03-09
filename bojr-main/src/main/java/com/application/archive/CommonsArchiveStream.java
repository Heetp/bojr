package com.application.archive;

import java.io.IOException;

import org.apache.commons.compress.archivers.ArchiveInputStream;

/**
 * {@link ArchiveStream} implementation that wraps a commons compress {@link ArchiveInputStream}.
 */
class CommonsArchiveStream extends ArchiveStream {

    private ArchiveInputStream stream;

    CommonsArchiveStream(ArchiveInputStream stream) {
        this.stream = stream;
    }

    @Override
    protected ArchiveEntry createNextEntry() throws IOException {
        org.apache.commons.compress.archivers.ArchiveEntry next = stream.getNextEntry();

        return (next == null) ? null : new CommonsArchiveEntry(this, next);
    }

    @Override
    public int read() throws IOException {
        return stream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return stream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return stream.read(b, off, len);
    }

    @Override
    public void close() throws IOException {
        super.close();
        stream.close();
    }

}
