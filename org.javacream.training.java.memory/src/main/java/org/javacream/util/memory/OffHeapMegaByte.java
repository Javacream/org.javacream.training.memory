package org.javacream.util.memory;

import java.io.Serializable;
import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class OffHeapMegaByte implements Serializable {
	private static final long serialVersionUID = 1L;
	private Unsafe unsafe;

	{
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(null);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	private final static int BYTE = 1;
	private long size;
	private long address;

	public OffHeapMegaByte(int mByte) {
		try {
			this.size = mByte * 1024 * 1024;
			address = unsafe.allocateMemory(size * BYTE);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	public void set(long i, byte value) throws NoSuchFieldException, IllegalAccessException {
		unsafe.putByte(address + i * BYTE, value);
	}

	public int get(long idx) throws NoSuchFieldException, IllegalAccessException {
		return unsafe.getByte(address + idx * BYTE);
	}

	public long size() {
		return size;
	}

	public void freeMemory() throws NoSuchFieldException, IllegalAccessException {
		unsafe.freeMemory(address);
	}
}