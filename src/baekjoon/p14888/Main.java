package baekjoon.p14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	private static List<Integer> arr;
	private static int[] op;
	private static int maxV = Integer.MIN_VALUE;
	private static int minV = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dfs(1, arr.get(0));

		System.out.println(maxV);
		System.out.println(minV);
	}

	private static void dfs(int level, int result) {

		if (level >= arr.size()) {
			maxV = Math.max(maxV, result);
			minV = Math.min(minV, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;

				switch (i) {
					case 0 :
						dfs(level + 1, result + arr.get(level));
						break;
					case 1 :
						dfs(level + 1, result - arr.get(level));
						break;
					case 2 :
						dfs(level + 1, result * arr.get(level));
						break;
					case 3 :
						if (arr.get(level) == 0) break;
						dfs(level + 1, result / arr.get(level));
						break;

				}
				op[i]++;
			}
		}
	}
}
