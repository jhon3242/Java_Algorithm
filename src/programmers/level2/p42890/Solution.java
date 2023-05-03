package programmers.level2.p42890;


/**
 * BFS 로 구현하여 통과
 */

import java.util.*;

class Solution {
	private static int columns;
	private static int answer = 0;
	private static List<List<Integer>> answerList = new ArrayList<List<Integer>>();


	public int solution(String[][] relation) {
		// init
		this.columns = relation[0].length;

		// boolean re = isKey(relation, Arrays.asList(1, 3));
		// print("" + re);
		// dfs(relation, new ArrayList<>(), 0);
		bfs(relation);

		// answerList.add(Arrays.asList(1, 5));
		// boolean an = isMinimun(Arrays.asList(1,3,2,4));
		// print(an + "");

		return this.answer;
	}

	private void bfs(String[][] relation) {
		Queue<List<Integer>> qu = new LinkedList<>();

		for (int i = 0 ; i < columns; i++) {
			qu.add(Arrays.asList(i));
		}
		// print(qu.toString());
		while (!qu.isEmpty()) {
			List<Integer> candidate = qu.poll();
			if (isMinimun(candidate) && isKey(relation, candidate)) {
				// print("answer! " + candidate.toString());
				answerList.add(candidate);
				this.answer++;
				continue;
			}
			Integer lastIdx = candidate.get(candidate.size() - 1);
			for (int i = lastIdx + 1; i < columns; i++) {
				List<Integer> newList = new ArrayList<>();
				newList.addAll(candidate);
				newList.add(i);
				// print(candidate.toString() + " add " + i + " " + newList.toString());
				qu.add(newList);
			}
		}


	}

	private boolean isKey(String[][] relation, List<Integer> candidates) {
		Map<String, Integer> store = new HashMap<>();

		for (String[] line : relation) {
			String tmpKey = "";

			for (int i = 0 ; i < candidates.size(); i++) {
				tmpKey += line[candidates.get(i)];
			}

			if (store.containsKey(tmpKey)) {
				// print("have " + tmpKey);
				return false;
			}
			// print("add " + tmpKey);
			store.put(tmpKey, 1);
		}
		return true;
	}

	private boolean isMinimun(List<Integer> candidate) {
		for (int i = 0 ; i < answerList.size(); i++) {
			List<Integer> tmpAnswer = answerList.get(i);
			if (candidate.containsAll(tmpAnswer)) return false;
		}
		return true;
	}

	private void print(String s) {
		System.out.println(s);
	}
}