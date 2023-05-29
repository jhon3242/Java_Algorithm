package baekjoon.p12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static boolean[] visited = new boolean[100_001];
	private static int sameCount = 0;
	private static int minMoveCount = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();
		System.out.println(minMoveCount);
		System.out.println(sameCount);
	}

	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(N, 0));

		while (!pq.isEmpty()) {
			Node poll = pq.poll();

			if (poll.count > minMoveCount) return;
			if (poll.idx < 0 || poll.idx > 100_000) continue;

			if (poll.idx == K) {
				minMoveCount = poll.count;
				sameCount++;
				continue;
			}

			if (!visited[poll.idx]) {
				visited[poll.idx] = true;
				pq.add(new Node(poll.idx - 1, poll.count + 1));
				pq.add(new Node(poll.idx + 1, poll.count + 1));
				pq.add(new Node(poll.idx * 2, poll.count + 1));
			}
		}
	}

	static class Node implements Comparable<Node> {
		int idx;
		int count;

		public Node(int idx, int count) {
			this.idx = idx;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			return count - o.count;
		}
	}
}
