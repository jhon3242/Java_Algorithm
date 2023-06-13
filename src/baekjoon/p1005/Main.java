package baekjoon.p1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static int W;
	private static int[] costArr;
	private static boolean[] visited;
	private static List[] graph;
	private static int result;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);


	}

	private static void init(BufferedReader br) throws IOException {
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			graph = new ArrayList[N + 1];
			visited = new boolean[N + 1];
			costArr = Arrays.stream(("0 " + br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
			result = 0;

			for (int j = 1; j <= N; j++) {
				graph[j] = new ArrayList<Integer>();
			}

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph[end].add(start);
			}
			W = Integer.parseInt(br.readLine());

			op(W);
			result += costArr[W];
			System.out.println(result);
		}
	}

	private static void op(int cur) {
		int costTime = 0;

		if (visited[cur]) return;

		for (Object o : graph[cur]) {
			Integer o1 = (Integer) o;
			if (!visited[o1]) {
				op(o1);
				visited[o1] = true;
				costTime = Math.max(costArr[o1], costTime);
			}
		}
		System.out.println("cur = " + cur);
		System.out.println("pre costTime = " + costTime);
		System.out.println();
		result += costTime;
	}
}
