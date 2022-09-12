package baekjoon.p1753;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int end;
	int cost;

	public Node(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return cost - o.cost;
	}
}

public class Main {
	static int V, E, start;
	static List<Node>[] list;
	static int[] distance;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		distance = new int[V + 1];
		list = new ArrayList[V + 1];

		Arrays.fill(distance, INF);
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[start].add(new Node(end, cost));
		}
		dijkstra(start);
		for (int i = 1; i <= V; i++) {
			if (distance[i] != INF)
				bw.write(distance[i] + "");
			else
				bw.write("INF");
			bw.write("\n");
		}
		bw.close();
	}

	public static void dijkstra(int start){
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];
		queue.add(new Node(start, 0));
		distance[start] = 0;
		while (!queue.isEmpty()){
			Node polled = queue.poll();
			int cur = polled.end;

			if (visited[cur])
				continue;
			visited[cur] = true;

			for (Node tmp : list[cur]){
				if (distance[tmp.end] > tmp.cost + distance[cur]){
					distance[tmp.end] = tmp.cost + distance[cur];
					queue.add(new Node(tmp.end, distance[tmp.end]));
				}
			}
		}
	}
}
