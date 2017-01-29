package com.mmoneib.algtoolbox.week3;

import java.util.*;

public class CoveringSegments {

	protected static int[] optimalPoints(Segment[] segments) {
		ArrayList<Integer> points = new ArrayList<>();
		int currentPoint = Integer.MAX_VALUE;
		int count = 0;
		Segment tempSegment = null;

		while (count < segments.length) {
			for (Segment segment : segments) {
				if (segment.end < currentPoint) {
					currentPoint = segment.end;
					tempSegment = segment;
				}
			}

			if (points.size() == 0 || !(tempSegment.start <= points.get(points.size() - 1))
					&& (tempSegment.end >= points.get(points.size() - 1))) {
				currentPoint = tempSegment.end;
				points.add(currentPoint);
			}

			tempSegment.end = Integer.MAX_VALUE;
			currentPoint = Integer.MAX_VALUE;
			count++;
		}

		/*
		 * int[] points = new int[2 * segments.length]; for (int i = 0; i <
		 * segments.length; i++) { points[2 * i] = segments[i].start; points[2 *
		 * i + 1] = segments[i].end; }
		 */
		int[] pointsArr = new int[points.size()];
		for (int i = 0; i < points.size(); i++) {
			pointsArr[i] = points.get(i);
		}

		return pointsArr;
	}

	protected static class Segment {
		int start, end;

		Segment(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Segment[] segments = new Segment[n];
		for (int i = 0; i < n; i++) {
			int start, end;
			start = scanner.nextInt();
			end = scanner.nextInt();
			segments[i] = new Segment(start, end);
		}
		int[] points = optimalPoints(segments);
		System.out.println(points.length);
		for (int point : points) {
			System.out.print(point + " ");
		}
	}
}
