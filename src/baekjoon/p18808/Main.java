package baekjoon.p18808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int K;
	private static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new int[N][M];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[tx][ty];

			for (int j = 0; j < tx; j++) {
				sticker[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}



			for (int j = 0; j < 4; j++) {
//				if (i == 3) {
//					printG(sticker);
//				}
				boolean isAdded = tryAdd(sticker);
				if (isAdded) break;
				if (j == 3) break;
				sticker = getRotate(sticker);
			}
		}
		System.out.println(getResult());
	}
	private static boolean tryAdd(int[][] sticker) {

		int tx = sticker.length;
		int ty = sticker[0].length;

		for (int i = 0; i + tx <= N ; i++) {
			for (int j = 0; j + ty <= M; j++) {
				if (canAdd(i, j, sticker)) {
					addSticker(i, j, sticker);
					return true;
				}
			}
		}
		return false;
	}

	private static boolean canAdd(int sx, int sy, int[][] sticker) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (graph[sx + i][sy + j] + sticker[i][j] > 1) return false;
			}
		}
		return true;
	}

	private static void addSticker(int sx, int sy, int[][] sticker) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				graph[sx + i][sy + j] += sticker[i][j];
			}
		}
	}

	private static int[][] getRotate(int[][] cur) {
		int[][] result = new int[cur[0].length][cur.length];

		for (int i = 0; i < cur.length; i++) {
			for (int j = 0; j < cur[0].length; j++) {
				result[j][cur.length - 1 - i] = cur[i][j];
			}
		}
		return result;
	}

	private static int getResult() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 1) {
					result++;
				}
			}
		}
		return result;
	}

	private static void printG(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println();
	}
}
