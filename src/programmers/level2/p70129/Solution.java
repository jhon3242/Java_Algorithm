package programmers.level2.p70129;

import java.util.*;

class Solution {
	public int[] solution(String s) {
		int[] answer = new int[2];

		while (!s.equals("1")){
			answer[0]++;
			answer[1] += getZeroCount(s);

			s = s.replaceAll("0", "");
			s = Integer.toString(s.length(), 2);
		}
		return answer;
	}

	private int getZeroCount(String s){
		int count = 0;
		for (int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if (c == '0')
				count++;
		}
		return count;
	}
}