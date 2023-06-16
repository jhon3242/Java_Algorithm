package baekjoon.p1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Road> roads = new PriorityQueue<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M + 1];

		for (int i = 1; i <= M; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			roads.add(new Road(s, e, c));


		}

		while (!roads.isEmpty()){
			Road road = roads.poll();
			int s = road.s;
			int e = road.e;
			int c = road.c;
			if (e > M) continue;
			// update
			if (arr[s] + c < arr[e]) {
				int add = 0;
				for (int j = e; j <= M; j++) {
					arr[j] = Math.min(arr[j], arr[s] + c + add);
					add++;
				}
			}

		}
		System.out.println(arr[M]);
	}

	static class Road implements Comparable<Road> {
		int s;
		int e;
		int c;

		public Road(int s, int e, int c) {
			this.s = s;
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Road o) {
			return e - o.e;
		}
	}
}
