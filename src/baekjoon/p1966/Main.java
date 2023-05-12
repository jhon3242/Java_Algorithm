package baekjoon.p1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Integer> qu = new LinkedList<Integer>();
			Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(qu::add);

		}
	}

	private static int getResult(Queue<Integer> qu, int idx) {
		int count = 0;
		Integer max;
		while (true) {
			Integer poll = qu.poll();
			if (idx == 0) {
				max = Collections.max(qu);
				if (poll <= max) {
					return count;
				}

				continue;
			}
			qu.add(poll);
			idx--;
		}
	}
}
