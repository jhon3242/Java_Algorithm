package programmers.level2.p81302;

import java.util.*;

class Solution {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static String[] graph;
	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int i=0; i<5; i++){
			visited = new boolean[5][5];
			graph = places[i];
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (graph[i].charAt(k) == 'P'){
						visited[j][k] = true;
					}
				}
			}
		}
		return answer;
	}

	private boolean dfs(int x, int y, int d, boolean result){
		if (result == false)
			return result;
		for (int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if (tx < 0 || ty < 0 || tx >=5 || ty >=5 || visited[tx][ty])
				continue;

		}

		return result;
	}
}