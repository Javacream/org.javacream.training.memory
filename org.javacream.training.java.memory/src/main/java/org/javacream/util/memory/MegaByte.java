package org.javacream.util.memory;

public interface MegaByte {

	void set(int i, byte value) throws NoSuchFieldException, IllegalAccessException;

	int get(int i) throws NoSuchFieldException, IllegalAccessException;

	long size();

}