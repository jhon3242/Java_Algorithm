package baekjoon.p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int V;
	private static List<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		initGraph(br);

		dfs(V);

		System.out.println();
		visited = new boolean[N + 1];

		bfs(V);

	}

	private static void initGraph(BufferedReader br) throws IOException {
		StringTokenizer st;
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (graph[a].contains(b)) continue; // 동일한 간선이 있는 경우 스킵
			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 0; i <= N; i++) {
			Collections.sort(graph[i]);
		}
	}

	private static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");

		for (Integer node : graph[start]) {
			if (!visited[node]) {
				dfs(node);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		while (!q.isEmpty()) {
			Integer poll = q.poll();
			if (!visited[poll]) {
				visited[poll] = true;
				System.out.print(poll + " ");
				for (Integer node : graph[poll]) {
					if (!visited[node]) {
						q.add(node);
					}
				}
			}
		}
	}
}
