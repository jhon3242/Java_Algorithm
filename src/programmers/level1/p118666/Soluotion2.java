package programmers.level1.p118666;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Soluotion2 {

	public String solution2(String[] survey, int[] choices) {
		String answer = "";
		char[][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
		HashMap<Character, Integer> point = new HashMap<>();

		for (char[] chars : type) {
			point.put(chars[0], 0);
			point.put(chars[1], 0);
		}

		for (int i = 0; i < survey.length; i++) {
			Character mbti;
			if (choices[i] < 4){
				mbti = survey[i].charAt(0);
			}
			else if (choices[i] > 5){
				mbti = survey[i].charAt(1);
			}
			else
				continue;
			point.put(mbti, point.get(mbti) + Math.abs(4 - choices[i]));
		}

		for (char[] chars : type) {
			answer += point.get(chars[0]) < point.get(chars[1]) ? chars[1] : chars[0];
		}
		return answer;
	}

	public String solution(String[] survey, int[] choices) {
		String answer = "";
		Map<String, Integer> store = new HashMap<String, Integer>();
		int[] result = new int[5];

		store.put("R", -1);
		store.put("T", 1);
		store.put("C", -2);
		store.put("F", 2);
		store.put("J", -3);
		store.put("M", 3);
		store.put("A", -4);
		store.put("N", 4);

		for (int i = 0; i < survey.length; i++) {
			int pick = choices[i];
			int value = Math.abs(4 - pick);
			String type;
			if (pick < 4) {
				type = survey[i].substring(0, 1);
			}
			else if (pick > 4){
				type = survey[i].substring(1, 2);
			}
			else{
				continue;
			}

			Integer indexWithType = store.get(type);
			if (indexWithType > 0){
				result[indexWithType] += value;
			}
			else{
				result[(-indexWithType)] -= value;
			}
		}
		System.out.print(Arrays.toString(result));

		if (result[1] > 0)
			answer += "T";
		else
			answer += "R";
		if (result[2] > 0)
			answer += "F";
		else
			answer += "C";
		if (result[3] > 0)
			answer += "M";
		else
			answer += "J";
		if (result[4] > 0)
			answer += "A";
		else
			answer += "N";

		return answer;
	}


}
