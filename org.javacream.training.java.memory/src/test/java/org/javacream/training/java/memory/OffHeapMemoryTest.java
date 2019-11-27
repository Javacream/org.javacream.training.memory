package org.javacream.training.java.memory;

import org.javacream.util.memory.OffHeapMegaByte;
import org.junit.Test;

public class OffHeapMemoryTest {
	@Test
	public void testMegaByteAllocation() {
		Runtime runtime = Runtime.getRuntime();
		System.gc();
		long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
		@SuppressWarnings("unused")
		OffHeapMegaByte megaByte = new OffHeapMegaByte(500);
		long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
		System.gc();
		System.out.println("usedMemoryBefore: " + usedMemoryBefore + ", usedMemoryAfter: " + usedMemoryAfter);
		megaByte = null;
		System.gc();
		long usedMemoryAfterGc = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("usedMemoryBefore: " + usedMemoryBefore + ", usedMemoryAfterGc: " + usedMemoryAfterGc);
		//uncomment to block test execution
		/*
		Object sync = new Object();
		synchronized(sync) {
			try {
				sync.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
	}
}
