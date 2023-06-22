package baekjoon.p11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static char[][] graph = new char[12][6];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		int result = 0;
		while (explode()) {
			moveDownward();
			result++;
		}
		System.out.println(result);
	}

	private static boolean explode() {
		boolean[][] visited = new boolean[12][6];
		boolean result = false;

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (graph[i][j] == '.') continue;
				if (visited[i][j]) continue;
				List<Integer[]> explodeCandidate = bfs(i, j);
				for (Integer[] pos : explodeCandidate) {
					if (explodeCandidate.size() >= 4) {
						graph[pos[0]][pos[1]] = '.';
						result = true;
					}
					visited[pos[0]][pos[1]] = true;
				}
			}
		}
		return result;
	}

	private static List<Integer[]> bfs(int x, int y) {
		boolean[][] visited = new boolean[12][6];
		Queue<Integer[]> qu = new LinkedList<>();
		int[] dx = new int[]{1, 0, -1, 0};
		int[] dy = new int[]{0, 1, 0, -1};
		char target = graph[x][y];
		qu.add(new Integer[]{x, y});
		List<Integer[]> candidate = new ArrayList<>();

		while (!qu.isEmpty()) {
			Integer[] poll = qu.poll();
			if (visited[poll[0]][poll[1]]) continue;
			visited[poll[0]][poll[1]] = true;

			if (graph[poll[0]][poll[1]] == target) {
				candidate.add(poll);

				for (int i = 0; i < 4; i++) {
					int tx = poll[0] + dx[i];
					int ty = poll[1] + dy[i];
					if (tx < 0 || ty < 0 || tx >= 12 || ty >= 6 || visited[tx][ty]) {
						continue;
					}
					qu.add(new Integer[]{tx, ty});
				}
			}
		}
		return candidate;
	}

	private static void moveDownward() {
		for (int i = 0; i < 6; i++) {
			// 맨 꼭대기는 안해도됨
			for (int j = 11; j > 0; j--) {
				if (graph[j][i] == '.') {
					changeWithTopBlock(i, j);
				}
			}
		}
	}

	private static void changeWithTopBlock(int i, int j) {
		for (int k = j; k >= 0; k--) {
			if (graph[k][i] != '.') {
				graph[j][i] = graph[k][i];
				graph[k][i] = '.';
				break;
			}
		}
	}

	private static void printG(char[][] graph) {
		for (int i = 0; i < 12; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println();
	}
}
