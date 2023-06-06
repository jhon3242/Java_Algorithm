package baekjoon.p1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int S;
	private static int M;
	private static int[] list;
	private static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


		dfs(S, 0);
		if (result == 0) System.out.println(-1);
		else System.out.println(result);
	}

	private static void dfs(int cur, int level){
//		System.out.println("cur = " + cur + " level = " + level);
		if (level == N) {
			result = Math.max(result, cur);
			return;
		}

		if (isValid(cur + list[level])) {
			dfs(cur + list[level], level + 1);
		}

		if (isValid(cur - list[level])) {
			dfs(cur - list[level], level + 1);
		}
	}

	private static boolean isValid(int num) {
		if (num < 0 || num > M ) return false;
		return true;
	}
}
