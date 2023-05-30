package baekjoon.p12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static int[] dp = new int[100_001];
	private static int sameCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dfs(N, 1);
	}

	private static void dfs(int cur, int count) {
		if (cur == K) {
			if (dp[cur] > count) {
				dp[cur] = count;
				sameCount = 1;
			}
			if (dp[cur] == count) {
				sameCount++;
			}
			return;
		}

		if (cur < 0 || cur > 100_000) return;
		if (dp[cur] != 0 && dp[cur] <= count) return;

		dp[cur] = count;
		System.out.println("cur = " + cur + " count " + count);

		dfs(cur * 2, count + 1);
		dfs(cur + 1, count + 1);
		dfs(cur - 1, count + 1);
	}



}
