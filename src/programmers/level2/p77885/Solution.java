package programmers.level2.p77885;

import java.util.*;

class Solution {
	private static String target;

	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i=0; i<numbers.length; i++){
			long cur = numbers[i];

			target = Long.toString(cur, 2);
			int k = 1;
			while (!oneOrTwo(cur + k)){
				k++;
			}
			answer[i] = cur + k;
		}
		return answer;
	}

	private boolean oneOrTwo(long num){
		String bit = Long.toString(num, 2);
		int count = 0;

		if (target.length() < bit.length()){
			target = "0" + target;
		}
		for (int i=bit.length() -1; i>=0; i--){
			if (bit.charAt(i) != target.charAt(i)){
				count++;
			}
			if (count > 2)
				return false;
		}
		return true;
	}
}