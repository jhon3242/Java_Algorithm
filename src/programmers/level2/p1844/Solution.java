package programmers.level2.p1844;

import java.util.*;

class Solution {
	private static int[][] newMap;
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};

	private void dfs(int x, int y, int moveCount) {

		for (int i = 0; i < 4; i++) {
			int tx = dx[i] + x;
			int ty = dy[i] + y;
			if (tx < 0 || ty < 0 || tx >= newMap.length || ty >= newMap[tx].length) {
				continue;
			}

			if (this.newMap[tx][ty] == 0 || (tx == 0 && ty == 0)) {
				continue;
			}

			if (this.newMap[tx][ty] != 1 && this.newMap[tx][ty] < moveCount) {
				continue;
			}

			this.newMap[tx][ty] = moveCount + 1;
			dfs(tx, ty, moveCount + 1);
		}
	}

	public int solution(int[][] maps) {
		int answer = 0;

		if (maps.length == 1 && maps[0].length == 1) return 1;

		newMap = new int[maps.length][maps[0].length];
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				newMap[i][j] = maps[i][j];
			}
		}

		dfs(0, 0, 1);

		// if (this.newMap[this.newMap.length - 1][this.newMap[0].length -1] == 1) return -1;
		// return this.newMap[this.newMap.length - 1][this.newMap[0].length -1];


		for (int i = 0; i < this.newMap.length; i++) {
			System.out.println(Arrays.toString(this.newMap[i]));
		}
		return 0;
	}
}
