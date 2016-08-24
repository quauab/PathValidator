package com.gmail.ichglauben.pathvalidator.core.concretes;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
/**	PathValidator<br>
 *  Private constructor and 3 static methods that verifies a file, directory or general path exists and is not a symbolic link.
 * */
public class PathValidator {
	/**Verifies the path exists and is not a symbolic link.
	 * @param filePath - String file or directory path
	 * @return true if path exists and is not a symbolic link, false if otherwise
	 * @throws NullPointerException if String argument is null or empty*/
	public static boolean pathExists(String filePath) {
		if (null == filePath && filePath.length() == 0)
			throw new NullPointerException("File path argument is null or empty");		
		return Files.exists(Paths.get(filePath), LinkOption.NOFOLLOW_LINKS);		
	}
	
	/**Verifies the directory exists, it's not a symbolic link and that it is a directory.
	 * @param filePath - String
	 * @return true if directory exists and is not a symbolic link, false if otherwise
	 * @throws NullPointerException if String argument is null or empty*/
	public static boolean isADirectory(String filePath) {
		if (null == filePath && filePath.length() == 0)
			throw new NullPointerException("File path argument is null or empty");
		return Files.isDirectory(Paths.get(filePath), LinkOption.NOFOLLOW_LINKS);
	}
	
	/**Verifies the file exists, it's not a symbolic link and that it is a file.
	 * @param filePath - String
	 * @return true if file exists and is not a symbolic link, false if otherwise
	 * @throws NullPointerException if String argument is null or empty*/
	public static boolean isAFile(String filePath) {
		if (null == filePath && filePath.length() == 0)
			throw new NullPointerException("File path argument is null or empty");
		return Files.isRegularFile(Paths.get(filePath), LinkOption.NOFOLLOW_LINKS);
	}
	
	/**Verifies the path is a symbolic link
	 * @param filePath String file or directory path
	 * @throws NullPointerException if String argument is null or empty*/
	public static boolean isSymbolic(String filePath) {
		if (null == filePath && filePath.length() == 0)
			throw new NullPointerException("File path argument is null or empty");
		return Files.isSymbolicLink(Paths.get(filePath));
	}
	
	/**Private constructor*/
	private PathValidator() {}
	
	public String toString() { return "Path (Directory or File) Validator"; }
}
