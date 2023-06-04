package baekjoon.p15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] t;
	private static int[] p;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		t = new int[N];
		p = new int[N];
		dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= N; i++) {

			if (i > 0) {
				dp[i] = Math.max(dp[i], dp[i - 1]);
			}

			if (i < N) {
				if (i + t[i] > N) continue;
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
		}

		System.out.println(dp[N]);
	}
}



