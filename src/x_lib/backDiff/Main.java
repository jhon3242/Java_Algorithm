package x_lib.backDiff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int[] getRandomIntArr(int size, int[] range) {
		Random random = new Random();
		return random.ints(size, range[0], range[1] + 1).toArray();
	}

	private static int getRandomNum(int[] range) {
		return (int) (Math.random() * (range[1] - range[0] + 1)) + range[0];
	}

	public static void main(String[] args) throws IOException {

		for (int i = 0; i < 1; i++) {
			int n = getRandomNum(new int[]{1, 10});
			int k = getRandomNum(new int[]{1, 10});
			List<Integer[]> road = new ArrayList<>();

			for (int j = 0; j < k; j++) {
				road.add(new Integer[]{getRandomNum(new int[]{1, n}), getRandomNum(new int[]{1, n})});
			}

			int myResult = My.main(n, road);
			int anResult = An.main(n, road);

			if (myResult != anResult) {
				System.out.println("myResult = " + myResult + " anResult " + anResult);
				for (Integer[] integers : road) {
					System.out.println(Arrays.toString(integers));
				}
			}
		}

	}
}


class My {
	private static int N;
	private static int[] parents;

	public static int main(int n, List<Integer[]> road) {


		N = n;
		parents = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < road.size(); i++) {
			Integer[] ro = road.get(i);
			int a = ro[0];
			int b = ro[1];
			if (findParents(a) != findParents(b)) {
				unionParents(a, b);
			}
		}

		int result = 0;
		for (int i = 2; i <= N; i++) {
			if (findParents(i) == findParents(1)) result++;
		}
		return result;
	}

	private static int findParents(int x) {
		if (parents[x] != x) parents[x] = findParents(parents[x]);
		return parents[x];
	}

	private static void unionParents(int a, int b) {
		int aR = findParents(a);
		int bR = findParents(b);
		if (aR < bR) parents[b] = aR;
		else parents[a] = bR;
	}
}

class An {
	private static int N;
	private static boolean[][] graph;
	private static boolean[] visited;

	public static int main(int n, List<Integer[]> road) {
		N = n;
		graph = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < road.size(); i++) {
			Integer[] ro = road.get(i);
			int a = ro[0];
			int b = ro[1];
			graph[a][b] = true;
			graph[b][a] = true;
		}

		return bfs();
	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		int count = -1; // 1 번 컴퓨터는 카운트 되면 안되기 때문에 -1 로 시작

		q.add(1);
		while (!q.isEmpty()) {
			Integer node = q.poll();
			if (!visited[node]) {
				visited[node] = true;
				count++;

				for (int i = 1; i <= N; i++) {
					if (!visited[i] && graph[node][i]) {
						q.add(i);
					}
				}
			}
		}
		return count;
	}
}