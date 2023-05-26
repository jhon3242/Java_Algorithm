package baekjoon.p2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N, K;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> coins = new HashSet<>();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());


		for (int i = 0; i < N; i++) {
			coins.add(Integer.parseInt(br.readLine()));
		}
		ArrayList<Integer> coinList = new ArrayList<>(coins);
		Collections.sort(coinList);
		dp = new int[Math.max(K + 1, coinList.get(coinList.size() - 1) + 1)];

//		dp[0] = 1;
		for (int coin : coinList) {
			dp[coin] = 1;
			for (int j = 1; j < K + 1; j++) {
				if (j >= coin) {
					if (dp[j - coin] != 0) {
						if (dp[j] != 0) {
							dp[j] = Math.min(dp[j], dp[j - coin] + 1);
						} else {
							dp[j] = dp[j - coin] + 1;
						}
					}
				}
			}
		}
		if (dp[K] == 0) System.out.println(-1);
		else System.out.println(dp[K]);
	}
}
