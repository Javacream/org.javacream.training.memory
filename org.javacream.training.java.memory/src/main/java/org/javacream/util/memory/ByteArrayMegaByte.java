package org.javacream.util.memory;

import java.io.Serializable;

public class ByteArrayMegaByte implements Serializable, MegaByte {
	private static final long serialVersionUID = 1L;

	private byte[] megabyte;

	public byte[] getMegabyte() {
		return megabyte;
	}

	public ByteArrayMegaByte(int mByte) {
		megabyte = new byte[mByte * 1024 * 1024];
	}

	@Override
	public void set(int i, byte value) throws NoSuchFieldException, IllegalAccessException {
		megabyte[i] = value;
	}

	@Override
	public int get(int i) throws NoSuchFieldException, IllegalAccessException {
		return megabyte[i];
	}

	@Override
	public long size() {
		return megabyte.length;
	}

}