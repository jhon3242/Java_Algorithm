package baekjoon.p16935;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, R;
	private static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			switch (cmd){
				case 1:
					upDown();
					break;
				case 2:
					leftRight();
					break;
				case 3:
					rotateR();
					break;
				case 4:
					rotateRR();
					break;
				case 5:
					fn5();
					break;
				case 6:
					fn6();
					break;
			}
		}
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void upDown(){
		int[][] newGraph = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newGraph[N - i - 1][j] = graph[i][j];
			}
		}
		graph = newGraph;
	}

	private static void leftRight(){
		int[][] newGraph = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newGraph[i][M - j - 1] = graph[i][j];
			}
		}
		graph = newGraph;
	}

	private static void rotateR(){
		int[][] newGraph = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newGraph[j][N - 1 - i] = graph[i][j];
			}
		}
		graph = newGraph;
		N = graph.length;
		M = graph[0].length;
	}

	private static void rotateRR(){
		int[][] newGraph = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newGraph[M - j - 1][i] = graph[i][j];
			}
		}
		graph = newGraph;
		N = graph.length;
		M = graph[0].length;
	}

	private static void fn5(){
		int[][] newGraph = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				newGraph[i][j + M / 2] = graph[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				newGraph[i + N / 2][j] = graph[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				newGraph[i][j - M / 2] = graph[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				newGraph[i - N / 2][j] = graph[i][j];
			}
		}
		graph = newGraph;
	}

	private static void fn6(){
		int[][] newGraph = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				newGraph[i + N / 2][j] = graph[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				newGraph[i][j + M / 2] = graph[i][j];
			}
		}

		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				newGraph[i - N / 2][j] = graph[i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2 ; j < M; j++) {
				newGraph[i][j - M / 2] = graph[i][j];
			}
		}
		graph = newGraph;
	}
}
