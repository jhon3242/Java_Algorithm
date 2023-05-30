package baekjoon.p2606;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static boolean[][] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}

		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		int count = -1; // 1 번 컴퓨터는 카운트 되면 안되기 때문에 -1 로 시작

		q.add(1);
		while (!q.isEmpty()) {
			Integer node = q.poll();
			if (!visited[node]) {
				visited[node] = true;
				count++;

				for (int i = 1; i <= N; i++) {
					if (!visited[i] && graph[node][i]) {
						q.add(i);
					}
				}
			}
		}
		System.out.println(count);
	}
}
