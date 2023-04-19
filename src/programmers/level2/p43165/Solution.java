package programmers.level2.p43165;

class Solution {
	private static int[] numbers;
	private static int answer = 0;
	private static int target;

	private void dfs(int level, int sum) {
		// System.out.println("sum " + sum + " level " + level);
		if (level == numbers.length) {
			if (sum == target) answer++;
			return ;
		}
		dfs(level + 1, sum + numbers[level]);
		dfs(level + 1, sum - numbers[level]);
	}

	public int solution(int[] numbers, int target) {
		this.numbers = numbers;
		this.target = target;

		dfs(0, 0);

		return this.answer;
	}
}
