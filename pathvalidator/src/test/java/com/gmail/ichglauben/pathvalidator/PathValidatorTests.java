package com.gmail.ichglauben.pathvalidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.gmail.ichglauben.pathvalidator.core.concretes.PathValidator;

public class PathValidatorTests {
	ClassLoader loader = getClass().getClassLoader();
	String separator = FileSystems.getDefault().getSeparator();
	String home = System.getProperty("user.home") + separator;
	File lrg = new File(loader.getResource("large.gif").getFile());
	File med = new File(loader.getResource("medium.gif").getFile());
	File sma = new File(loader.getResource("small.gif").getFile());
	
	@Test
	public void testPathExistsMethod() {
		assertTrue("home does not exist", PathValidator.pathExists(home));
		
		assertTrue(lrg + " does not exist", PathValidator.pathExists(lrg.getAbsolutePath()));
		
		assertTrue(med + " does not exist", PathValidator.pathExists(med.getAbsolutePath()));
		
		assertTrue(sma + " does not exist", PathValidator.pathExists(sma.getAbsolutePath()));
		
		assertFalse(PathValidator.pathExists("mydirectory"));
	}
	
	@Test (expected = NullPointerException.class)	
	public void testPathExistsEmptyString() {
		PathValidator.pathExists("");
	}
	
	@Test (expected = NullPointerException.class)	
	public void testPathExistsNullString() {
		PathValidator.pathExists(null);
	}
	
	@Test (expected = NullPointerException.class)	
	public void testPathExistsNullPathString() {
		PathValidator.pathExists(Paths.get("").toString());
	}

	@Test
	public void testIsADirectoryMethod() {
		assertTrue(home + " not a directory", PathValidator.isADirectory(home));
		
		assertFalse(lrg.toPath().getFileName() + " is a directory", PathValidator.isADirectory(lrg.getAbsolutePath()));
		
		assertTrue(med.getParent() + " not a directory", PathValidator.isADirectory(med.getParent()));		
	}	
	
	@Test (expected=NullPointerException.class)
	public void testIsADirectoryNullArgument() {
		PathValidator.isADirectory(null);
	}
	
	@Test (expected=NullPointerException.class)
	public void testIsADirectoryEmptyArgument() {
		PathValidator.isADirectory("");
	}
	
	@Test (expected=NullPointerException.class)
	public void testIsADirectoryNullPathArgument() {
		PathValidator.isADirectory(Paths.get("").toString());
	}
	
	@Test
	public void testIsAFileMethod() {
		assertTrue(lrg.toPath().getFileName() + " is not a file", PathValidator.isAFile(lrg.getAbsolutePath()));
		
		assertTrue(med.toPath().getFileName() + " is not a file", PathValidator.isAFile(med.getAbsolutePath()));
		
		assertTrue(sma.toPath().getFileName() + " is not a file", PathValidator.isAFile(sma.getAbsolutePath()));
		
		assertFalse(home + " is a file", PathValidator.isAFile(home));
	}
	
	@Test(expected = NullPointerException.class)
	public void testIsAFileNullArgument() {
		PathValidator.isAFile(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testIsAFileEmptyArgument() {
		PathValidator.isAFile("");
	}
	
	@Test(expected = NullPointerException.class)
	public void testIsAFileNullPathArgument() {
		PathValidator.isAFile(Paths.get("").toString());
	}	
}
