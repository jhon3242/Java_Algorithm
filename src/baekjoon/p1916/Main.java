package baekjoon.p1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	private static List<Node>[] list;
	private static int N;
	private static int M;
	private static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		distance = new int[N + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int[] in = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			list[in[0]].add(new Node(in[1], in[2]));
		}

		int[] root = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		int start = root[0];
		int end = root[1];
		dijkstra(start);
		System.out.println(distance[end]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		q.add(new Node(start, 0));
		distance[start] = 0;
		while (!q.isEmpty()) {
			Node poll = q.poll();
			int cur = poll.end;
			if (visited[cur]) continue;
			visited[cur] = true;
			for (Node node : list[cur]) {
				if (distance[node.end] > distance[cur] + node.cost) {
					distance[node.end] = distance[cur] + node.cost;
					q.add(new Node(node.end, distance[node.end]));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		private int end;
		private int cost;

		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node) {
			return this.cost - node.cost;
		}
	}
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//
//	static int N, M;
//	static List<Node>[] list;
//	static int[] distance;
//	static int INF = Integer.MAX_VALUE;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		N = Integer.parseInt(br.readLine());
//		M = Integer.parseInt(br.readLine());
//		list = new ArrayList[N + 1];
//		distance = new int[N + 1];
//
//		Arrays.fill(distance, INF);
//		for (int i = 1; i <= N; i++) {
//			list[i] = new ArrayList<>();
//		}
//
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			int cost = Integer.parseInt(st.nextToken());
//			list[start].add(new Node(end, cost));
//		}
//
//		st = new StringTokenizer(br.readLine());
//		int from = Integer.parseInt(st.nextToken());
//		int to = Integer.parseInt(st.nextToken());
//
//		dijkstra(from);
//		System.out.println(distance[to]);
//	}
//
//	public static void dijkstra(int start){
//		PriorityQueue<Node> queue = new PriorityQueue<>();
//		boolean[] visited = new boolean[N + 1];
//		queue.add(new Node(start, 0));
//		distance[start] = 0;
//
//		while (!queue.isEmpty()){
//			Node polled = queue.poll();
//			int cur = polled.end;
//			if (visited[cur])
//				continue;
//			visited[cur] = true;
//			for(Node node : list[cur]){
//				if (distance[node.end] > distance[cur] + node.cost){
//					distance[node.end] = distance[cur] + node.cost;
//					queue.add(new Node(node.end, distance[node.end]));
//				}
//			}
//		}
//	}
//}
//
//class Node implements Comparable<Node>{
//
//	int end, cost;
//
//	public Node(int end, int cost) {
//		this.end = end;
//		this.cost = cost;
//	}
//
//	@Override
//	public int compareTo(Node o) {
//		return cost - o.cost;
//	}
//}
