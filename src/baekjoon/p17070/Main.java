package baekjoon.p17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int[] pos = {0, 0, 0, 1};
	private static int[][] graph;
	private static int N;
	private static int count = 0;

	private static int[][] horMove = new int[][]{{0, 1, 0, 1}, {0, 1, 1, 1}}; // 가로
	private static int[][] verMove = new int[][]{{1, 0, 1, 0}, {1, 0, 1, 1}}; // 세로
	private static int[][] diaMove = new int[][]{{1, 1, 0, 1}, {1, 1, 1, 0}, {1, 1, 1, 1}}; // 대각선



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];

		initGraph(br);
		dfs();
		System.out.println(count);
	}

	private static void initGraph(BufferedReader br) throws IOException {
		for (int i = 0; i < N; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
	}

	private static void dfs() {
		int status = getStatus();

		if (pos[2] == N - 1 && pos[3] == N - 1) {
			count++;
			return;
		}

		if (status == 0) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					pos[j] += horMove[i][j];
				}
				if (isValidate()) dfs();
				for (int j = 0; j < 4; j++) {
					pos[j] -= horMove[i][j];
				}
			}
		} else if (status == 1) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					pos[j] += verMove[i][j];
				}
				if (isValidate()) dfs();
				for (int j = 0; j < 4; j++) {
					pos[j] -= verMove[i][j];
				}
			}
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					pos[j] += diaMove[i][j];
				}
				if (isValidate()) dfs();
				for (int j = 0; j < 4; j++) {
					pos[j] -= diaMove[i][j];
				}
			}
		}
	}

	private static int getStatus() {
		if (pos[0] == pos[2]) return 0; // 가로
		if (pos[1] == pos[3]) return 1; // 세로
		return 2; // 대각선
	}

	private static boolean isValidate() {
		int status = getStatus();
		for (int i = 0; i < 4; i++) {
			if (pos[i] < 0 || pos[i] >= N) return false;
		}
		if (graph[pos[0]][pos[1]] == 1) return false;
		if (graph[pos[2]][pos[3]] == 1) return false;

		if (status == 2) {
			if (graph[pos[0]][pos[1] + 1] == 1) return false;
			if (graph[pos[0] + 1][pos[1]] == 1) return false;
		}
		return true;
	}
}
