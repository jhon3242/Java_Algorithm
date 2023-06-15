package programmers.level2.p17679;

import java.util.*;

class Solution {
	private char[][] graph;
	private boolean[][] visited;
	private int M;
	private int N;


	public int solution(int m, int n, String[] board) {
		int answer = 0;
		int removeCount = 0;
		this.graph = new char[m][n];

		this.M = m;
		this.N = n;

		for (int i = 0 ; i < M; i++) {
			graph[i] = board[i].toCharArray();
		}



		while (true) {
			this.visited = new boolean[m][n];

			// remove update
			for (int i = 0;  i < M - 1; i++) {
				for (int j = 0 ; j < N - 1; j++) {
					check(i, j);
				}
			}



			// count remove block
			removeCount = 0;
			for (int i = 0;  i < M; i++) {
				for (int j = 0 ; j < N; j++) {
					if (this.visited[i][j]) {
						removeCount++;
						graph[i][j] = '.';
					}
				}
			}

			answer += removeCount;

			// remove block
			for (int i = 0 ; i < N; i++) {
				goDown(i);
			}


			if (removeCount == 0) break;
		}

		return answer;
	}

	// 2*2 확인하여 붙어있는 경우 visited 업데이트
	private void check(int x, int y) {
		int[] dx = new int[]{0, 1, 1};
		int[] dy = new int[]{1, 0, 1};
		char target = graph[x][y];

		for (int i = 0; i < 3; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];

			if (tx < 0 || ty < 0 || tx >= M || ty >= N) return;
			if (graph[tx][ty] == '.') return;
			if (graph[tx][ty] != target) return;
		}

		visited[x][y] = true;
		for (int i = 0; i < 3; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			visited[tx][ty] = true;
		}

		// result += 4;
	}

	private void goDown(int row) {
		List<Character> tmp = new ArrayList<>();

		for (int i = M - 1 ; i >= 0 ; i--) {
			if (graph[i][row] != '.') {
				tmp.add(graph[i][row]);
			}
		}
		while (tmp.size() < M) {
			tmp.add('.');
		}

		for (int i = M - 1 ; i >= 0 ; i--) {
			graph[i][row] = tmp.get(M - 1 - i);
		}
	}
}