package baekjoon.p2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
