package baekjoon.p16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int B;
	private static int A;
	private static int minCount = Integer.MAX_VALUE;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		dfs(A, 1);
		if (minCount == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minCount);
	}

	private static void dfs(long cur, int count) {
		if (cur == B) {
			minCount = Math.min(minCount, count);
			return;
		}

		if (count > minCount || cur > B) return;

		dfs(cur * 2, count + 1);
		dfs(cur * 10 + 1, count + 1);
	}
}
