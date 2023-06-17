package baekjoon.p1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> list = new ArrayList<>();

		int result = 0;
		for (int num : arr) {
			list = list.stream().filter(v -> v <= num).collect(Collectors.toList());
			if (num != 0 && !list.contains(num)) {
//				System.out.println("list = " + list + " add " + num);
				result++;
				list.add(num);
			}
		}
		System.out.println(result);
	}
}
