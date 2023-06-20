package baekjoon.p12100;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	private static int N;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static final int Up = 0;
	private static final int Right = 1;
	private static final int Down = 2;
	private static final int Left = 3;
//	private static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];

		for (int i = 0; i < N; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		printG(graph);
		skipZero(graph, 0, 3);
		printG(graph);
	}

	private static int[][] move(int[][] graph, int dir) {
		int[][] result = getClone(graph);


		if (dir == Up) {
			return moveUp(result);
		}

		if (dir == Right) {
			return moveRight(result);
		}

		if (dir == Down) {
			return moveDown(result);
		}


		return result;
	}

	private static int[][] moveDown(int[][] result) {
		for (int i = 0; i < N; i++) {
			for (int j = N - 2; j >= 0; j--) {
				if (result[j][i] != 0) {
					int curNum = result[j][i];

					for (int k = j - 1; k >= 0; k--) {
						if (result[k][] != 0) {
							if (result[i][k] == curNum) {
								result[j][i] *= 2;
								result[i][k] = 0;
							}
							break;
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (result[i][j] != 0) {
					int curNum = result[i][j];
					int s = j;

					while (s < N && result[i][s] == 0) {
						s++;
					}
					result[i][s] = curNum;
					result[i][j] = 0;
				}
			}
		}
		return result;
	}

	private static int[][] moveRight(int[][] result) {
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (result[i][j] != 0) {
					sumSameNumR(result, i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (result[i][j] != 0) {
					int curNum = result[i][j];
					int s = j;

					while (s < N && result[i][s] == 0) {
						s++;
					}
					result[i][s] = curNum;
					result[i][j] = 0;
				}
			}
		}
		return result;
	}

	private static int[][] moveUp(int[][] result) {
		// 아래로 내려가면서 같은 번호 오는지 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (result[j][i] != 0) {
					int curNum = result[j][i];
					sumSameNumUp(result, i, j, curNum);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (result[j][i] != 0) {
					skipZero(result, i, j);
				}
			}
		}
		return result;
	}

	private static void sumSameNumR(int[][] result, int i, int j) {
		int curNum = result[j][i];

		for (int k = j - 1; k >= 0; k--) {
			if (result[i][k] != 0) {
				if (result[i][k] == curNum) {
					result[j][i] *= 2;
					result[i][k] = 0;
				}
				break;
			}
		}
	}

	private static void skipZero(int[][] result, int i, int j) {
		int curNum = result[j][i];
		int s = j;
		while (s >= 1 && result[s - 1][i] == 0) {
			s--;
		}
		result[s][i] = curNum;
		result[j][i] = 0;
	}

	private static void sumSameNumUp(int[][] result, int i, int j, int curNum) {
		for (int k = j + 1; k < N - 1; k++) {
			if (result[k][i] != 0) {
				if (result[k][i] == curNum) {
					result[j][i] *= 2;
					result[k][i] = 0;
				}
				break;
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

	private static void printG(int[][] graph) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println();
	}
}
