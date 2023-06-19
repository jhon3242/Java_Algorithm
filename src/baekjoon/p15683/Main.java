package baekjoon.p15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[][] graph;
	private static List<Integer[]> cctvs = new ArrayList<>();
	private static int[] dx = new int[]{0, 1, 0, -1};
	private static int[] dy = new int[]{1, 0, -1, 0};
	private static int minResult = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		init(br, st);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] != 0 && graph[i][j] < 6) {
					cctvs.add(new Integer[]{i, j});
				}
			}
		}
		dfs(0, graph);
		System.out.println(minResult);
	}

	private static void init(BufferedReader br, StringTokenizer st) throws IOException {
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	}

	private static void dfs(int level, int[][] preGraph) {
		if (level == cctvs.size()) {
//			printG(preGraph);
			int tmpResult = getResult(preGraph);
			minResult = Math.min(minResult, tmpResult);
			return;
		}

		Integer[] cctvPos = cctvs.get(level);
		int type = graph[cctvPos[0]][cctvPos[1]];

		for (int i = 0; i < 4; i++) {
			if ((type == 5 && i > 0) || (type == 2 && i > 1)) break;
			int[][] tmpGraph = getCloneGraph(preGraph);
			draw(cctvPos, type, i, tmpGraph);
			dfs(level + 1, tmpGraph);
		}
	}

	private static int[][] getCloneGraph(int[][] graph) {
		int[][] result = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = graph[i][j];
			}
		}

		return result;
	}

	private static void draw(Integer[] pos, int type, int dir, int[][] graph) {
		int x = pos[0];
		int y = pos[1];

		List<Integer> dirs = getDirs(type, dir);

		for (Integer tmpDir : dirs) {
			int tx = x;
			int ty = y;
			while (true) {
				tx += dx[tmpDir];
				ty += dy[tmpDir];
				if (tx < 0 || ty < 0 || tx >= N || ty >= M || graph[tx][ty] == 6) break;
				if (0 < graph[tx][ty] && graph[tx][ty] < 6) {
					continue;
				}
				graph[tx][ty] = -1;
			}
		}
	}

	private static List<Integer> getDirs(int type, int dir) {
		List<Integer> drawDir = new ArrayList<>();

		if (type == 1) {
			drawDir.add(dir);
		}

		if (type == 2) {
			drawDir.add(dir);
			drawDir.add((dir + 2) % 4);
		}

		if (type == 3) {
			drawDir.add(dir);
			drawDir.add((dir + 1) % 4);
		}

		if (type == 4) {
			drawDir.add(dir);
			drawDir.add((dir + 1) % 4);
			drawDir.add((dir + 2) % 4);
		}

		if (type == 5) {
			drawDir.add(0);
			drawDir.add(1);
			drawDir.add(2);
			drawDir.add(3);
		}
		return drawDir;
	}

	private static void printG(int[][] graph) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println();
	}

	private static int getResult(int[][] graph) {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) {
					result++;
				}
			}
		}
		return result;
	}
}
