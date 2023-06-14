package programmers.level2.p1835;

import java.util.*;

class Solution {

	private List<String> list = new ArrayList<>();
	private String[] data;
	private int N;

	public int solution(int n, String[] data) {
		this.N = n;
		this.data = data;
		initList();
		return (int)list.stream().filter(v -> isValid(v)).count();
	}

	private void initList() {
		String[] people = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
		boolean[] visited = new boolean[people.length];
		dfs(people, 0, visited, "");
	}

	private void dfs(String[] people, int level, boolean[] visited, String cur) {
		if (level == 8) {
			list.add(cur);
			return;
		}
		for (int i = 0 ; i < 8; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(people, level + 1, visited, cur + people[i]);
				visited[i] = false;
			}
		}
	}


	private boolean isValid(String cur) {
		boolean result = true;
		for (int i = 0; i < N; i++) {
			String cond = data[i];
			int distance = getDistance(cur, cond.charAt(0), cond.charAt(2));
			int target = Integer.parseInt(String.valueOf(cond.charAt(4)));

			if (cond.charAt(3) == '=') result &= distance == target;
			else if (cond.charAt(3) == '>') result &= distance > target;
			else if (cond.charAt(3) == '<') result &= distance < target;

			if (!result) return false;
		}
		return result;
	}

	private int getDistance(String cur, char a, char b) {
		return Math.abs(cur.indexOf(a) - cur.indexOf(b)) - 1;
	}
}