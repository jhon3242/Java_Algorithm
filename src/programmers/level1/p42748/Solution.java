package programmers.level1.p42748;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int start, end, k, i = 0;

		for (int[] command : commands) {
			start = command[0] - 1;
			end = command[1];
			k = command[2] - 1;

			int[] array1 = Arrays.copyOfRange(array, start, end);
			Arrays.sort(array1);
			answer[i++] = array1[k];
		}
		System.out.println(answer);
		return answer;
	}
}
