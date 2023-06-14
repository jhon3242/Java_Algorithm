package programmers.level2.p17680;

import java.util.*;

class Solution {

	private Deque<String> de = new LinkedList<>();
	private int N;

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		N = cacheSize;

		for (String city : cities) {
			answer += addCache(city);
		}

		return answer;
	}

	private int addCache(String str) {
		str = str.toUpperCase();
		if (N > 0 && de.contains(str)) {
			de.remove(str);
			de.addFirst(str);
			return 1;
		}
		if (de.size() >= N) {
			de.pollLast();
		}
		de.addFirst(str);
		return 5;
	}


}