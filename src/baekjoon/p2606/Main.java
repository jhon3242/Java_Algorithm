package baekjoon.p2606;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
8
7
8 2
1 1
3 4
3 8
3 1
6 5
5 8
 */
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
			unionParents(a, b);
		}

		for (int i = 1; i <= N; i++) {
			findParents(i);
		}

		int result = 0;
		int target = findParents(1);
		for (int i = 2; i <= N; i++) {
			if (findParents(i) == target) result++;
		}
		System.out.println(result);
	}

	private static int findParents(int x) {
		if (parents[x] == x) return x;
		return parents[x] = findParents(parents[x]);
	}

	private static void unionParents(int a, int b) {
		int aR = findParents(a);
		int bR = findParents(b);
		if (aR < bR) parents[bR] = aR;
		else parents[aR] = bR;
	}
}
