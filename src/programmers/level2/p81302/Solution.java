package programmers.level2.p81302;

/**
 * 3회차 통과
 * dfs 로 구현하여 통과
 */

import java.util.*;

class Solution {
	private static final int N = 5;
	private static final int[] dx = new int[] {0, 1, 0, -1};
	private static final int[] dy = new int[] {1, 0, -1, 0};
	private static boolean[][] visited;
	private static char[][] graph;
	private static boolean fail;

	public int[] solution(String[][] places) {
		int[] answer = new int[N];


		for (int i = 0 ; i < N; i++) {
			init(places[i]);
			check();
			if (fail) {
				answer[i] = 0;
			} else {
				answer[i] = 1;
			}
		}

		// System.out.println(Arrays.deepToString(graph));
		return answer;
	}

	private void init(String[] place) {
		visited = new boolean[N][N];
		graph = new char[N][N];
		fail = false;
		for (int i = 0 ; i < N; i++) {
			graph[i] = place[i].toCharArray();
		}
	}

	private void dfs(int x, int y, int level) {

		if (level == 2) {
			if (graph[x][y] == 'P') {
				fail = true;
			}
			return ;
		}

		for (int i = 0 ; i < 4; i ++) {
			int tx = dx[i] + x;
			int ty = dy[i] + y;

			if (tx < 0 || ty < 0 || tx >= N || ty >= N || visited[tx][ty]) continue;
			if (graph[tx][ty] == 'P') {
				fail = true;
				return ;
			}
			if (graph[tx][ty] == 'O') {
				visited[tx][ty] = true;
				dfs(tx, ty, level + 1);
				visited[tx][ty] = false;
			}
		}
	}

	private void check() {
		for (int x = 0; x < N; x++) {
			for (int y = 0 ;y < N; y++) {
				if (graph[x][y] == 'P') {
					visited[x][y] = true;
					dfs(x, y, 0);
					if (fail) return ;
					visited[x][y] = false;
				}
			}
		}
	}

	// private void printV() {
	//     for (boolean[] v : visited) {
	//         System.out.println(Arrays.toString(v));
	//     }
	//     System.out.println();
	// }
}