package baekjoon.p12100;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int N;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static final int Up = 0;
	private static final int Right = 1;
	private static final int Down = 2;
	private static final int Left = 3;
	private static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}


		for (int i = 0; i < 4; i++) {
			dfs(graph, 0, i);
		}

		System.out.println(result);
	}

	private static void dfs(int[][] graph, int level, int dir) {
		if (level == 5) {
			result = Math.max(result, getMaxBlock(graph));

			return;
		}
		int[][] clone = getClone(graph);

		if (dir == Up || dir == Down) {
			for (int i = 0; i < N; i++) {
				colMove(clone, i, dir);
			}
		} else if (dir == Left || dir == Right) {
			for (int i = 0; i < N; i++) {
				rowMove(clone, i, dir);
			}
		}
//		printG(clone);

		for (int i = 0; i < 4; i++) {
			dfs(clone, level + 1, i);
		}
	}

	private static void rowMove(int[][] graph, int row, int dir) {
		sumSameNumRow(graph, row, dir);
		skipZero(graph, row, dir);
	}

	private static void skipZero(int[][] graph, int row, int dir) {
		if (dir == Left) {
			for (int i = 0; i < N; i++) {
				if (graph[row][i] == 0) {
					for (int j = i; j < N; j++) {
						if (graph[row][j] != 0) {
							graph[row][i] = graph[row][j];
							graph[row][j] = 0;
							break;
						}
					}
				}
			}
			return;
		}
		if (dir == Right) {
			for (int i = N - 1; i >= 0; i--) {
				if (graph[row][i] == 0) {
					for (int j = i; j >= 0; j--) {
						if (graph[row][j] != 0) {
							graph[row][i] = graph[row][j];
							graph[row][j] = 0;
							break;
						}
					}
				}
			}
		}
	}

	private static void sumSameNumRow(int[][] graph, int row, int dir) {
		if (dir == Left) {
			// 합쳐지는 경우
			for (int i = 0; i < N - 1; i++) {
				if (graph[row][i] != 0) {
					int curNum = graph[row][i];
					int s = i + 1;
					while (s < N && graph[row][s] == 0) {
						if (s == N - 1) break;
						s++;
					}
					if (curNum == graph[row][s]) {
						graph[row][i] = curNum * 2;
						graph[row][s] = 0;
					}
				}
			}
			return;
		}

		if (dir == Right) {
			// 합쳐지는 경우
			for (int i = N - 1; i > 0; i--) {
				if (graph[row][i] != 0) {
					int curNum = graph[row][i];
					int s = i - 1;
					while (s >= 0 && graph[row][s] == 0) {
						if (s == 0) break;
						s--;
					}
					if (curNum == graph[row][s]) {
						graph[row][i] = curNum * 2;
						graph[row][s] = 0;
					}
				}
			}
		}
	}

	private static void sumSameNumCol(int[][] graph, int col, int dir) {
		if (dir == Up) {
			// find same num
			for (int i = 0; i < N - 1; i++) {
				if (graph[i][col] != 0) {
					int curNum = graph[i][col];
					int s = i + 1;
					while (s < N && graph[s][col] == 0) {
						s++;
					}
					if (graph[s][col] == curNum) {
						graph[i][col] *= 2;
						graph[s][col] = 0;
					}
				}
			}
			return;
		}
		if (dir == Down) {
			for (int i = N - 1; i > 0; i--) {
				if (graph[i][col] != 0) {
					int curNum = graph[i][col];
					int s = i - 1;
					while (s > 0 && graph[s][col] == 0) {
						s--;
					}
					if (graph[s][col] == curNum) {
						graph[i][col] *= 2;
						graph[s][col] = 0;
					}
				}
			}
			return;
		}
	}

	private static void colMove(int[][] graph, int col, int dir) {
		sumSameNumCol(graph, col, dir);
		skipZeroCol(graph, col, dir);
	}

	private static void skipZeroCol(int[][] graph, int col, int dir) {
		if (dir == Up) {
			for (int i = 0; i < N; i++) {
				if (graph[i][col] == 0) {
					for (int j = i; j < N; j++) {
						if (graph[j][col] != 0) {
							graph[i][col] = graph[j][col];
							graph[j][col] = 0;
							break;
						}
					}
				}
			}
			return;
		}

		if (dir == Down) {
			for (int i = N - 1; i >= 0; i--) {
				if (graph[i][col] == 0) {
					for (int j = i; j >= 0; j--) {
						if (graph[j][col] != 0) {
							graph[i][col] = graph[j][col];
							graph[j][col] = 0;
							break;
						}
					}
				}
			}
		}
	}


	private static int[][] getClone(int[][] graph) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			result[i] = graph[i].clone();
		}
		return result;
	}

	private static int getMaxBlock(int[][] graph) {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result = Math.max(result, graph[i][j]);
			}
		}
		return result;
	}

	private static void printG(int[][] graph) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println();
	}
}
