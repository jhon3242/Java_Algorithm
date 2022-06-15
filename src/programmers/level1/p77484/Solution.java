package programmers.level1.p77484;

class Solution {
	static int nowMatch;
	static int[] numArr = new int[46];
	static int zero;

	private int rankCal(int n){
		if (n == 6)
			return 1;
		else if (n == 5)
			return 2;
		else if (n == 4)
			return 3;
		else if (n == 3)
			return 4;
		else if (n == 2)
			return 5;
		else
			return 6;
	}

	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = {0, 0};

		for (int win_num : win_nums) {
			numArr[win_num] = 1;
		}

		for (int lotto : lottos) {
			if (numArr[lotto] == 1)
				nowMatch++;
			else if (lotto == 0)
				zero++;
		}

		answer[0] = rankCal(nowMatch + zero);
		answer[1] = rankCal(nowMatch);

		return answer;
	}
}