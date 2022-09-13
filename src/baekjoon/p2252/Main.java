package baekjoon.p2252;

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<Integer>[] list;
	static int[] indegree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new List[N + 1];
		indegree = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		// init road
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int shor = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			list[shor].add(tall);
			indegree[tall]++;
		}

		for (int i = 1; i < indegree.length; i++) {
			if (indegree[i] == 0){
				queue.add(i);
				System.out.print(i + " ");
			}
		}

		while (!queue.isEmpty()){
			Integer cur = queue.poll();
			for (int i : list[cur]){
				indegree[i]--;
				if (indegree[i] == 0){
					queue.add(i);
					System.out.print(i + " ");
				}
			}
		}
	}
}
