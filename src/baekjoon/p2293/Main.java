package baekjoon.p2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N, K;
	private static int coin;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K + 1];

		dp[0] = 1;

		for (int i = 0; i < N; i++) {
			coin = Integer.parseInt(br.readLine());
			for (int j = 1; j < K + 1; j++) {
				if (j >= coin) {
					dp[j] = dp[j] + dp[j - coin];
				}
			}
		}
		System.out.println(dp[K]);
	}
}

/**
 * 1 7 10
 *
 * 1 (1)
 * 1
 *
 * 2 (2)
 * 1 1
 * 2
 *
 *
 * 3 (2)
 * 1 1 1
 * 2 1
 *
 *
 * 4 (3)
 *
 * 1 1 1 1
 * 2 1 1
 * 2 2
 *
 *
 * 5 (3)
 *
 * 1 1 1 1 1
 * 2 1 1 1
 * 2 2 1
 *
 *
 * 6 (4)
 * 1 1 1 1 1 1 1
 * 2 1 1 1 1
 * 2 2 1 1
 * 2 2 2
 *
 * 7 (5)
 * 1 1 1 1 1 1 1
 * 2 1 1 1 1
 * 2 2 1 1 1
 * 2 2 2 1
 * 7
 *
 *
 * 8 (6)
 * 1 1 1 1 1 1 1 1 1
 * 2 1 1 1 1 1 1
 * 2 2 1 1 1 1
 * 2 2 2 1 1
 * 2 2 2 2
 * 7 1
 *
 * 9 (7)
 * 1 1 1 1 1 1 1 1 1
 * 2 1 1 1 1 1 1 1
 * 2 2 1 1 1 1 1
 * 2 2 2 1 1 1
 * 2 2 2 2 1
 * 7 1 1
 * 7 2
 *
 * 10 : 8
 * 1 1 1 1 1 1 1 1 1 1
 * 2 1 1 1 1 1 1 1 1
 * 2 2 1 1 1 1 1 1
 * 2 2 2 1 1 1 1
 * 2 2 2 2 1 1
 * 2 2 2 2 2
 * 7 1 1 1
 * 7 2 1
 *
 *
 * 11 (9)
 * 1 1 1 1 1 1 1 1 1 1 1
 * 2 1 1 1 1 1 1 1 1 1
 * 2 2 1 1 1 1 1 1 1
 * 2 2 2 1 1 1 1 1
 * 2 2 2 2 1 1 1
 * 2 2 2 2 2 1
 * 7 1 1 1 1
 * 7 2 1 1
 * 7 2 2
 *
 *
 */
