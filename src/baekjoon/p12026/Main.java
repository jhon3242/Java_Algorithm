package baekjoon.p12026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static int N;
	private static char[] graph;
	private static int result = Integer.MAX_VALUE;
	private static Map<Character, Character> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = br.readLine().toCharArray();
		map.put('B', 'O');
		map.put('O', 'J');
		map.put('J', 'B');

		dfs(0, 0, 'O');
		if (result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);

	}

	private static void dfs(int cur , int index, char target) {

		if (index == N - 1) {
			result = Math.min(result, cur);
			return;
		}

		for (int i = index + 1; i < N; i++) {
			if (graph[i] == target) {
				dfs(cur + (int)Math.pow(i - index, 2), i, map.get(graph[i]));
			}
		}
	}
}
