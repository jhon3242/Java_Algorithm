package baekjoon.p17086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[][] graph;
	private static int result = 0;
	private static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
	private static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) {
					bfs(i, j);
				}
			}
		}

		System.out.println(result);
	}

	private static void bfs(int x, int y) {
		visited = new boolean[N][M];
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(x, y, 0));
		while (!pq.isEmpty()) {
			Node poll = pq.poll();


			if (visited[poll.x][poll.y]) continue;

			visited[poll.x][poll.y] = true;

			if (graph[poll.x][poll.y] == 1) {
				result = Math.max(result, poll.level);
				return;
			}

			for (int i = 0; i < 8; i++) {
				int tx = dx[i] + poll.x;
				int ty = dy[i] + poll.y;

				if (tx < 0 || ty < 0 || tx >= N || ty >= M || visited[tx][ty]) continue;
				pq.add(new Node(tx, ty, poll.level + 1));
			}
		}
	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int level;

		public Node(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}


		@Override
		public int compareTo(Node o) {
			return level - o.level;
		}
	}
}
