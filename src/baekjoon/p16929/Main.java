package baekjoon.p16929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 1차 시도
 * BFS 를 생각해보긴 했는데 그러면 이어지는 좌표인지 아니면 바로 이전 좌표인지
 * 구분하기가 힘들것 같다. 따라서 DFS 로 구현시도 (근데 시간초과 날 것 같음)
 *
 * 근데 통과했음 조건문을 줘서 0일떄만 탐색해서 중복 탐색이 발생하지 않아
 * 시간초과가 발생하지 않은듯하다.
 *
 */
public class Main {

	private static int N;
	private static int M;
	private static char[][] graph;
	private static int[][] disGraph;
	private static int[] dx = new int[]{0, 1, 0, -1};
	private static int[] dy = new int[]{1, 0, -1, 0};
	private static boolean result = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		initGraph(br, st);
		initDisGraph();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (disGraph[i][j] == 0) {
					dfs(i, j, 1);
//					printG();
//					System.out.println();
					if (result) {
						System.out.println("Yes");
						return;
					}
				}
			}
		}
		System.out.println("No");

	}

	private static void initGraph(BufferedReader br, StringTokenizer st) throws IOException {
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}
	}

	private static void initDisGraph() {
		disGraph = new int[N][M];
		for (int i = 0; i < N; i++) {
			disGraph[i] = IntStream.range(0, M).map(v -> 0).toArray();
		}
	}


	private static void dfs(int x, int y, int level) {

		// 정답확인
		if (disGraph[x][y] > 0) {
			result = true;
			return;
		}

		disGraph[x][y] = level;

		for (int i = 0; i < 4; i++) {
			int tx = dx[i] + x;
			int ty = dy[i] + y;
//			System.out.println("ty = " + ty +" ty " + ty);
			// 검증
			if (tx < 0 || ty < 0 || tx >= N || ty >= M) continue;
//			System.out.println(1);
			if (graph[tx][ty] != graph[x][y]) continue;
//			System.out.println(2);
			if (disGraph[tx][ty] != 0 && Math.abs(disGraph[tx][ty] - disGraph[x][y]) == 1) continue;
//			System.out.println(3);

			// 재귀
			dfs(tx, ty, level + 1);
		}
	}

	private static void printG() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(disGraph[i]));
		}
	}
}
