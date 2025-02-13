package main.study.practice.sort;

import java.util.function.Supplier;

public class SetTimeNanoSupplier implements Supplier<Long> {
	
	@Override
	public Long get() {
		return System.nanoTime();
	}

}
