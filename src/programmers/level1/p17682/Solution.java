package programmers.level1.p17682;

import java.util.ArrayList;

public class Solution {
	private static ArrayList<Integer> score = new ArrayList<>();
	private static int idx;
	public int solution(String dartResult) {
		int answer = 0;
		int tmp = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			char c = dartResult.charAt(i);
			if (c == 'D' || c == 'S' ||  c == 'T') {
				int powNum = (c == 'S') ? 1 : (c == 'D') ? 2 : 3;
				double bonus = Math.pow(tmp, powNum);

				score.add((int)bonus);
				idx++;
			}
			else if (c == '*' || c == '#') {
				int option = (c == '*') ? 2 : -1;

				score.set(idx - 1, score.get(idx - 1) * option);
				if (idx != 1 && c == '*')
					score.set(idx - 2, score.get(idx - 2) * option);
			}
			else {
//				if (Character.isDigit(dartResult.charAt(i + 1))) {
//					tmp = Integer.parseInt(dartResult, i, i + 2, 10);
//					i++;
//				}
//				else
//					tmp = Integer.parseInt(dartResult, i, i + 1, 10);
			}
		}
		for (Integer num : score)
			answer+= num;
		System.out.println(answer);
		return answer;
	}
}
