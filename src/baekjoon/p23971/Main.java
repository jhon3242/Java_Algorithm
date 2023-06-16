package baekjoon.p23971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int H;
	private static int W;
	private static int N;
	private static int M;
	private static int[][] graph;
	private static int result = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[H][W];
		graph[0][0] = 1;
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<Node> qu = new LinkedList<>();
		int[] dx = new int[]{0, N + 1, 0, -N - 1};
		int[] dy = new int[]{M + 1, 0, -M - 1, 0};

		qu.add(new Node(0, 0));
		while (!qu.isEmpty()) {
			Node poll = qu.poll();

			for (int i = 0; i < 4; i++) {
				int tx = dx[i] + poll.x;
				int ty = dy[i] + poll.y;

				if (tx < 0 || ty < 0 || tx >= H || ty >= W) {
					continue;
				}
				if (graph[tx][ty] == 1) {
					continue;
				}
				graph[tx][ty] = 1;
				result++;
				qu.add(new Node(tx, ty));
			}
		}
	}

	static class Node {
		public int x;
		public int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
