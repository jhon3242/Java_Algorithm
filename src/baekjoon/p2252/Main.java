package baekjoon.p2252;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static List<Integer>[] graph;
	private static int[] indegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> qu = new LinkedList<>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		indegree = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start].add(end);
			indegree[end]++;
		}

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				qu.add(i);
			}
		}

		while (!qu.isEmpty()) {
			int poll = qu.poll();
			System.out.print(poll + " ");
			for (int i : graph[poll]) {
					indegree[i]--;
					if (indegree[i] == 0) {
						qu.add(i);
					}
			}
		}
		System.out.println();
	}
}


//import java.util.*;
//import java.io.*;
//
//public class Main {
//	static int N, M;
//	static List<Integer>[] list;
//	static int[] indegree;
//
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		Queue<Integer> queue = new LinkedList<>();
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		list = new List[N + 1];
//		indegree = new int[N + 1];
//		for (int i = 0; i <= N; i++) {
//			list[i] = new ArrayList<>();
//		}
//
//		// init road
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int shor = Integer.parseInt(st.nextToken());
//			int tall = Integer.parseInt(st.nextToken());
//			list[shor].add(tall);
//			indegree[tall]++;
//		}
//
//		for (int i = 1; i < indegree.length; i++) {
//			if (indegree[i] == 0){
//				queue.add(i);
//				System.out.print(i + " ");
//			}
//		}
//
//		while (!queue.isEmpty()){
//			Integer cur = queue.poll();
//			for (int i : list[cur]){
//				indegree[i]--;
//				if (indegree[i] == 0){
//					queue.add(i);
//					System.out.print(i + " ");
//				}
//			}
//		}
//	}
//}
