package baekjoon.p16197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	private static int N;
	private static int M;
	private static int result = Integer.MAX_VALUE;
	private static int[] dx = new int[]{-1, 0, 1, 0};
	private static int[] dy = new int[]{0, 1, 0, -1};
	private static char[][] graph;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer[]> coins = new ArrayList<>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];


		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 'o') {
					coins.add(new Integer[]{i, j});
					graph[i][j] = '.';
				}

			}
		}


		for (int i = 0; i < 4; i++) {
			dfs(1, i, coins.get(0), coins.get(1));
		}



		if (result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}

	/**
	 * 새로운 graph 를 만들지 않으면 동전이 이동했을 때 해당 위치에 동전이 있을 때,
	 * 이게 이동하기 전 동전이지, 이동 후 동전인지 파악하기 어렵다.
	 * ->
	 * 그냥 동전이 없는 맵을 가지고 있고 동전 위치를 배열로만 가지고 있으면,
	 * 계속 맵을 복사할 필요가 없다. + 이전 동전 위치도 저장하고 있어야 나중에 원래대로 돌아갈 수 있으므로 인수로 받아야한다.
	 *
	 */
	private static void dfs(int level, int dir, Integer[] coinA, Integer[] coinB) {
//		System.out.println("level = " + level);

		if (level > result) {
			return;
		}

		int outCount = 0;

		Integer[] tmpA = coinA.clone();
		Integer[] tmpB = coinB.clone();
		List<Integer[]> coins = new ArrayList<>();
		coins.add(tmpA);
		coins.add(tmpB);

		for (Integer[] coin : coins) {
			coin[0] += dx[dir];
			coin[1] += dy[dir];

			if (coin[0] < 0 || coin[1] < 0 || coin[0] >= N || coin[1] >= M) {
				outCount++;
				continue;
			}

			// wall
			if (graph[coin[0]][coin[1]] == '#') {
				coin[0] -= dx[dir];
				coin[1] -= dy[dir];
			}
		}


		if (isOverlap(coins) || isNotMove(tmpA, tmpB, coinA, coinB)) {
			return;
		}
		if (outCount == 1 || outCount == 2) {
			if (outCount == 1) {
//				System.out.println("level = " + level);
//				System.out.println("coins.get(0) = " + Arrays.toString(coins.get(0)));
//				System.out.println("coins.get(1) = " + Arrays.toString(coins.get(1)));
//				System.out.println();
				result = Math.min(result, level);
			}
			return;
		}

		if (level + 1 >= result) return; // 낭비 연산 방지

		for (int i = 0; i < 4; i++) {
			if ((i + 2) % 4 == dir) continue;
			dfs(level + 1, i, coins.get(0), coins.get(1));
		}
		
	}

	private static boolean isOverlap(List<Integer[]> coins) {
		Integer[] coinA = coins.get(0);
		Integer[] coinB = coins.get(1);
		return Objects.equals(coinA[0], coinB[0]) && Objects.equals(coinA[1], coinB[1]);
	}

	private static boolean isNotMove(Integer[] tmpA, Integer[] tmpB, Integer[] coinA, Integer[] coinB) {
		return Objects.equals(tmpA[0], coinA[0]) &&
				Objects.equals(tmpA[1], coinA[1]) &&
				Objects.equals(tmpB[0], coinB[0]) &&
				Objects.equals(tmpB[1], coinB[1]);
	}

}
