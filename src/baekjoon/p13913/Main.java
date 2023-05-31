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

//		System.out.println(dp[K]);
//		System.out.println(sameCount);
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
					System.out.println(poll.count);
					System.out.println(poll.list);
					return;
				}

				continue;
			}

			if (dp[poll.pos] == -1 || dp[poll.pos] > poll.count) {
				dp[poll.pos] = poll.count;
				pq.add(new Node(poll.pos + 1, poll.count + 1, poll.list));
				pq.add(new Node(poll.pos - 1, poll.count + 1, poll.list));
				pq.add(new Node(poll.pos * 2, poll.count + 1, poll.list));
			}
		}
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
