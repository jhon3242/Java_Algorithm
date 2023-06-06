package baekjoon.p11058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	private static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new long[N + 1];

		for (int i = 0; i <= N; i++) {
			dp[i] = i;
		}

		op();

		System.out.println(dp[N]);
	}

	private static void op() {

		for (int i = 2; i <= N; i++) {
			long clip = dp[i];
			long time = 2;
			for (int j = i + 3; j <= N ; j++) {
				if (isUpdate(clip, time, j)) {
					dp[j] = clip * time;
					for (int k = j + 1; k <= N; k++) {
						if (k > 0) {
							dp[k] = dp[k - 1] + 1;
						}
					}
				}
				time++;
			}
		}
	}

	private static boolean isUpdate(long clip, long time, int j) {
		return dp[j] < clip * time;
	}
}
