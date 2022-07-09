package programmers.level1.p17681;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			String bit = Integer.toBinaryString(arr1[i] | arr2[i]);
			for (int j = bit.length(); j < n; j++) {
				bit = "0" + bit;
			}
			bit = bit.replace("0", " ");
			bit = bit.replace("1", "#");
			System.out.println(bit+"!");
			answer[i] = bit;
		}
		return answer;
	}
}