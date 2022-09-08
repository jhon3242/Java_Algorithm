package baekjoon.p1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] array;
	static int minCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		minCount = N + 1;

		// init arr
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		binary(0, N);
		System.out.println("minCount = " + minCount);
	}

	public static boolean midSumCk(int length){
		int i = 0;
		int[] subArr;
		int sum;
		while (i + length <= N){
			sum = 0;
			for (int j = i; j < i + length; j++) {
				sum += array[j];
			}
			if (sum >= K)
				return true;
			i++;
		}
		return false;
	}

	public static int binary(int start, int end){
		int mid;

		while (start <= end){
			mid = (start + end) / 2;
			if (midSumCk(mid)){
				minCount = Math.min(minCount, mid);
				return binary(start, mid - 1);
			}
			else{
				return binary(mid + 1, end);
			}
		}
		return start;
	}
}

/**
10 40
5 1 3 5 10 7 4 9 2 8

 */
