package programmers.level2.p72412;

import java.util.*;

class Candidate implements Comparable<Candidate>{
	String language, part, career, food;
	int score;

	Candidate(String language, String part, String career, String food, int score){
		this.language = language;
		this.part = part;
		this.career = career;
		this.food = food;
		this.score = score;
	}

	@Override
	public int compareTo(Candidate can){
		if (this.score < can.score){
			return 1;
		}
		else
			return -1;
	}
}

class Solution {
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		List<Candidate> list = new ArrayList<>();

		for (String in : info){
			String[] splited = in.split(" ");
			list.add(new Candidate(splited[0], splited[1], splited[2], splited[3], Integer.parseInt(splited[4])));
		}
		Collections.sort(list);

		for (int i=0; i<query.length; i++){
			String[] splited = query[i].split(" ");
			int minScore = Integer.parseInt(splited[7]);
			int count = 0;
			// System.out.println(i);
			for (Candidate can : list){
				// System.out.println(can.language + " " + can.part + " " + can.career + " " + can.food);
				// System.out.println("score ck");
				if (can.score < minScore)
					break;
				// System.out.println("len ck");
				if (!splited[0].equals("-") && !can.language.equals(splited[0]))
					continue;
				// System.out.println("part ck " + can.part + " " + splited[2]);
				if (!splited[2].equals("-") && !can.part.equals(splited[2]))
					continue;
				// System.out.println("career ck");
				if (!splited[4].equals("-") && !can.career.equals(splited[4]))
					continue;
				// System.out.println("food ck");
				if (!splited[6].equals("-") && !can.food.equals(splited[6]))
					continue;
				count++;
			}
			answer[i] = count;
		}
		return answer;
	}
}