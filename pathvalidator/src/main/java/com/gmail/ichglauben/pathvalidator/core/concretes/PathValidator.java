package com.gmail.ichglauben.pathvalidator.core.concretes;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
/**	PathValidator<br>
 *  Private constructor and 3 static methods that verifies a file, directory or general path exists and is not a symbolic link.
 * */
public class PathValidator {
	/**Validates the path exists and is not a symbolic link.
	 * @param filePath - String file or directory path
	 * @return true if path exists and is not a symbolic link, false if otherwise*/
	public static boolean pathExists(String filePath) {
		Path path = null;
		if (null != filePath) {
			if (null != (path = Paths.get(filePath))) {
				return Files.exists(path, LinkOption.NOFOLLOW_LINKS);
			}
		}
		return false;
	}
	
	/**Validates the directory exists, it's not a symbolic link and that it is a directory.
	 * @param filePath - String
	 * @return true if directory exists and is not a symbolic link, false if otherwise*/
	public static boolean isADirectory(String filePath) {
		Path path = null;
		if (null != filePath) {
			if (null != (path = Paths.get(filePath))) {
				return (Files.exists(path, LinkOption.NOFOLLOW_LINKS) && Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS));
			}
		}
		return false;
	}
	
	/**Validates the file exists, it's not a symbolic link and that it is a file.
	 * @param filePath - String
	 * @return true if file exists and is not a symbolic link, false if otherwise*/
	public static boolean isAFile(String filePath) {
		Path path = null;
		if (null != filePath) {
			if (null != (path = Paths.get(filePath))) {
				return (Files.exists(path, LinkOption.NOFOLLOW_LINKS) && Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS));
			}
		}
		return false;
	}
	
	private PathValidator() {}
	
	public String toString() { return "Path (Directory or File) Validator"; }
}
