package baekjoon.p13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static int K;
	private static int[] dp = new int[100_001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Arrays.fill(dp, -1);
		bfs();


//		System.out.println(sameCount);
	}

	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(N, 0));
		while (!pq.isEmpty()) {
			// 유요한 경우만 큐에 넣는다.
			Node poll = pq.poll();

			if (dp[poll.pos] != -1 && dp[poll.pos] < poll.count) {
				continue;
			}

			dp[poll.pos] = poll.count;
			if (poll.pos == K) {
				System.out.println(dp[K]);
				System.out.println(poll.list);
				return;
			}

			if (isValid(poll.pos + 1, poll.count + 1)) {
				pq.add(new Node(poll.pos + 1, poll.count + 1, poll.list));
			}
			if (isValid(poll.pos - 1, poll.count + 1)) {
				pq.add(new Node(poll.pos - 1, poll.count + 1, poll.list));
			}
			if (isValid(poll.pos * 2, poll.count + 1)) {
				pq.add(new Node(poll.pos * 2, poll.count + 1, poll.list));
			}

		}
	}

	private static boolean isValid(int x, int count) {
		return 0 <= x && x <= 100_000 && (dp[x] == -1 || dp[x] > count);
	}


	static class Node implements Comparable<Node> {
		int pos;
		int count;
		String list;

		public Node(int pos, int count) {
			this.pos = pos;
			this.count = count;
			this.list = "" + pos;
		}

		public Node(int pos, int count, String list) {
			this.pos = pos;
			this.count = count;
			this.list = list + " " + pos;
		}

		public int getPos() {
			return pos;
		}

		@Override
		public int compareTo(Node o) {
			return count - o.count;
		}

	}
}
