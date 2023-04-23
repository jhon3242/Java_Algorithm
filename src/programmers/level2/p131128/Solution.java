package programmers.level2.p131128;

import java.util.*;

class Solution {
	public String solution(String X, String Y) {
		String answer = "";
		Map<Character, Integer> xStore = new HashMap<>();
		Map<Character, Integer> yStore = new HashMap<>();

		for (int i=0; i<10; i++){
			char t = (char)(i + '0');
			xStore.put(t, 0);
			yStore.put(t, 0);
		}

		for (int i=0; i<X.length(); i++){
			char tmp = X.charAt(i);
			xStore.put(tmp, xStore.get(tmp) + 1);
		}

		for (int i=0; i<Y.length(); i++){
			char tmp = Y.charAt(i);
			yStore.put(tmp, yStore.get(tmp) + 1);
		}

		for (int i=9; i>=0; i--){
			char num = (char)(i + '0');
			int time = Math.min(xStore.get(num), yStore.get(num));
//			answer += String.valueOf(num).repeat(time);
		}
		if (answer.length() == 0)
			return "-1";
		if (answer.charAt(0) == '0')
			return "0";
		return answer;
	}
}
