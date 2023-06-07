package baekjoon.p13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static int K;
	private static StringBuilder result = new StringBuilder();
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dfs(N, K);

		System.out.println(count);
		System.out.println(result);
	}

	private static void dfs(int cur, int end) {

		if (cur == end) {
			result.append(end);
			result.append(" ");
			return;
		}

		if (cur > end) {
			count += cur - end;
			for (int i = cur; i >= end; i--) {
				result.append(i);
				result.append(" ");
			}
			return;
		}

		int div = end / 2;
		int divDiff = Math.abs(cur - div);
		int curDiff = Math.abs(cur - end);

		if (divDiff < curDiff) {

			dfs(cur, div);

			if (end != 1 && end % 2 == 1) {
				result.append(end - 1);
				result.append(" ");
				count++;
			}
			result.append(end);
			result.append(" ");
			count++;


		} else {
			count += end - cur;
			for (int i = cur; i <= end; i++) {
				result.append(i);
				result.append(" ");
			}
		}
	}
}
