package org.pk.springboot.rest.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Pravin P Patil
 * @apiNote Utility class for storing profile images.
 */
public class FileUtil {

    private static final Logger LOGGER = LogManager.getLogger(FileUtil.class);
    /**
     * string array for allowed file formats.
     */
    private static final String[] ALLOWED_FILE_TYPES = new String[]{"png", "jpg", "ico", "jpeg", "csv", "xls",
            "json"};

    private FileUtil() {

    }

    /**
     * @param uploadedInputStream
     * @param path
     * @param saveAs              new file name by which we have write file on disk
     * @return true if file written successfully otherwise false.
     */
    public static synchronized boolean writeToFile(InputStream uploadedInputStream, String path, String saveAs) {
        boolean isSaved = false;
        int read = 0;
        byte[] bytes = new byte[1024];

        try (OutputStream out = new FileOutputStream(new File(path, saveAs))) {
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            isSaved = true;
        } catch (IOException e) {
            LOGGER.error("Error", e);
        }
        return isSaved;
    }

    /**
     * @param fileExtension
     * @return check file extension available in enlisted array
     */
    public static boolean isValidFileExtension(String fileExtension) {
        for (String fe : ALLOWED_FILE_TYPES) {
            if (fe.equalsIgnoreCase(fileExtension)) {
                return true;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * @param fileName
     * @return file extensions
     */
    public static String getFileExtension(String fileName) {
        if (fileName == null) {
            return null;
        }
        int length = fileName.length();
        return fileName.substring(fileName.indexOf('.') + 1, length);
    }
}