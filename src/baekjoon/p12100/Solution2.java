package baekjoon.p12100;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Solution2 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int[][] graph;
	private static int n;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		graph = new int[n][n];
		ArrayList<String> bit = new ArrayList<>();

		// graph init
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		moving(graph, 1);
		System.out.println(graph);
		// add 4 bit
//		for (int i = 0; i < 1024; i++) {
//			bit.add(Integer.toString(i, 4));
//		}
//
//		for (String s : bit) {
//
//		}
	}

	private static void makeGraph(String bit){

		int[][] tmpGraph = new int[n][n];
		for (int i = 0; i < n; i++) {
			tmpGraph[i] = graph[i].clone();
		}

		for (int i = 0; i < bit.length(); i++) {
			int r = bit.charAt(i) - '0';

		}
	}

	private static void moving(int[][] graph, int r) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int nx, ny, tx, ty;

		if (r == 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (graph[i][j] > 0) {
						nx = i;
						ny = j;
						int now = graph[i][j];
						while (true) {
							tx = nx + dx[r];
							ty = ny + dy[r];
							if (tx < 0 || ty < 0 || tx >= n || ty >= n || (graph[tx][ty] != 0 && graph[tx][ty] != now)) {
								graph[i][j] = 0;
								graph[nx][ny] = now;
								break;
							} else {
								nx = tx;
								ny = ty;
								if (graph[tx][ty] == now)
									now += now;
							}
						}
					}
				}
			}
		}
		else if (r == 1){
			for (int j = n - 1; j >= 0; j--) {
				for (int i = 0; i < n; i++) {
					if (graph[i][j] > 0) {
						nx = i;
						ny = j;
						int now = graph[i][j];
						while (true) {
							tx = nx + dx[r];
							ty = ny + dy[r];
							if (tx < 0 || ty < 0 || tx >= n || ty >= n || (graph[tx][ty] != 0 && graph[tx][ty] != now)) {
								graph[i][j] = 0;
								graph[nx][ny] = now;
								break;
							} else {
								nx = tx;
								ny = ty;
								if (graph[tx][ty] == now)
									now += now;
							}
						}
					}
				}
			}
		}


		/* 배열로 만드는 방법

		if (r == 0){
			for (int i = 0; i < n; i++) {
				ArrayList<Integer> tmpArr = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					if (graph[j][i] != 0)
						tmpArr.add(graph[j][i]);
				}

				// combind from back  <-
				for (int j = tmpArr.size() - 1; j > 0 ; j--) {
					if (tmpArr.get(j - 1).equals(tmpArr.get(j))){
						tmpArr.set(j - 1, tmpArr.get(j - 1) + tmpArr.get(j));
						tmpArr.set(j, 0);
					}
				}

				for (int j = 0; j < n; j++) {
					if (tmpArr.size() > j)
						graph[j][i] = tmpArr.get(j);
					else
						graph[j][i] = 0;
				}

			}
		}*/
	}


}
