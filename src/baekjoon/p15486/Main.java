package baekjoon.p15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] maxPayArr;
	static int[] timeArr;
	static int[] payArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// init
		N = Integer.parseInt(br.readLine());
		maxPayArr = new int[N];
		payArr = new int[N];
		timeArr = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			timeArr[i] = t;
			payArr[i] = p;
		}

		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (timeArr[i] + i <= N) {
				if (i + timeArr[i] < N )
					max = Math.max(max, payArr[i] +  maxPayArr[timeArr[i] + i]);
				else
					max = Math.max(max, payArr[i]);
			}
			maxPayArr[i] = max;
		}
		System.out.println(maxPayArr[0]);
	}
}
