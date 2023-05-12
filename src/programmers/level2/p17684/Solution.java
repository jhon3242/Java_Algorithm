package programmers.level2.p17684;

import java.util.*;
import java.util.stream.*;

class Solution {
	private List<String> dict;

	public int[] solution(String msg) {
		List<Integer> answer = new ArrayList<>();
		String cur;
		int prevIdx = -1;
		int i = 0, len = 1;

		init();

		while (i + len <= msg.length()) {
			cur = msg.substring(i, i + len);
			if (indexOfWord(cur) >= 0) {
				prevIdx = indexOfWord(cur);
				len++;
				continue;
			}

			// System.out.println("print " + (prevIdx + 1) + " new word " + cur);
			// System.out.println();
			answer.add(prevIdx + 1);
			dict.add(cur);
			i += len - 1;
			len = 1;
		}
		answer.add(prevIdx + 1);
		// System.out.println("print " + (prevIdx + 1));
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private void init() {
		dict = IntStream.range(0, 26).mapToObj(i -> String.valueOf((char)(i + 'A')))
				.collect(Collectors.toList());
	}

	// 문자가 사전에 있는지 확인
	private int indexOfWord(String word) {
		return dict.indexOf(word);
	}



}
