package org.javacream.training.java.memory;

import org.javacream.util.memory.ByteBufferMegaByte;
import org.javacream.util.memory.MegaByte;
import org.junit.Test;

public class ByteBufferMemoryTest {
	@Test
	public void testMegaByteAllocation() {
		Runtime runtime = Runtime.getRuntime();
		System.gc();
		long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
		@SuppressWarnings("unused")
		MegaByte megaByte = new ByteBufferMegaByte(500);
		long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
		System.gc();
		System.out.println("usedMemoryBefore: " + usedMemoryBefore + ", usedMemoryAfter: " + usedMemoryAfter);
		megaByte = null;
		System.gc();
		long usedMemoryAfterGc = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("usedMemoryBefore: " + usedMemoryBefore + ", usedMemoryAfterGc: " + usedMemoryAfterGc);
	}
}
