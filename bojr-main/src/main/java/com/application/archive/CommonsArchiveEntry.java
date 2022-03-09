package com.application.archive;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Implementation of an {@link ArchiveEntry} that wraps the commons compress version of the same type.
 */
class CommonsArchiveEntry implements ArchiveEntry {

    /**
     * The wrapped {@code ArchiveEntry} entry.
     */
    private org.apache.commons.compress.archivers.ArchiveEntry entry;

    /**
     * The {@link ArchiveStream} this entry belongs to.
     */
    private ArchiveStream stream;

    CommonsArchiveEntry(ArchiveStream stream, org.apache.commons.compress.archivers.ArchiveEntry entry) {
        this.stream = stream;
        this.entry = entry;
    }

    @Override
    public String getName() {
        assertState();
        return entry.getName();
    }

    @Override
    public long getSize() {
        assertState();
        return entry.getSize();
    }

    @Override
    public Date getLastModifiedDate() {
        assertState();
        return entry.getLastModifiedDate();
    }

    @Override
    public boolean isDirectory() {
        assertState();
        return entry.isDirectory();
    }

    @Override
    public File extract(File destination) throws IOException, IllegalStateException, IllegalArgumentException {
        assertState();
        IOUtils.requireDirectory(destination);

        File file = new File(destination, entry.getName());

        if (entry.isDirectory()) {
            file.mkdirs();
        } else {
            file.getParentFile().mkdirs();
            IOUtils.copy(stream, file);
        }

        FileModeMapper.map(entry, file);

        return file;
    }

    private void assertState() {
        if (stream.isClosed()) {
            throw new IllegalStateException("Stream has already been closed");
        }
        if (this != stream.getCurrentEntry()) {
            throw new IllegalStateException("Illegal stream pointer");
        }
    }

}
