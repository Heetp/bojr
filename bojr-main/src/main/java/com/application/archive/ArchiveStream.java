package com.application.archive;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * An input stream of an archive. Can be used to retrieve each individual {@link ArchiveEntry}.
 * <br>
 * The {@link #getNextEntry()} method is used to reset the input stream ready for reading the data from the next entry.
 */
public abstract class ArchiveStream extends InputStream implements Closeable {

    private ArchiveEntry currentEntry;

    private boolean closed;

    /**
     * Returns the {@link ArchiveEntry} the stream currently points to.
     * 
     * @return the current {@link ArchiveEntry}
     */
    public ArchiveEntry getCurrentEntry() {
        return currentEntry;
    }

    /**
     * Moves the pointer of the stream to the next {@link ArchiveEntry} and returns it.
     * 
     * @return the next archive entry.
     * @throws IOException propagated I/O exception
     */
    public ArchiveEntry getNextEntry() throws IOException {
        currentEntry = createNextEntry();
        return currentEntry;
    }

    /**
     * Abstract method to create the next {@link ArchiveEntry} for the {@link ArchiveStream} implementation.
     * 
     * @return the next archive entry
     * @throws IOException propagated I/O exception
     */
    protected abstract ArchiveEntry createNextEntry() throws IOException;

    @Override
    public void close() throws IOException {
        closed = true;
    }

    /**
     * Checks whether the current stream has been closed
     * 
     * @return true if the stream has been closed
     */
    public boolean isClosed() {
        return closed;
    }

}
