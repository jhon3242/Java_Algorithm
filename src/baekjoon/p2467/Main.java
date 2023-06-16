package baekjoon.p2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] result = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int s = 0;
		int e = N - 1;

		while (s < e) {
			int tmpScore = arr[s] + arr[e];
			if (tmpScore == 0) {
				System.out.println(arr[s] + " " + arr[e]);
				return;
			}
			if (Math.abs(result[0]) > Math.abs(tmpScore)) {
				result[0] = tmpScore;
				result[1] = arr[s];
				result[2] = arr[e];
			}

			if (tmpScore > 0) {
				e--;
			} else {
				s++;
			}
		}

		System.out.println(result[1] + " " + result[2]);
	}
}
