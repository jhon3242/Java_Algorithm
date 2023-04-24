package programmers.level1.p150370;

import java.util.*;

class Solution {
	private static Map<String, Integer>termMap = new HashMap<>();

	private void initTerm(String[] terms) {
		for (String term : terms) {
			String[] splited = term.split(" ");
			termMap.put(splited[0], Integer.parseInt(splited[1]));
		}
	}

	private String[] getAterDay(String privacie) {
		String[] splited = privacie.split(" ");
		String day = splited[0];
		String option = splited[1];
		String[] daySplited =  day.split("\\.");
		// System.out.println(Arrays.toString(daySplited));
		// System.out.println(daySplited[0]);
		Integer month = Integer.parseInt(daySplited[1]) + termMap.get(option);
		daySplited[0] = String.valueOf(Integer.parseInt(daySplited[0]) + month / 12);
		daySplited[1] = String.valueOf(month % 12);
		// System.out.println(month);
		// System.out.println(Arrays.toString(daySplited));
		return daySplited;
	}

	private boolean isDone(String[] today, String[] target) {

		Date dToday = new Date(Integer.parseInt(today[0]), Integer.parseInt(today[1]), Integer.parseInt(today[2]));
		Date dTarget = new Date(Integer.parseInt(target[0]), Integer.parseInt(target[1]), Integer.parseInt(target[2]));
		return !dToday.before(dTarget);
	}

	public int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<>();
		int number = 1;
		String[] todaySplited = today.split("\\.");

		initTerm(terms);
		for (String privacie : privacies) {
			String[] afterDay = getAterDay(privacie);
			if (isDone(todaySplited, afterDay)) {
				answer.add(number);
			}
			number++;
		}


		return answer.stream().mapToInt(i -> i).toArray();
	}
}