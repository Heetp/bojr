package com.application.archive;

import org.apache.commons.compress.archivers.ArchiveStreamFactory;

/**
 * Denotes an archive format such as zip or tar.
 */
public enum ArchiveFormat {

    /**
     * Constant used to identify the AR archive format.
     */
    AR(ArchiveStreamFactory.AR, ".ar"),
    /**
     * Constant used to identify the CPIO archive format.
     */
    CPIO(ArchiveStreamFactory.CPIO, ".cpio"),
    /**
     * Constant used to identify the Unix DUMP archive format.
     */
    DUMP(ArchiveStreamFactory.DUMP, ".dump"),
    /**
     * Constant used to identify the JAR archive format.
     */
    JAR(ArchiveStreamFactory.JAR, ".jar"),
    /**
     * Constant used to identify the 7z archive format.
     */
    SEVEN_Z(ArchiveStreamFactory.SEVEN_Z, ".7z"),
    /**
     * Constant used to identify the TAR archive format.
     */
    TAR(ArchiveStreamFactory.TAR, ".tar"),
    /**
     * Constant used to identify the ZIP archive format.
     */
    ZIP(ArchiveStreamFactory.ZIP, ".zip");

    /**
     * The name by which the compression algorithm is identified.
     */
    private final String name;

    /**
     * default file extension the archive format is mapped to
     */
    private final String defaultFileExtension;

    private ArchiveFormat(String name, String defaultFileExtension) {
        this.name = name;
        this.defaultFileExtension = defaultFileExtension;
    }

    /**
     * Returns the name by which the archive format is identified.
     * 
     * @return the archiver format name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the default file extension for this compression type. E.g. ".gz" for gzip.
     * 
     * @return the default file extension preceded by a dot
     */
    public String getDefaultFileExtension() {
        return defaultFileExtension;
    }

    /**
     * Checks if the given archive format name is valid and known format.
     * 
     * @param archiveFormat the archive format name
     * @return true if the given archive format is known to the factory, false otherwise
     */
    public static boolean isValidArchiveFormat(String archiveFormat) {
        for (ArchiveFormat format : values()) {
            if (archiveFormat.trim().equalsIgnoreCase(format.getName())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Attempts to return the {@link ArchiveFormat} instance from a possible given string representation. Ignores case.
     * 
     * @param archiveFormat string representation of the archive format. E.g. "tar" or "ZIP".
     * @return the compression type enum
     * @throws IllegalArgumentException if the given archive format is unknown.
     */
    public static ArchiveFormat fromString(String archiveFormat) {
        for (ArchiveFormat format : values()) {
            if (archiveFormat.trim().equalsIgnoreCase(format.getName())) {
                return format;
            }
        }

        throw new IllegalArgumentException("Unknown archive format " + archiveFormat);
    }

}
