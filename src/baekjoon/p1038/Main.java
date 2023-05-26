package baekjoon.p1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int result = 0;

		if (N == 0) {
			System.out.println(0);
			return;
		}

		for (long i = 1; i <= Long.parseLong("9876543210"); i++) {
			if (isDecrease(i)) {
				result++;
				if (result == N) {
					System.out.println(i);
					break;
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean isDecrease(long n) {
		String str = String.valueOf(n);
		int num = Integer.parseInt(str.substring(0, 1));

		for (int i = 1; i < str.length(); i++) {
			if (num <= Integer.parseInt(str.substring(i, i + 1))) {
				return false;
			}
			num = Integer.parseInt(str.substring(i, i + 1));
		}
		return true;
	}
}
