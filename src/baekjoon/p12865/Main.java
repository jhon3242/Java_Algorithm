package baekjoon.p12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1회차 시간초과
 * 6%
 */

public class Main {

	private static int N;
	private static int K;
	private static List<Integer[]> store = new ArrayList<>();
	private static boolean[] visited;
	private static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			store.add(new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}

		dfs(0, 0, new ArrayList<>());
		System.out.println("result = " + result);
	}

	private static void dfs(int start, int total, List<Integer> nums) {

		if (total <= K) {
			result = Math.max(result, nums.stream().mapToInt(Integer::intValue).sum());
		}

		for (int i = start; i < N; i++) {
			Integer[] info = store.get(i);
			if (total + info[0] <= K) {
				nums.add(info[1]);
				dfs(i + 1, total + info[0], nums);
				nums.remove(nums.size() -1);
			}
		}
	}
}

/**
4 7
6 13
4 8
3 6
1 8
 */