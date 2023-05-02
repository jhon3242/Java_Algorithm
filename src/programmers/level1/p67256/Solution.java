package programmers.level1.p67256;

import java.util.*;

class Solution {
	private final int[][] graph = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
	private int[] lPos = new int[]{3, 0};
	private int[] rPos = new int[]{3, 2};

	public String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();

		// int re = getDis(lPos, getPos(3));
		// System.out.println(re);

		for (int num : numbers) {
			int[] tmpPos = getPos(num);
			// System.out.println("num " + num + " pos " + Arrays.toString(tmpPos));
			if (tmpPos[1] == 0) {
				// System.out.println("LLL");
				answer.append("L");
				lPos = tmpPos;
			} else if (tmpPos[1] == 2) {
				// System.out.println("RRR");
				answer.append("R");
				rPos = tmpPos;
			} else {

				int lDis = getDis(tmpPos, lPos);
				int rDis = getDis(tmpPos, rPos);
				if (lDis < rDis || (lDis == rDis && hand.equals("left"))) {
					answer.append("L");
					lPos = tmpPos;
				} else {
					answer.append("R");
					rPos = tmpPos;
				}
				// System.out.println("num " + num + " pos " + Arrays.toString(tmpPos) + "\n");
				// System.out.println(Arrays.toString(getPos(5)));
				// System.out.println("numPos " + Arrays.toString(tmpPos));
				// System.out.println("lPos " + Arrays.toString(lPos));
				// System.out.println("rPos " + Arrays.toString(rPos));
				// System.out.println("lDis " + lDis + " rDis " + rDis);
			}
		}
		// String r = Arrays.toString(getPos(9));
		// System.out.println(r);
		return answer.toString();
	}

	private int[] getPos(int num) {
		if (num < 0) return null;
		for (int x = 0; x < 4; x ++) {
			for (int y = 0 ; y < 3; y++) {
				if (graph[x][y] == num) {
					return new int[]{x, y};
				}
			}
		}
		return null;
	}

	private int getDis(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}