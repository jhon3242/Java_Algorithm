package baekjoon.p1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int S;
	static int[] array;
	static int minCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		minCount = N + 1;

		// init arr
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		// exception ck
		if (sumArr() < S){
			System.out.println(0);
			return;
		}

		int start = 0;
		int end = 1;
		int sumTmp = array[start];

		while (start < end && end <= N){
			if (sumTmp >= S){
				minCount = Math.min(minCount, end - start);
				sumTmp -= array[start];
				start++;
			}
			else{
				if (end < N){
					sumTmp += array[end];
				}
				end++;
			}
		}
		System.out.println(minCount);
	}

	private static int sumArr() {
		int tmp;

		tmp = 0;
		for (int i = 0; i < array.length; i++) {
			tmp += array[i];
		}
		return tmp;
	}
}

/**
10 40
5 1 3 5 10 7 4 9 2 8
result : 6
 */
