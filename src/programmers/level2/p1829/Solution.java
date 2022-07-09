package programmers.level2.p1829;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	private static int[][] graph;
	private static int g_x;
	private static int g_y;
	private static final int[] dx = {1, 0, -1, 0};
	private static final int[] dy = {0, 1, 0, -1};
	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int[] answer = new int[2];
		graph = new int[m][n];
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				graph[x][y] = picture[x][y];
			}
		}
		System.out.println(graph.toString());
		g_x = m;
		g_y = n;
		for (int x = 0; x < m; x++) {
			for (int y = 0; y < n; y++) {
				if (graph[x][y] > 0){
					numberOfArea++;
					int[] pos = new int[2];
					pos[0] = x;
					pos[1] = y;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(pos));
				}
			}
		}
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	private int bfs(int[] start){
		System.out.println("Solution.bfs");
		int size = 0;
		int myIdx = graph[start[0]][start[1]];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()){
			int[] pos = queue.poll();
			int tx = pos[0], ty = pos[1];
			if (0 <= tx && 0 <= ty  && tx < g_x && ty < g_y && graph[tx][ty] == myIdx){
				System.out.println("tx = " + tx + " ty = " + ty);
				size++;
				graph[tx][ty] = -1;
				for (int i = 0; i < 4; i++) {
					int[] newPos = new int[2];
					newPos[0] = tx + dx[i];
					newPos[1] = ty + dy[i];
					queue.add(newPos);
				}
			}
		}
		return size;
	}
}