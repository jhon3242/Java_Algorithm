package programmers.level2.p81302;

import java.util.*;

class Solution {
	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int i=0; i<5; i++){
			if (okCk(places[i]))
				answer[i] = 1;
			else
				answer[i] = 0;
		}
		return answer;
	}

	private boolean okCk(String[] graph){
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		for (int i=0; i<5; i++){
			for (int j=0; j<5; j++){
				if (graph[i].charAt(j) == 'P'){
					Queue<int[]> q = new LinkedList<>();
					for (int d=0; d<4; d++){
						int tx = i + dx[d];
						int ty = j + dy[d];
						if (tx < 0 || ty <0 || tx >=5 || ty >=5 || graph[tx].charAt(ty) == 'X')
							continue;
						if (graph[tx].charAt(ty) == 'P')
							return false;
						int[] tmp = new int[2];
						tmp[0] = tx;
						tmp[1] = ty;
						q.add(tmp);
					}
					while (!q.isEmpty()){
						int[] polled = q.poll();
						for (int d=0; d<4; d++){
							int tx = polled[0] + dx[d];
							int ty = polled[1] + dy[d];
							if (tx < 0 || ty <0 || tx >=5 || ty >=5 || (tx == i && ty == j) || graph[tx].charAt(ty) != 'P')
								continue;
							// System.out.println(tx + " " + ty);
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}