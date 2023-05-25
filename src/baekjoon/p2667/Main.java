package baekjoon.p2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static int[][] graph;
	private static List<Integer> result;
	private static int[] dx = new int[]{1, 0, -1, 0};
	private static int[] dy = new int[]{0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		result = new ArrayList<>();

		initGraph(br);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 1) {
					bfs(i, j);

				}
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for (Integer integer : result) {
			System.out.println(integer);
		}
	}

	private static void initGraph(BufferedReader br) throws IOException {
		for (int i = 0; i < N; i++) {
			graph[i] = Arrays.stream(br.readLine().split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
	}

	private static void bfs(int x, int y) {
		Queue<Integer[]> qu = new LinkedList<>();
		int count = 0;

		qu.add(new Integer[]{x, y});
		while (!qu.isEmpty()) {
			Integer[] poll = qu.poll();
			int nx = poll[0];
			int ny = poll[1];
			if (nx < 0 || ny < 0 || nx >= N || ny >=N || graph[nx][ny] != 1) {
				continue;
			}
			count++;
			graph[nx][ny] = -1;

			for (int i = 0; i < 4; i++) {
				qu.add(new Integer[]{nx + dx[i], ny + dy[i]});
			}
		}
		result.add(count);
	}
}
