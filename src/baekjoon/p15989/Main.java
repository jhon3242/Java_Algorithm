package baekjoon.p15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int T;
	private static int N;
	private static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			dp = new int[N + 1];
			op();
			System.out.println(dp[N]);
		}

	}

	private static void op() {
		Arrays.fill(dp, 1);
		for (int i = 2; i <= 3; i++) {
			for (int j = i; j <= N; j++) {
				dp[j] = dp[j] + dp[j - i];
			}
		}
	}
}
