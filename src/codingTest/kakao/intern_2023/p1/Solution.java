package codingTest.kakao.intern_2023.p1;

import java.util.*;

class Solution {
	private static int today;
	private static Map<String, Integer> policy;
	public int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<>();
		this.today = dayToNum(today);
		policy = new HashMap<>();

		for (String term : terms){
			String[] tmp = term.split(" ");
			policy.put(tmp[0], Integer.parseInt(tmp[1]));
		}

		for (int i=0; i<privacies.length; i++){
			String pri = privacies[i];
			String[] tmp = pri.split(" ");
			String date = tmp[0];
			String pol = tmp[1];
			int now = dayToNum(date) + (policy.get(pol))*28;
			if (this.today >= now){
				// System.out.println("today : " + this.today + " now : " + now);
				answer.add(i + 1);
			}
		}

		int[] result = new int[answer.size()];
		for (int i=0; i<answer.size(); i++){
			result[i] = answer.get(i);
		}

		return result;
	}

	private int dayToNum(String date){
		int result = 0;
		String[] splited = date.split("\\.");
		int year = Integer.parseInt(splited[0]);
		int month = Integer.parseInt(splited[1]);
		int day = Integer.parseInt(splited[2]);

		result += day;
		result += (month -1) * 28;
		result += (year - 2000)*12*28;
		return result;
	}
}