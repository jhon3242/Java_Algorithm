package baekjoon.p1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int N;
	private static int[][] graph;
	private static long result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		dfs(0, 0);
		System.out.println(result);

	}

	private static void dfs(int x, int y) {

		if (x == N - 1 && y == N - 1) {
			result++;
			return;
		}

		int moveCount = graph[x][y];
		if (moveCount == 0) {
			return;
		}

		int tx = x + moveCount;
		int ty = y + moveCount;

		// right move
		if (0 <= ty && ty < N) {
			dfs(x, ty);
		}

		// down move
		if (0 <= tx && tx < N) {
			dfs(tx, y);
		}
	}
}
