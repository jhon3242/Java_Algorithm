package baekjoon.p2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1 2 5
 * 1 ...
 * 2 + 5
 * 2 2 + 4
 *
 *
 */

public class Main {
	static int n, k;
	static boolean[] canMake;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		canMake = new boolean[k + 1];

		for (int i = 0; i < n; i++) {
			int coin = Integer.parseInt(br.readLine());
			int j = 0;
		}
	}
}

/**
 * 1 7 10
 *
 * 1 (1)
 * 1
 *
 * 2 (2)
 * 1 1
 * 2
 *
 *
 * 3 (2)
 * 1 1 1
 * 2 1
 *
 *
 * 4 (3)
 *
 * 1 1 1 1
 * 2 1 1
 * 2 2
 *
 *
 * 5 (3)
 *
 * 1 1 1 1 1
 * 2 1 1 1
 * 2 2 1
 *
 *
 * 6 (4)
 * 1 1 1 1 1 1 1
 * 2 1 1 1 1
 * 2 2 1 1
 * 2 2 2
 *
 * 7 (5)
 * 1 1 1 1 1 1 1
 * 2 1 1 1 1
 * 2 2 1 1 1
 * 2 2 2 1
 * 7
 *
 *
 * 8 (6)
 * 1 1 1 1 1 1 1 1 1
 * 2 1 1 1 1 1 1
 * 2 2 1 1 1 1
 * 2 2 2 1 1
 * 2 2 2 2
 * 7 1
 *
 * 9 (7)
 * 1 1 1 1 1 1 1 1 1
 * 2 1 1 1 1 1 1 1
 * 2 2 1 1 1 1 1
 * 2 2 2 1 1 1
 * 2 2 2 2 1
 * 7 1 1
 * 7 2
 *
 * 10 : 8
 * 1 1 1 1 1 1 1 1 1 1
 * 2 1 1 1 1 1 1 1 1
 * 2 2 1 1 1 1 1 1
 * 2 2 2 1 1 1 1
 * 2 2 2 2 1 1
 * 2 2 2 2 2
 * 7 1 1 1
 * 7 2 1
 *
 *
 * 11 (9)
 * 1 1 1 1 1 1 1 1 1 1 1
 * 2 1 1 1 1 1 1 1 1 1
 * 2 2 1 1 1 1 1 1 1
 * 2 2 2 1 1 1 1 1
 * 2 2 2 2 1 1 1
 * 2 2 2 2 2 1
 * 7 1 1 1 1
 * 7 2 1 1
 * 7 2 2
 *
 *
 */
