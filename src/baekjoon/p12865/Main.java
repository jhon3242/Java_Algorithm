package baekjoon.p12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	private static int N;
	private static int K;
	private static PriorityQueue<Node> pq = new PriorityQueue<>();
	private static int[] dp = new int[100_001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			int w = poll.w;
			int v = poll.v;

			for (int i = 1; i < w; i++) {
				if (dp[i] > 0 && isUpdate(w, v, i)) {
					dp[i + w] = dp[i] + v;
				}
			}
			dp[w] = Math.max(dp[w], v);
		}
		int result = 0;
		for (int i = 1; i <= K; i++) {
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}

	private static boolean isUpdate(int w, int v, int i) {
		return i + w <= 100_000 && dp[i] + v > dp[i + w];
	}

	static class Node implements Comparable<Node> {
		int w;
		int v;

		public Node(int w, int v) {
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}
}

/**

100 100000
6 13
4 8
3 6
5 12
6 13
4 8
3 6
5 12
3 6
5 12
6 13
4 8
3 6
5 12
6 13
4 8
3 6
5 12
3 6
5 12
6 13
4 8
3 6
5 12
6 13
4 8
3 6
5 12
3 6
5 12
6 13
4 8
3 6
5 12
6 13
4 8
3 6
5 12
3 6
5 12
6 13
4 8
3 6
5 12
6 13
4 8
3 6
5 12
3 6
5 12
6 13
4 8
3 6
5 12
6 13
4 8
3 6
5 12
3 6
5 12
6 13
4 8
3 6
5 12
6 13
4 8
3 6
5 12
3 6
5 12
6 13
4 8
3 6
5 12
6 13
4 8
3 6
5 12
3 6
5 12
6 13
4 8
3 6
5 12
6 13
4 8
3 6
5 12
3 6
5 12
6 13
4 8
3 6
5 12
6 13
4 8
3 6
5 12
3 6
5 12

 */