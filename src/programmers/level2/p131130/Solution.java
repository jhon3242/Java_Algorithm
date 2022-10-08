package programmers.level2.p131130;

import java.util.*;

class Solution {
	public int solution(int[] cards) {
		boolean[] visited = new boolean[101];
		int answer = 0, count = 0, tmp_idx;

		Arrays.fill(visited, false);
		List<Integer> countArr = new ArrayList<>();
		for (int i : cards){
			if (visited[i] == false){
				count = 0;
				tmp_idx = i;
				while (visited[tmp_idx] == false){
					visited[tmp_idx] = true;
					tmp_idx = cards[tmp_idx - 1];
					count++;
				}
				countArr.add(count);
			}
		}

		int max1 = Collections.max(countArr);
		countArr.set(countArr.indexOf(max1), 0);
		int max2 = Collections.max(countArr);
		return max1 * max2;
	}
}