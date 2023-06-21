package baekjoon.p15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static int M;
	private static int[][] graph;
	private static int result = Integer.MAX_VALUE;
	private static List<Integer[]> stores = new ArrayList<>();
	private static List<Integer[]> houses = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][N];

		init(br);
		dfs(0, -1, new ArrayList<>());
		System.out.println(result);
	}

	private static void init(BufferedReader br) throws IOException {
		for (int i = 0; i < N; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 2) {
					stores.add(new Integer[]{i, j});
					graph[i][j] = 0;
					continue;
				}
				if (graph[i][j] == 1) {
					houses.add(new Integer[]{i, j});
				}
			}
		}
	}

	private static void dfs(int level, int cur, List<Integer> indexs) {
		if (level == M) {
			op(indexs);
			return;
		}

		for (int i = cur + 1; i < stores.size(); i++) {
			indexs.add(i);
			dfs(level + 1, i, indexs);
			indexs.remove(indexs.size() - 1);
		}
	}

	private static void op(List<Integer> indexs) {
		int chickenDis = getChickenDis(indexs);
		result = Math.min(result, chickenDis);
	}

	// 치킨거리 구하기
	private static int getChickenDis(List<Integer> indexs) {
		int[][] distanceG = getDistanceG(indexs);
		int result = 0;
		for (Integer[] house : houses) {
			result += distanceG[house[0]][house[1]];
		}
		return result;
	}

	private static int[][] getDistanceG(List<Integer> indexs) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[][] distanceG = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(distanceG[i], -1);
		}
		int[] dx = new int[]{1, 0, -1, 0};
		int[] dy = new int[]{0, 1, 0, -1};

		for (Integer index : indexs) {
			Integer[] store = stores.get(index);
			pq.add(new Node(store[0], store[1], 0));
		}

		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			if (distanceG[poll.x][poll.y] != -1) {
				continue;
			}
			distanceG[poll.x][poll.y] = poll.dis;
			for (int i = 0; i < 4; i++) {
				int tx = dx[i] + poll.x;
				int ty = dy[i] + poll.y;

				if (tx < 0 || ty < 0 || tx >= N || ty >= N) {
					continue;
				}
				if (distanceG[tx][ty] != -1 && distanceG[tx][ty] < poll.dis + 1) {
					continue;
				}
				pq.add(new Node(tx, ty, poll.dis + 1));
			}
		}
		return distanceG;
	}


	static class Node implements Comparable<Node> {
		int x;
		int y;
		int dis;

		public Node(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return dis - o.dis;
		}
	}

	private static void printG(int[][] graph) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println();
	}
}
