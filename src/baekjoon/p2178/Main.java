package baekjoon.p2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}

		bfs();

		System.out.println(graph[N - 1][M - 1]);
	}

	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dx = new int[]{0, 1, 0, -1};
		int[] dy = new int[]{1, 0, -1, 0};
		pq.add(new Node(0, 0, 1));

		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			if (graph[poll.x][poll.y] == 1) {
				graph[poll.x][poll.y] = poll.cost;

				if (poll.x == N - 1 && poll.y == M - 1) return;

				for (int i = 0; i < 4; i++) {
					int tx = dx[i] + poll.x;
					int ty = dy[i] + poll.y;
					if (tx < 0 || ty < 0 || tx >= N || ty >= M || graph[tx][ty] != 1) continue;
					if (tx == 0 && ty == 0) continue;
					pq.add(new Node(tx, ty, poll.cost + 1));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
}
