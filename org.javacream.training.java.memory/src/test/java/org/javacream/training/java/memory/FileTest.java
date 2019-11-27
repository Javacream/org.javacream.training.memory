package org.javacream.training.java.memory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.javacream.util.memory.ByteArrayMegaByte;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileTest {

	private static ByteArrayMegaByte data;
	@BeforeClass public static void init() {
		data = new ByteArrayMegaByte(500);
	}
	
	@Test public void testTmpFile() throws IOException {
		Files.write(Paths.get("/tmp/data.ser"), data.getMegabyte(), StandardOpenOption.CREATE_NEW, StandardOpenOption.DELETE_ON_CLOSE);
	}
	@Test public void testSolidStateFile() throws IOException {
		Files.write(Paths.get("/home/rainer/data.ser"), data.getMegabyte(), StandardOpenOption.CREATE_NEW, StandardOpenOption.DELETE_ON_CLOSE);
	}
	@Test public void testHarddriveFile() throws IOException {
		Files.write(Paths.get("/media/rainer/Data/data.ser"), data.getMegabyte(), StandardOpenOption.CREATE_NEW, StandardOpenOption.DELETE_ON_CLOSE);
	}
}
