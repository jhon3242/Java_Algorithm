package programmers.level2.p150368;

import java.util.*;

class Solution {
	private static int[][] users;
	private static int[] result = new int[2];

	public int[] solution(int[][] users, int[] emoticons) {
		this.users = users;
		dfs(0, emoticons, new ArrayList<Integer>());
		return this.result;
	}

	private void updateMax(int[] emoticons, List<Integer> disArr) {
		int[] result = new int[] {0, 0};
		for (int i = 0; i < users.length; i++) {
			int[] userInfo = users[i];
			int tmpCose = 0;
			for (int j = 0; j < emoticons.length; j++) {
				if (disArr.get(j) >= userInfo[0]) {
					tmpCose += emoticons[j] * (100 - disArr.get(j)) / 100;
					// System.out.println(i + "번 유저 " + j + "번 이모티콘 구매 ");
					if (tmpCose >= userInfo[1]) {
						result[0]++;
						tmpCose = 0;
						break;
					}
				}
			}
			result[1] += tmpCose;
		}
		// System.out.println(disArr);
		// System.out.println(Arrays.toString(result) + "\n");
		if (result[0] > this.result[0] || (result[0] == this.result[0] && result[1] > this.result[1])) {
			this.result = result;
			// System.out.println(Arrays.toString(this.result));
		}
	}

	private void dfs(int level, int[] emoticons, List<Integer> disArr) {
		int[] discount = new int[] {10, 20, 30, 40};

		if (level == emoticons.length) {
			// System.out.println(disArr);
			updateMax(emoticons, disArr);
			return ;
		}

		for (int dis : discount) {
			disArr.add(dis);
			dfs(level + 1, emoticons, disArr);
			disArr.remove(disArr.size() - 1);
		}
	}
}
