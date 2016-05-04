package com.gmail.ichglauben.pathvalidator.core.concretes;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathValidator {
	public static boolean pathExists(String filePath) {
		Path path = null;
		if (null != filePath) {
			if (null != (path = Paths.get(filePath))) {
				return (path.toFile().exists() && (path.toFile().isDirectory() || path.toFile().isFile()));
			}
		}
		return false;
	}
	
	private PathValidator() {}
	
	public String toString() { return "Path (Directory or File) Validator"; }
}
