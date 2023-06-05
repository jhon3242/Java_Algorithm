package baekjoon.p1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int N;
	private static int[][] graph;
	private static long[][] resultG;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		resultG = new long[N][N];

		for (int i = 0; i < N; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		long result = dfs(0, 0);
		System.out.println(result);

	}

	private static long dfs(int x, int y) {
		long count = 0;

		if (resultG[x][y] != 0) {
			return resultG[x][y];
		}

		if (x == N - 1 && y == N - 1) {
			return 1;
		}

		int moveCount = graph[x][y];
		if (moveCount == 0) {
			return 0;
		}

		int tx = x + moveCount;
		int ty = y + moveCount;

		// right move
		if (0 <= ty && ty < N) {
			count += dfs(x, ty);
		}

		// down move
		if (0 <= tx && tx < N) {
			count += dfs(tx, y);
		}
		resultG[x][y] = count;

		return count;
	}
}
