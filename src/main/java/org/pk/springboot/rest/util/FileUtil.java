package org.pk.springboot.rest.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Pravin P Patil Utility class for storing profile images.
 */
public class FileUtil {
	/**
	 * string array for allowed file formats.
	 */
	private static final String[] ALLOWED_FILE_TYPES = new String[] { "png", "jpg", "ico", "jpeg", "csv", "xls",
			"json" };

	// save uploaded file to new location
	/**
	 * @param uploadedInputStream
	 * @param path
	 * @param fileName
	 *            original file name from received from client
	 * @param saveAs
	 *            new file name by which we have write file on disk
	 * @return true if file written successfully otherwise false.
	 */
	public static synchronized boolean writeToFile(InputStream uploadedInputStream, String path, String fileName,
			String saveAs) {
		boolean isSaved = false;
		try {
			/*
			 * OutputStream out = new FileOutputStream(new File(path,
			 * fileName));
			 */
			int read = 0;
			byte[] bytes = new byte[1024];

			OutputStream out = new FileOutputStream(new File(path, saveAs));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
			isSaved = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSaved;
	}

	/**
	 * @param fileExtension
	 * @return check file extension available in enlisted array
	 */
	public static boolean isValidFileExtension(String fileExtension) {
		boolean isAllowed = false;
		for (String fe : ALLOWED_FILE_TYPES) {
			if (fe.equalsIgnoreCase(fileExtension))
				return isAllowed = true;
		}
		return isAllowed;
	}

	/**
	 * @param fileName
	 * @return file extensions
	 */
	public static String getFileExtension(String fileName) {
		return fileName == null ? null : fileName.substring(fileName.indexOf(".") + 1, fileName.length());
	}
}