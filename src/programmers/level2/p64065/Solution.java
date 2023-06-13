package programmers.level2.p64065;

import java.util.*;
import java.util.regex.*;

/**
 System.out.println("x " + x);
 System.out.println("x " + Arrays.toString(x));
 */

class Solution {
	private int N;
	private Map<Integer, Integer> sumMap = new HashMap<>();
	public int[] solution(String s) {
		List<Integer> answer = new ArrayList<>();

		Matcher matcher = Pattern.compile("\\{[0-9,]*\\}").matcher(s);
		while (matcher.find()) {
			String arrStr = matcher.group();
			String[] splited = arrStr.substring(1, arrStr.length() - 1).split("\\,");
			int sum = Arrays.stream(splited)
					.mapToInt(Integer::parseInt)
					.sum();
			sumMap.put(splited.length, sum);
		}

		int prev = 0;
		for (int i = 1 ; i <= sumMap.size(); i++) {
			answer.add(sumMap.get(i) - prev);
			prev = sumMap.get(i);
		}


		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}