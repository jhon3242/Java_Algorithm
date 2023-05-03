package programmers.level2.p42890;


/**
 * 정확성: 42.9
 * 합계: 42.9 / 100.0
 * DFS 로 구현해보았는데 이러면 3번 칼럼 단독으로 있을 때도 후보키인데
 * 앞에서 부터 확인해서 1, 2, 일 때 까지 없다가 1, 2, 3 일 때 후보키가 된다고 판단할 수 있다.
 * 따라서 BFS 로 하나씩 확인하고 그다음에 두개씩 확인하는 방식으로 해야겠다.
 */

import java.util.*;

class Solution {
	private static int column;
	private static boolean[] used;
	private static int answer = 0;

	public int solution(String[][] relation) {
		// init
		this.column = relation[0].length;
		this.used = new boolean[this.column];

		// boolean re = isKey(relation, Arrays.asList(1, 3));
		// print("" + re);
		dfs(relation, new ArrayList<>(), 0);

		return this.answer;
	}

	private void dfs(String[][] relation, List<Integer> candidates, int start) {

		if (isKey(relation, candidates)) {
			print("answe! " + candidates.toString());
			// candidates.remove(candidates.size() - 1);
			answer++;
			return ;
		}

		for (int i = start; i < column; i++) {
			if (!used[i]) {
				candidates.add(i);
				print("add " + i + " " + candidates.toString());
				dfs(relation, candidates, i + 1);
				candidates.remove(candidates.size() - 1);
				print("remove " + i + " " + candidates.toString());
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

	private void print(String s) {
		System.out.println(s);
	}
}