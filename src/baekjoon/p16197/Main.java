package baekjoon.p16197;

import tmp.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;



public class Main {
	private static int N;
	private static int M;
	private static int result = Integer.MAX_VALUE;
	private static int[] dx = new int[]{-1, 0, 1, 0};
	private static int[] dy = new int[]{0, 1, 0, -1};
	private static final int Up = 0;
	private static final int Right = 1;
	private static final int Down = 2;
	private static final int Left = 3;
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
			getMove(graph, i);
		}


		System.out.println(result);
	}

	private static void dfs(char[][] graph, int level, int dir) {
		int coinCount = 0;//getCount(graph);
		if (coinCount < 2) {
			if (coinCount == 1) {
				// update result
				result = Math.min(result, level);
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (i == (dir + 2) % 4) {
				continue;
			}
			getMove(graph, i);
//			dfs(graph, level + 1, i);
		}

	}

	private static char[][] getMove(char[][] cur, int dir) {
		char[][] result = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int tx = dx[dir] + i;
				int ty = dy[dir] + j;

				if (tx < 0 || ty < 0 || tx >= N || ty >= M) {
					continue;
				}
				result[i][j] = cur[tx][ty];
			}
		}
		return result;
	}


}
