package baekjoon.p1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static char[][] graph;
	private static boolean[][] visited;
	private static int[] dx = new int[]{0, 1, 0, -1};
	private static int[] dy = new int[]{1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int wTeam = 0;
		int bTeam = 0;

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					int count = bfs(i, j, graph[i][j]);
					if (graph[i][j] == 'W') wTeam += count;
					else bTeam += count;
				}
			}
		}
		System.out.println(wTeam + " " + bTeam);

	}

	private static int bfs(int x, int y, char team) {
		Queue<Integer[]> q = new LinkedList<>();
		int count = 0;
		q.add(new Integer[]{x, y});
		while (!q.isEmpty()) {
			Integer[] poll = q.poll();
			int nx = poll[0];
			int ny = poll[1];

			if (!visited[nx][ny]) {
				visited[nx][ny] = true;
				count++;

				for (int i = 0; i < 4; i++) {
					int tx = dx[i] + nx;
					int ty = dy[i] + ny;
					if (tx < 0 || ty < 0 || tx >= N || ty >= M || visited[tx][ty]) continue;
					if (graph[tx][ty] != team) continue;
					q.add(new Integer[]{tx, ty});
				}
			}
		}
		return count * count;
	}
}
