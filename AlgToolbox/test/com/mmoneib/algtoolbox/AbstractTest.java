package com.mmoneib.algtoolbox;

import java.util.Date;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractTest {
	Date before;
	Date after;

	@Before
	public void beofre() {
		before = new Date();
	}

	@After
	public void after() {
		after = new Date();
		System.out.println("Time elapsed: "
				// + String.format("%d",
				// TimeUnit.MILLISECONDS.toSeconds(after.getTime() -
				// before.getTime())));
				+ String.valueOf(after.getTime() - before.getTime()));
	}
}
