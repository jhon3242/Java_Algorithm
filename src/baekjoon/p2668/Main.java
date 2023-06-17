package baekjoon.p2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static int[][] graph;
	private static boolean[] visited;
	private static Set<Integer> result = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[2][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[0][i] = i + 1;
		}

		for (int i = 1; i <= N; i++) {
			graph[1][i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; i++) {
			dfs(i, new HashSet<>(), new HashSet<>());
		}
		ArrayList<Integer> resultLIst = new ArrayList<>(result);
		System.out.println(resultLIst.size());
		Collections.sort(resultLIst);
		resultLIst.forEach(System.out::println);

	}

	private static void dfs (int i, Set<Integer> a, Set<Integer> b) {
		if (a.contains(i)) {
			if (a.size() == b.size()) {
				result.addAll(a);
			}
			return;
		}
		a.add(i);
		b.add(graph[1][i]);
		dfs(graph[1][i], a, b);
	}
}
