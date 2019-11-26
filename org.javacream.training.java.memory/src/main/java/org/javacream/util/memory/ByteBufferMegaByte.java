package org.javacream.util.memory;

import java.nio.ByteBuffer;

public class ByteBufferMegaByte implements MegaByte {

	private ByteBuffer byteBuffer;
	
	
	public ByteBufferMegaByte(int megaByte) {
		byteBuffer = ByteBuffer.allocate(megaByte * 1024 * 1024);
	}

	@Override
	public void set(int i, byte value) throws NoSuchFieldException, IllegalAccessException {
		byteBuffer.put(i, value);
	}

	@Override
	public int get(int i) throws NoSuchFieldException, IllegalAccessException {
		return byteBuffer.get(i);
	}

	@Override
	public long size() {
		return byteBuffer.capacity();
	}

}
