package baekjoon.p1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[][] graph;
	private static int maxCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		graph = new int[N][M];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x - 1][y - 1] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		System.out.println(maxCount);
	}

	private static void bfs(int x, int y) {
		Queue<Integer[]> q = new LinkedList<>();
		int[] dx = new int[]{0, 1, 0, -1};
		int[] dy = new int[]{1, 0, -1, 0};
		int count = 0;

		q.add(new Integer[]{x, y});
		while (!q.isEmpty()) {
			Integer[] poll = q.poll();
			int px = poll[0];
			int py = poll[1];
			if (graph[px][py] == 1) {
				graph[px][py] = -1;
				count++;
				for (int i = 0; i < 4; i++) {
					int tx = px + dx[i];
					int ty = py + dy[i];

					if (tx < 0 || ty < 0 || tx >= N || ty >= M) continue;

					if (graph[tx][ty] == 1) {
						q.add(new Integer[]{tx, ty});
					}
				}
			}
		}

		maxCount = Math.max(maxCount, count);
	}
}
