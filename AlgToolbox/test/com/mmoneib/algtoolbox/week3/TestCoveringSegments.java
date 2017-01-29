package com.mmoneib.algtoolbox.week3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mmoneib.algtoolbox.AbstractTest;
import com.mmoneib.algtoolbox.week3.CoveringSegments.Segment;

public class TestCoveringSegments extends AbstractTest {

	@Test
	public void testOptimalPoints() {
		try {
			Segment[] segments1 = { new Segment(1, 3), new Segment(2, 5), new Segment(3, 6) };
			assertArrayEquals(new int[] { 3 }, CoveringSegments.optimalPoints(segments1));

			Segment[] segments2 = { new Segment(4, 7), new Segment(1, 3), new Segment(2, 5), new Segment(5, 6) };
			assertArrayEquals(new int[] { 3, 6 }, CoveringSegments.optimalPoints(segments2));
		} catch (Exception exception) {
			exception.printStackTrace();
			fail("Error: " + exception.getMessage());
		}
	}

}
