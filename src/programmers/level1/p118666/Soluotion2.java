package programmers.level1.p118666;


/**
 * 2차 풀이
 * stream 을 사용
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.*;
import java.util.stream.*;

class Solution2 {
	private static Map<String, Integer> mbtiMap = new HashMap<>();

	private void initMap() {
		mbtiMap.put("RT", 0);
		mbtiMap.put("CF", 0);
		mbtiMap.put("JM", 0);
		mbtiMap.put("AN", 0);
	}

	private void initSurvey(String[] survey, int[] choices) {
		for (int i = 0 ; i < survey.length; i++) {
			String key;
			int score = choices[i] - 4;
			key = survey[i];
			if (!"RCJA".contains(key.substring(0, 1))) {
				score *= -1;
				key = new StringBuilder(key).reverse().toString();
			}
			final int sc = score;
			mbtiMap.compute(key, (k, v) -> v + sc);
		}
	}

	private String getAnswer() {
		return mbtiMap.entrySet()
				.stream()
				.map(entry -> {
					if (entry.getValue() <= 0) {
						return entry.getKey().substring(0, 1);
					} else {
						return entry.getKey().substring(1);
					}
				})
				.collect(Collectors.joining());
	}

	public String solution(String[] survey, int[] choices) {
		initMap();
		initSurvey(survey, choices);
		return getAnswer();
	}
}
