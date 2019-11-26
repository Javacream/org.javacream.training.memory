package org.javacream.training.java.memory;

import org.javacream.util.memory.OffHeapMegaByte;
import org.junit.Test;

public class MegaByteTest {
	@Test
	public void testMegaByteAllocation() {
		Runtime runtime = Runtime.getRuntime();
		System.gc();
		long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
		@SuppressWarnings("unused")
		OffHeapMegaByte megaByte = new OffHeapMegaByte(500);
		long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
		System.gc();
		System.out.println("usedMemoryBefore: " + usedMemoryBefore + ", usedMemoryAfter" + usedMemoryAfter);
		megaByte = null;
		System.gc();
		long usedMemoryAfterGc = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("usedMemoryBefore: " + usedMemoryBefore + ", usedMemoryAfterGc" + usedMemoryAfterGc);
		
	}
}
