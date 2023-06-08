package baekjoon.p16197;

import tmp.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int result = Integer.MAX_VALUE;
	private static int[] dx = new int[]{-1, 0, 1, 0};
	private static int[] dy = new int[]{0, 1, 0, -1};
	private static int coin = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] graph = new char[N][M];

		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < 4; i++) {
			dfs(1, i, graph);
		}
		System.out.println(result);
	}

	private static void dfs(int level, int dir, char[][] curGraph) {

		char[][] moveGraph = move(curGraph, dir);
		if (isSame(curGraph, moveGraph)) return;
		if (coin < 2) {
			if (coin == 1) {
				result = Math.min(result, level);
			}
			coin = 2;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (isRoop(i, dir)) continue;
			dfs(level + 1, i, moveGraph);
		}
	}

	private static char[][] move(char[][] graph, int dir) {
		char[][] result = new char[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = graph[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 'o') {
					int tx = i + dx[dir];
					int ty = j + dy[dir];

					// out
					if (tx < 0 || ty < 0 || tx >= N || ty >= M) {
						result[i][j] = '.';
						coin--;
						continue;
					}

					// wall
					if (graph[tx][ty] == '#') {
						if (result[i][j] == 'o') {
							coin = -1;
							return result;
						}
						result[i][j] = 'o';
						continue;
					}

					// coin
					if (result[tx][ty] == 'o') {
						coin = -1;
						return result;
					}
					result[tx][ty] = 'o';
					result[i][j] = '.';
					continue;
				}
				result[i][j] = graph[i][j];
			}
		}
		return result;
	}

	private static boolean isRoop(int newDir, int dir) {
		return (newDir + 2) % 4 == dir;
	}

	private static boolean isSame(char[][] graph, char[][] move) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] != move[i][j]) return false;
			}
		}
		return true;

	}
}
