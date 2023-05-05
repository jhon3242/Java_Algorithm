package programmers.level2.p42586;

import java.util.*;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();
		int tmp = 0;
		int i = 0;
		while (i < progresses.length) {
			if (progresses[i] < 100) {
				if (tmp != 0) {
					answer.add(tmp);
					tmp = 0;
				}
				add(progresses, speeds);
				continue;
			}
			tmp++;
			i++;
		}
		answer.add(tmp);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private void add(int[] progresses, int[] speeds) {
		for (int i = 0 ; i < progresses.length; i++) {
			progresses[i] += speeds[i];
		}
	}
}