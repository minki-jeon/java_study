package main.study.practice.sort;

import java.util.function.Supplier;

public class SetTimeMillisSupplier implements Supplier<Long> {
	
	@Override
	public Long get() {
		return System.currentTimeMillis();
	}

}
