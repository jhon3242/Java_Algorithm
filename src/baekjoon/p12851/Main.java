package baekjoon.p12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static int sameCount = 0;
	private static int[] dp = new int[100_001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());


		bfs();
		System.out.println(dp[K] - 1);
		System.out.println(sameCount);
	}

	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(N, 1));
		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			if (poll.cur < 0 || poll.cur > 100_000) continue;
			if (dp[poll.cur] != 0 && poll.count > dp[poll.cur]) continue;

			if (poll.cur == K) {
				if (dp[poll.cur] == 0 || dp[poll.cur] > poll.count) {
					dp[poll.cur] = poll.count;
					sameCount = 1;
					continue;
				}
				if (poll.count > dp[poll.cur]) return;
				sameCount++;
				continue;
			}

			if (dp[poll.cur] == 0 || dp[poll.cur] > poll.count) {
				dp[poll.cur] = poll.count;
				pq.add(new Node(poll.cur + 1, poll.count + 1));
				pq.add(new Node(poll.cur - 1, poll.count + 1));
				pq.add(new Node(poll.cur * 2, poll.count + 1));
			}
		}

	}

	static class Node implements Comparable<Node> {
		int cur;
		int count;

		public Node(int cur, int count) {
			this.cur = cur;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			return count - o.count;
		}
	}
}
