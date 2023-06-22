package baekjoon.p14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static int[][] graph = new int[4][8];
	private static int Clock = 1;
	private static int ReClock = -1;
	private static int Right = 2;
	private static int Left = 6;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			graph[i] = br.readLine().chars().map(v -> v - '0').toArray();
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			// 맨 처음 pre 값은 절대 나올 수 없는 값이여야 한다. (-1 이하면 된다)
			dfs(dir, num, -1);
		}
		System.out.println(getScore());
	}

	private static void dfs(int dir, int num, int pre) {
		boolean needRightMove = false;
		boolean needLeftMove = false;

		int[] wheel = graph[num];
		if (num < 3 && pre != num + 1) {
			int[] rightWheel = graph[num + 1];
			if (wheel[Right] != rightWheel[Left]) {
				needRightMove = true;
			}
		}
		if (num > 0 &&  pre != num - 1) {
			int[] leftWheel = graph[num - 1];
			if (wheel[Left] != leftWheel[Right]) {
				needLeftMove = true;
			}
		}
		rotate(dir, num);
		if (needRightMove) dfs(dir * -1, num + 1, num);
		if (needLeftMove) dfs(dir * -1, num - 1, num);
	}

	private static void rotate (int dir, int num) {
		Deque<Integer> wheel = new LinkedList<>(Arrays.stream(graph[num]).boxed().collect(Collectors.toList()));
		if (dir == Clock) {
			wheel.addFirst(wheel.pollLast());
		}
		if (dir == ReClock) {
			wheel.addLast(wheel.pollFirst());
		}
		int[] newWheel = wheel.stream().mapToInt(Integer::intValue).toArray();
		graph[num] = newWheel;
	}

	private static int getScore() {
		int score = 0;
		int N = 0;
		for (int i = 0; i < 4; i++) {
			if (graph[i][0] == N) continue;
			if (i == 0) score += 1;
			if (i == 1) score += 2;
			if (i == 2) score += 4;
			if (i == 3) score += 8;
		}
		return score;
	}
}
