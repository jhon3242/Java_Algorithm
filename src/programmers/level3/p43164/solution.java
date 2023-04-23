package programmers.level3.p43164;

/**
 * dfs 로 구현했고 경로를 문자열로 보내주고 마지막에 split 하는 방식으로
 * 간단하게 해결이 가능했다.
 */

import java.util.*;

class Solution {
	private static boolean[] visited;
	private static List<String> roots = new ArrayList<>();
	private static String[][] tickets;

	private static void dfs(String start, String root, int level) {
		if (level == tickets.length) {
			roots.add(root);
			return ;
		}

		for (int i = 0 ; i < tickets.length; i++) {
			if (tickets[i][0].equals(start) && !visited[i]) {
				visited[i] = true;
				dfs(tickets[i][1], root + " " + tickets[i][1], level + 1);
				visited[i] = false;
			}
		}
	}

	public String[] solution(String[][] tickets) {
		this.tickets = tickets;
		visited = new boolean[tickets.length];
		dfs("ICN", "ICN", 0);
		Collections.sort(roots);
		return roots.get(0).split(" ");
	}
}