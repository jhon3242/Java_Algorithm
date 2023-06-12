package baekjoon.p9470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int K;
	private static int M;
	private static int P;
	private static List[] graph;
	private static int[] stra;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			init(br);
			getResult();
//			System.out.println(Arrays.toString(stra));
			System.out.println(K + " " + getResult());
		}
	}

	private static void init(BufferedReader br) throws IOException{
		StringTokenizer st;
		graph = new ArrayList[M + 1];
		stra = new int[M + 1];

		for (int i = 1; i <= M; i++) {
			graph[i] = new ArrayList<Integer>();
			stra[i] = 0;
		}

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			graph[end].add(start);
		}

		for (int i = 1; i <= M; i++) {
			if (graph[i].size() == 0) {
				stra[i] = 1;
			}
		}
//		System.out.println(Arrays.toString(stra));


	}

	private static int getResult() {

		int result = 0;


		op();

		for (int i = 1; i <= M; i++) {
			result = Math.max(result, stra[i]);
		}

		return result;
	}

	private static void op() {

		for (int i = 1; i <= M; i++) {
			if (stra[i] == 0) {
				getP(i);
			}
		}
	}

	private static void getP(int cur) {
		List<Integer> list = graph[cur];
		int maxValue = 0;

		for (Integer node : list) {
			if (stra[node] == 0) getP(node);
			maxValue = Math.max(stra[node], maxValue);
		}

		int finalMaxValue = maxValue;
		int count = (int)list.stream().filter(v -> stra[v] == finalMaxValue).count();

		if (count >= 2) {
			stra[cur] = maxValue + 1;
		} else {
			stra[cur] = maxValue;
		}

	}

}
