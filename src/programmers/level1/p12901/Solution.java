package programmers.level1.p12901;

import java.util.Arrays;

public class Solution {
	public String solution(int a, int b) {
		int[] month = {0, 31, 29, 31, 30 ,31, 30,31,31,30,31,30,31};
		int[] sumMonth = new int[13];
		String[] week = {"THU", "FRI","SAT", "SUN","MON","TUE","WED"};

		sumMonth[0] = 0;
		for (int i=1; i<month.length; i++){
			sumMonth[i] = sumMonth[i - 1] + month[i];
		}

		int days = sumMonth[a - 1] + b;
		return Arrays.asList(week).get(days % 7);
	}
}