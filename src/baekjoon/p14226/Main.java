package baekjoon.p14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	private static int S;
	private static int[] dp = new int[2001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());

		for (int i = 0; i < dp.length; i++) {
			dp[i] = i;
		}

		bfs();
		System.out.println();
	}

	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(1, 1, 1));
		while (!pq.isEmpty()) {
			Node poll = pq.poll();

			if (dp[poll.pos] == -1 || dp[poll.pos] > poll.count) {
				dp[poll.pos] = poll.count;
			}

			if (poll.pos == S) {
				System.out.println(poll.count);
				return;
			}

			// 1. copy clip
			if (poll.pos != poll.clip) {
				pq.add(new Node(poll.pos, poll.count + 1, poll.pos));
			}

			// 2. past
			if (isValidate(poll.pos + poll.clip, poll.count + 1)) {
				pq.add(new Node(poll.pos + poll.clip, poll.count + 1, poll.clip));
			}

			// 3. delete
			if (isValidate(poll.pos - 1, poll.count + 1)) {
				pq.add(new Node(poll.pos - 1, poll.count + 1, poll.clip));
			}
		}
	}

	private static boolean isValidate(int pos, int count) {
		if (pos < 0 || pos > 2000) return false;
		if (dp[pos] < count) return false;
		return true;
	}


	static class Node implements Comparable<Node> {
		int pos;
		int count;
		int clip;

		public Node(int pos, int count, int clip) {
			this.pos = pos;
			this.count = count;
			this.clip = clip;
		}

		@Override
		public int compareTo(Node o) {
			return count - o.count;
		}
	}
}
