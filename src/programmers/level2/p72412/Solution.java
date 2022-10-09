package programmers.level2.p72412;

import java.util.*;

class Solution {
	Map<String, LinkedList> store = new HashMap<>();
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		store.put("python", new LinkedList<>());
		store.put("cpp", new LinkedList<>());
		store.put("java", new LinkedList<>());

		for(String in : info){
			String[] split = in.split(" ");
			int part = split[1].equals("backend") ? 1 : 2;
			int career = split[2].equals("junior") ? 1 : 2;
			int food = split[3].equals("chicken") ? 1 : 2;
			int score = Integer.parseInt(split[4]);
			store.get(split[0]).add(new int[]{part, career, food, score});
		}

		Collections.sort(store.get("python"), new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[3] - o1[3];
			}
		});
		Collections.sort(store.get("cpp"), new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[3] - o1[3];
			}
		});
		Collections.sort(store.get("java"), new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[3] - o1[3];
			}
		});
		int idx = 0;
		for(String q : query){
			String[] split = q.split(" ");
			String lan = split[0];
			int part = split[2].equals("backend") ? 1 : split[2].equals("frontend") ? 2 : 0;
			int career = split[4].equals("junior") ? 1 : split[4].equals("senior") ? 2 : 0;
			int food = split[6].equals("chicken") ? 1 : split[6].equals("pizza") ? 2 : 0;
			int score = Integer.parseInt(split[7]);

			int[] target = new int[]{part, career, food, score};
			// all
			if (lan.equals("-")){
				answer[idx] += getMatchCount(store.get("python"), target);
				answer[idx] += getMatchCount(store.get("cpp"), target);
				answer[idx] += getMatchCount(store.get("java"), target);
			}
			else{
				answer[idx] += getMatchCount(store.get(lan), target);
			}
			idx++;
		}

		return answer;
	}

	private int getMatchCount(LinkedList<int[]> list, int[] target){
		int count = 0;
		for (int[] cur : list){
			if (cur[3] < target[3])
				return count;
			if (target[0] != 0 && cur[0] != target[0])
				continue;
			if (target[1] != 0 && cur[1] != target[1])
				continue;
			if (target[2] != 0 && cur[2] != target[2])
				continue;
			count++;
		}
		return count;
	}
}