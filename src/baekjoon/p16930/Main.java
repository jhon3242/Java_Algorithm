package baekjoon.p16930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int K;
	private static char[][] graph;
	private static int[][] disGraph;
	private static int[] start = new int[2];
	private static int[] end = new int[2];
	private static int[] dx = new int[]{0, 1, 0, -1};
	private static int[] dy = new int[]{1, 0, -1, 0};
	private static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);

		disGraph[start[0]][start[1]] = 0;
		dfs(start[0] - 1, start[1] - 1, 0);
		if (result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}

	private static void init(BufferedReader br) throws IOException {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		disGraph = new int[N][M];

		for (int i = 0; i < N; i++) {
			Arrays.fill(disGraph[i], -1);
		}

		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}

		st = new StringTokenizer(br.readLine());
		start[0] = Integer.parseInt(st.nextToken());
		start[1] = Integer.parseInt(st.nextToken());
		end[0] = Integer.parseInt(st.nextToken());
		end[1] = Integer.parseInt(st.nextToken());
	}

	private static void dfs(int x, int y, int level) {
		if (x == end[0] - 1 && y == end[1] - 1) {
			result = Math.min(result, level);
			return;
		}

		disGraph[x][y] = level;

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= K; j++) {
				int tx = dx[i] * j + x;
				int ty = dy[i] * j + y;
				if (tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
				if (graph[tx][ty] == '#') break;
				if (disGraph[tx][ty] != -1 && disGraph[tx][ty] < level + 1) {
					continue;
				}

				dfs(tx, ty, level + 1);
			}
		}
	}
}
