package programmers.level2.p150368;

import java.util.*;

/**
 System.out.println("x = " + x);
 */
class Solution {
	private int[][] users;
	private int[] emoticons;
	private int N;
	private int[] result = new int[]{-1, -1};


	public int[] solution(int[][] users, int[] emoticons) {
		N = emoticons.length;
		this.users = users;
		this.emoticons = emoticons;

		// resultCheck();
		dfs(0, new ArrayList<>());
		return result;
	}

	private void dfs(int level, List<Integer> sales) {

		if (level == N) {
			// System.out.println("sales = " + sales);
			resultCheck(sales);
			return;
		}

		for (int i = 10 ; i <= 40; i += 10) {
			sales.add(i);
			dfs(level + 1, sales);
			sales.remove(sales.size() - 1);
		}
	}

	private void resultCheck(List<Integer> sales) {
		int[] result = new int[]{0, 0};

		for (int[] user : users) {
			int totalCost = 0;
			for (int i = 0 ; i < N; i++){
				int sale = sales.get(i);

				// 구매하는 경우
				if (user[0] <= sale) {
					totalCost += emoticons[i] * (100.0 - sale) / 100;
				}

				// 멤버십 가입
				if (totalCost >= user[1]) {
					totalCost = 0;
					result[0] += 1;
					break;
				}
			}
			result[1] += totalCost;
		}


		if (this.result[0] < result[0] ||
				(this.result[0] == result[0] && this.result[1] < result[1])) {
			this.result = result;
		}
	}
}
