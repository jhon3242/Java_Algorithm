// https://programmers.co.kr/learn/courses/30/lessons/42840

package programmers.level1.p42840;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	static int[] type1 = {1,2,3,4,5};
	static int[] type2 = {2, 1, 2, 3, 2, 4, 2, 5};
	static int[] type3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	static int[] matchCount = {0, 0, 0};
	public int[] solution(int[] answers) {
		int[] answer;
		ArrayList<Integer> tmp = new ArrayList<>();

		for (int i=0; i<answers.length; i++){
			if (answers[i] == type1[i % type1.length])
				matchCount[0]++;
			if (answers[i] == type2[i % type2.length])
				matchCount[1]++;
			if (answers[i] == type3[i % type3.length])
				matchCount[2]++;
		}
		int max = Arrays.stream(matchCount).max().getAsInt();
		for (int i=0; i<3; i++){
			if (matchCount[i] == max)
				tmp.add(i + 1);
		}
		answer = new int[tmp.size()];
		for (int i=0; i<tmp.size(); i++)
			answer[i] = tmp.get(i);
		return answer;
	}

	public static void main(String[] args) {
		int[] tmp ={1,2,3,4,5};
		Solution solution = new Solution();
		int[] solution1 = solution.solution(tmp);
		System.out.println(Arrays.toString(solution1));
	}
}