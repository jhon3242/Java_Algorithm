package programmers.level3.p43163;

import java.util.*;

class Solution {
	// private static String now;
	private static int count = 0;
	private static int answer = Integer.MAX_VALUE;
	private static Boolean[] visited;

	private boolean canChange(String now, String target) {
		int diffCount = 0;
		for (int i = 0 ; i < target.length(); i++) {
			if (target.charAt(i) != now.charAt(i)) {
				diffCount++;
			}
		}
		return diffCount == 1;
	}

	private void dfs(String[] words, String now, String target, int level) {
		for (int i = 0 ; i < words.length; i++) {
			String word = words[i];
			// System.out.println(Arrays.toString(visited));
			if (!visited[i] && canChange(now, word)) {
				visited[i] = true;
				// System.out.println(Arrays.toString(visited) + " " + now +" to " + word);
				if (word.equals(target)) {
					// System.out.println("target count : " + (level + 1));
					answer = Math.min(answer, level);
					visited[i] = false;
					return ;
				}
				dfs(words, word, target, level + 1);
				visited[i] = false;
			}
		}
	}


	public int solution(String begin, String target, String[] words) {
		visited = new Boolean[words.length];

		for (int i = 0 ; i < visited.length; i++) {
			visited[i] = false;
		}

		// System.out.println("visited " + Arrays.toString(visited));
		dfs(words, begin, target, 1);

		return this.answer == Integer.MAX_VALUE ? 0 : this.answer;
	}
}