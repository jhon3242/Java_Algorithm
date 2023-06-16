package baekjoon.p23971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int H;
	private static int W;
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int i = 0;
		int rowMax = 0;
		while (i < H) {
			i += 1 + N;
			rowMax++;
		}

		i = 0;
		int colMax = 0;
		while (i < W) {
			i += 1 + M;
			colMax++;
		}
		System.out.println(rowMax * colMax);
	}
}
