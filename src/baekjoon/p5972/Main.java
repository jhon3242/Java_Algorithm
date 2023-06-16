package baekjoon.p5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static List[] graph;
	private static int[] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		distance = new int[N + 1];


		Arrays.fill(distance, -1);

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new Node(e, c));
			graph[e].add(new Node(s, c));
		}

		op();
		System.out.println(distance[N]);
	}

	private static void op (){
		PriorityQueue<Integer> q = new PriorityQueue<>();

		q.add(1);
		distance[1] = 0;
		while (!q.isEmpty()) {
			Integer curNum = q.poll();
//			System.out.println("curNum = " + curNum);
			List<Node> list = graph[curNum];
			for (Node tmp : list) {

				if (distance[tmp.num] == -1 || distance[tmp.num] > distance[curNum] + tmp.cost) {
					distance[tmp.num] = distance[curNum] + tmp.cost;
					q.add(tmp.num);
				}
			}
//			System.out.println(Arrays.toString(distance));
		}
	}

	static class Node implements Comparable<Node> {
		int num;
		int cost;

		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
}
