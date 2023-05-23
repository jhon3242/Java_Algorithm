package baekjoon.p1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		graph = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			Arrays.fill(graph[i], 200_000);
		}

		for (int i = 1; i <= N; i++) {
			graph[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			int[] in = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			graph[in[0]][in[1]] = Math.min(graph[in[0]][in[1]], in[2]);
		}

		int[] root = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		System.out.println(graph[root[0]][root[1]]);
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
