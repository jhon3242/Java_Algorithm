package baekjoon.p1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
	int start, end, cost;

	public Node(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return cost - o.cost;
	}
}

public class Main {

	static int[] parents;
	static int V, E;
	static int INF = Integer.MAX_VALUE;
	static PriorityQueue<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V + 1];
		list = new PriorityQueue<>();

		// init list
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.add(new Node(start, end, cost));
		}

		// init parents
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}

		int result = 0;
		while (!list.isEmpty()){
			Node polled = list.poll();
			if (find_parent(polled.start) != find_parent(polled.end)){
				union_parent(polled.start, polled.end);
				result += polled.cost;
			}
		}
		System.out.println(result);

	}

	public static int find_parent(int x){
		if (parents[x] != x){
			parents[x] = find_parent(parents[x]);
		}
		return  parents[x];
	}

	public static void union_parent(int a, int b){
		int a_result = find_parent(a);
		int b_result = find_parent(b);
		if (a_result < b_result)
			parents[b_result] = a_result;
		else
			parents[a_result] = b_result;
	}
}
