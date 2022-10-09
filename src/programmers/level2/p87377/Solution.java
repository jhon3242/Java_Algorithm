package programmers.level2.p87377;

import java.util.*;

class Solution {
	public String[] solution(int[][] line) {
		String[] answer = {};
		List<long[]> points = new ArrayList<>();
		long maxX = Long.MIN_VALUE;
		long maxY = Long.MIN_VALUE;
		long minX = Long.MAX_VALUE;
		long minY = Long.MAX_VALUE;

		for (int i = 0; i < line.length; i++) {
			long a = line[i][0];
			long b = line[i][1];
			long e = line[i][2];
			for (int j = i + 1; j < line.length; j++) {
				long c = line[j][0];
				long d = line[j][1];
				long f = line[j][2];

				long xUp = b*f - e*d;
				long xDown = a*d - b*c;
				long yUp = e*c - a*f;
				long yDown = a*d - b*c;

				if (xDown == 0 || xUp % xDown != 0 || yUp % yDown != 0)
					continue;
				long x = xUp / xDown;
				long y = yUp / yDown;
				maxX = Math.max(maxX, x);
				minX = Math.min(minX, x);
				maxY = Math.max(maxY, y);
				minY = Math.min(minY, y);
				points.add(new long[]{x, y});
			}
		}
		int c_size = (int)(Math.abs(maxX - minX)) + 1; // x 좌표는 Col
		int r_size = (int)(Math.abs(maxY - minY)) + 1;

		// System.out.println("c_size = " + c_size);
		// System.out.println("r_size = " + r_size);
		boolean[][] tmpGraph = new boolean[r_size][c_size];

		for (long[] p : points){
			int tx = (int)(p[0] - minX);
			int ty = (int)(p[1] - maxY);
			tmpGraph[Math.abs(ty)][tx] = true;
		}

		int i = 0;
		answer = new String[tmpGraph.length];
		for (boolean[] gr : tmpGraph){
			StringBuilder sb = new StringBuilder();
			for (boolean g : gr){
				if (g)
					sb.append("*");
				else
					sb.append(".");
			}
			answer[i] = sb.toString();
			i++;
		}

		return answer;
	}
}