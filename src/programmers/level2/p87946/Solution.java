package programmers.level2.p87946;

import java.util.*;

public class Solution {
	private int fatig, maxCount, size;
	private int[] orders;
	private boolean[] visited;
	private int[][] deon;


	public int solution(int k, int[][] dungeons) {
		size = dungeons.length;
		deon = dungeons;
		fatig = k;
		orders = new int[size];
		visited = new boolean[size];
		maxCount = 0;

		Arrays.fill(visited, false);
		bfs(0);

		return maxCount;
	}

	private int maxCountCk(int k){
		int count = 0;
		for (int od : orders){
			if (k >= deon[od][0]){
				k -= deon[od][1];
				count++;
			}
		}
		return count;
	}

	private void bfs(int k){
		if (k == size){
			maxCount = Math.max(maxCount, maxCountCk(fatig));
			return;
		}

		for(int i=0; i<size; i++){
			if (visited[i] == false){
				visited[i] = true;
				orders[k] = i;
				bfs(k + 1);
				visited[i] = false;
			}
		}
	}
}
