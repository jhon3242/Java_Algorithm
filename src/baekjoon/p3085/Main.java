package baekjoon.p3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] graph;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new char[N][N];
		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		find();
		System.out.println(result);
	}

	private static void find() {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				for (int k = 0; k < 4; k++) {
					int tx = i + dx[k];
					int ty = j + dy[k];

					if (tx < 0 || ty < 0 || tx >= N || ty >= N || graph[i][j] == graph[tx][ty])
						continue;
					switching(i, j, tx, ty);
					result = Math.max(result, checking());
					switching(i, j, tx, ty);
				}
			}
		}
	}

	private static void switching(int x, int y, int tx, int ty){
		char tmp = graph[x][y];
		graph[x][y] = graph[tx][ty];
		graph[tx][ty] = tmp;
	}

	private static int checking(){
		int max = 0;
		int tmp;
		char tmpChar;

		// row check
		for (int i = 0; i < N; i++) {
			tmp = 1;
			tmpChar = '.';
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == tmpChar)
					tmp++;
				else{
					max = Math.max(max, tmp);
					tmp = 1;
					tmpChar = graph[i][j];
				}
			}
			max = Math.max(max, tmp);
		}

		// col check
		for (int j = 0; j < N; j++) {
			tmp = 1;
			tmpChar = '.';
			for (int i = 0; i < N; i++) {
				if (graph[i][j] == tmpChar)
					tmp++;
				else{
					max = Math.max(max, tmp);
					tmp = 1;
					tmpChar = graph[i][j];
				}
			}
			max = Math.max(max, tmp);
		}
		return max;
	}
}
