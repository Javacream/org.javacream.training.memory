package org.javacream.util.memory;

import java.io.Serializable;
import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class OffHeapMegaByte implements Serializable, MegaByte {
	private static final long serialVersionUID = 1L;
	private Unsafe unsafe;

	private final static int BYTE = 1;
	private long size;
	private long address;

	public OffHeapMegaByte(int mByte) {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			unsafe = (Unsafe) f.get(null);
			size = mByte * 1024 * 1024;
			address = unsafe.allocateMemory(size * BYTE);
			unsafe.setMemory(address, size, (byte) 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void set(int i, byte value) throws NoSuchFieldException, IllegalAccessException {
		unsafe.putByte(address + i * BYTE, value);
	}

	@Override
	public int get(int i) throws NoSuchFieldException, IllegalAccessException {
		return unsafe.getByte(address + i * BYTE);
	}

	@Override
	public long size() {
		return size;
	}

	public void freeMemory() throws NoSuchFieldException, IllegalAccessException {
		unsafe.freeMemory(address);
	}
}