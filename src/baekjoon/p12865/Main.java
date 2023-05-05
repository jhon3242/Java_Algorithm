package baekjoon.p12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1회차 시간초과
 * 6%
 */

public class Main {

	private static List<Integer[]> store = new ArrayList<>();
	private static int K;
	private static int N;
	private static int result = 0;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = info[0];
		K = info[1];
		visited = new boolean[N + 1];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			if (tmp == null) break;
			String[] sp = tmp.split(" ");
			store.add(new Integer[]{Integer.parseInt(sp[0]), Integer.parseInt(sp[1])});
		}

		dfs(0, 0, 0, 0);
		System.out.println(result);
	}

	private static void dfs(int level, int start, int total, int value) {

		if (level == N || total > K) return ;

		result = Math.max(result, value);

		for (int i = start; i < N; i++) {

			if (!visited[i] && store.get(i)[0] + total <= K) {
				visited[i] = true;
				dfs(level + 1, i + 1, total + store.get(i)[0], value + store.get(i)[1]);
				visited[i] = false;
			}
		}
	}
}

/**
 * 4 7
 * 6 13
 * 4 8
 * 3 6
 * 1 8
 */