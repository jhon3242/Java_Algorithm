package baekjoon.p2606;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		int k = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (findParents(a) != findParents(b)) {
				unionParents(a, b);
			}
		}

		int result = 0;
		for (int i = 2; i <= N; i++) {
			if (findParents(i) == findParents(1)) result++;
		}
		System.out.println(result);
	}

	private static int findParents(int x) {
		if (parents[x] != x) parents[x] = findParents(parents[x]);
		return parents[x];
	}

	private static void unionParents(int a, int b) {
		int aR = findParents(a);
		int bR = findParents(b);
		if (aR < bR) parents[b] = aR;
		else parents[a] = bR;
	}
}
