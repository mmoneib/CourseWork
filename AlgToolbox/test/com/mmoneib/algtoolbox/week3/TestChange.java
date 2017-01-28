package com.mmoneib.algtoolbox.week3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mmoneib.algtoolbox.AbstractTest;

public class TestChange extends AbstractTest {

	@Test
	public void testGetChange() {
		try{
			assertEquals(2, Change.getChange(2));
			assertEquals(6, Change.getChange(28));
		}catch(Exception exception){
			exception.printStackTrace();
			fail("Error: "+exception.getMessage());
		}
	}

}
