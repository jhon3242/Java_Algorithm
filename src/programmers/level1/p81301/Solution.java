package programmers.level1.p81301;

import java.util.HashMap;
import java.util.Map;

class Solution {

	static HashMap<String, Integer> numMap = new HashMap<>();

	public int solution(String s) {
		int[] word = {0, 0};
		int result = 0;
		numMap.put("zero", 0);
		numMap.put("one", 1);
		numMap.put("two", 2);
		numMap.put("three", 3);
		numMap.put("four", 4);
		numMap.put("five", 5);
		numMap.put("six", 6);
		numMap.put("seven", 7);
		numMap.put("eight", 8);
		numMap.put("nine", 9);
		for (int i=0; i<s.length(); i++){
			if ('0' <= s.charAt(i) && s.charAt(i) <= '9'){
				result = result * 10 + (s.charAt(i) - '0');
				word[0] = i + 1;
				word[1] = i + 1;
			} else {
				Integer integer = numMap.get(s.substring(word[0], word[1] + 1));
				if (integer != null){
					result = result * 10 + integer;
					word[0] = i + 1;
					word[1] = i + 1;
				}
				else
					word[1]++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("one4seveneight"));
	}
}