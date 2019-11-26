package org.javacream.util.memory;

import java.io.Serializable;

/**
 * One MegaByte instance consumes 1 MByte memory
 * 
 * @author Dr. Rainer Sawitzki
 * 
 */
public class MegaByte implements Serializable{
	private static final long serialVersionUID = 1L;

	private byte[] megabyte;

	public byte[] getMegabyte() {
		return megabyte;
	}

	public MegaByte(int mByte) {
		megabyte = new byte[mByte*1024*1024];
	}

}