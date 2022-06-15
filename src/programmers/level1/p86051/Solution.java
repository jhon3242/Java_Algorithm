package programmers.level1.p86051;

import java.util.Arrays;

class Solution {
	public int solution(int[] numbers) {
		int answer = -1;
		int[] numArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		for (int num : numbers){
			numArr[num] -= num;
		}
		return Arrays.stream(numArr).sum();
	}
}