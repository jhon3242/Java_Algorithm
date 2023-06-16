package baekjoon.p22233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static Set<String> store = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			store.add(br.readLine());
		}

		for (int i = 0; i < M; i++) {
			String[] split = br.readLine().split("\\,");
			for(String sp : split) {
				store.remove(sp);
			}
			System.out.println(store.size());
		}

	}
}
