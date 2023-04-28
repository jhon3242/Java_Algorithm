package programmers.level2.p81302;

/**
 * 2회차
 * 정확성: 76.3
 * 합계: 76.3 / 100.0
 * bfs 로 구현헀는데 POP 인 경우 visited = [true, false, true]
 * O 위치에서 왼쪽 P 로 가면 안되고 오른쪽 P 로 가는 경우에는 fail 인데 구분하기가 힘들다
 * 따라서 dfs 로 구현해야할듯하다.
 */

import java.util.*;

class Solution {
	private static final int N = 5;
	private static Queue<int[]> qu;
	private static String[] place;
	private static boolean[][] visited;


	public int[] solution(String[][] places) {
		int[] answer = new int[5];


		for (int i = 0; i < N; i++) {
			init(places[i]);
			if (bfs()) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
			// System.out.println();
		}

		// System.out.println(Arrays.deepToString(visited));

		return answer;
	}

	private void init(String[] place) {
		this.qu = new LinkedList<>();
		this.place = place;
		visited = new boolean[N][N];

		for (int i = 0 ; i < N; i++) {
			String line = place[i];
			for (int j = 0; j < N; j++) {
				if (line.charAt(j) == 'P') {
					addCandidate(i, j);
				}
			}
		}
	}

	private void addCandidate(int i, int j) {
		final int[] dx = {0, 1, 0, -1};
		final int[] dy = {1, 0, -1, 0};

		visited[i][j] = true;

		for (int k = 0 ; k < 4; k++) {
			int tx = dx[k] + i;
			int ty = dy[k] + j;

			if (tx < 0 || ty < 0 || tx >= N || ty >= N || visited[tx][ty]) continue;
			qu.add(new int[]{1, tx, ty});
		}
	}

	private boolean bfs() {
		while (!qu.isEmpty()) {
			int[] poped = qu.poll();
			visited[poped[1]][poped[2]] = true;
			if (place[poped[1]].charAt(poped[2]) == 'P') {
				// System.out.println("false x = " +poped[1] + " y = " + poped[2]);
				return false;
			}
			if (place[poped[1]].charAt(poped[2]) == 'X') continue;


			if (poped[0] < 2 && place[poped[1]].charAt(poped[2]) == 'O') {
				final int[] dx = {0, 1, 0, -1};
				final int[] dy = {1, 0, -1, 0};

				for (int k = 0 ; k < 4; k++) {
					int tx = dx[k] + poped[1];
					int ty = dy[k] + poped[2];

					if (tx < 0 || ty < 0 || tx >= N || ty >= N || visited[tx][ty]) continue;
					visited[tx][ty] = true;
					// if (place[tx].charAt(ty) == 'P') return false;
					// if (place[tx].charAt(ty) == 'X') continue;
					// System.out.println("from " + poped[1] + " " + poped[2] + " add " + tx + " " + ty);
					qu.add(new int[]{poped[0] + 1, tx, ty});
				}
			}
		}
		// System.out.println();
		return true;
	}
}