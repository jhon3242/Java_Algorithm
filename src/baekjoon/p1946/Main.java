package baekjoon.p1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 1회차 시간초과
 */

public class Main {

	private static List<Integer[]> store;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N =  Integer.parseInt(br.readLine());
			store = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				store.add( new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			Collections.sort(store, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0] );
			int result = op();
			System.out.println(result);
		}
	}

	private static int op() {
		boolean[] fail = new boolean[N + 1];

		for (int i = 0; i < store.size(); i++) {
			findFail(i, fail);
		}
		int result = N;

		for (int i = 0; i < fail.length; i++) {
			if (fail[i]) result--;
		}
		return result;
	}

	private static void findFail(int i, boolean[] fail) {
		if (fail[i]) return;
		Integer[] info = store.get(i);
		for (int j = 0; j < store.size(); j++) {
			Integer[] tmp = store.get(j);
			if (info[0] < tmp[0] && info[1] < tmp[1]) {
				fail[j] = true;
				continue;
			}

			if (info[0] > tmp[0] && info[1] > tmp[1]) {
				fail[i] = true;
			}
		}
	}
}
