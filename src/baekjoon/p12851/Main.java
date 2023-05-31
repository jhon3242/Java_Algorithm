package baekjoon.p12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static int[] dp = new int[100_001];
	private static int sameCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Arrays.fill(dp, -1);
		bfs();

		System.out.println(dp[K]);
		System.out.println(sameCount);
	}

	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(N, 0));
		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			// 유효하지 않는 값이면 넘기기
			if (poll.pos < 0 || poll.pos > 100000) continue;

			// 더이상 더 작은 경우가 안나오는 경우 종료
			if (dp[K] != -1 && dp[K] < poll.count) return;

			if (poll.pos == K) {


				// 값이 바뀌는 경우 업데이트
				if (dp[K] == -1 || dp[K] > poll.count) {
					dp[K] = poll.count;
					sameCount = 1;
					continue;
				}

				if (dp[K] == poll.count) {
					sameCount++;
				}
				continue;
			}

			if (dp[poll.pos] == -1 || dp[poll.pos] >= poll.count) {
				dp[poll.pos] = poll.count;
				pq.add(new Node(poll.pos + 1, poll.count + 1));
				pq.add(new Node(poll.pos - 1, poll.count + 1));
				pq.add(new Node(poll.pos * 2, poll.count + 1));
			}
		}
	}


	static class Node implements Comparable<Node> {
		int pos;
		int count;

		public Node(int pos, int count) {
			this.pos = pos;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			return count - o.count;
		}
	}
}
