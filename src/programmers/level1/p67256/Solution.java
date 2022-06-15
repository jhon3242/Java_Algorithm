package programmers.level1.p67256;

import java.util.ArrayList;

class Solution {
	int[][] pad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -2}};
	int lx = 3, ly = 0;
	int rx = 3, ry = 2;
	String hand;
	String answer;
	ArrayList<Integer> left_num = new ArrayList<>();
	ArrayList<Integer> right_num = new ArrayList<>();

	public String solution(int[] numbers, String hand) {
		answer = "";
		this.hand = hand;
		left_num.add(1);
		left_num.add(4);
		left_num.add(7);
		right_num.add(3);
		right_num.add(6);
		right_num.add(9);

		for (int num : numbers) {
			dis(num);
		}
		return answer;
	}

	private void dis(int target) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (pad[i][j] == target) {
					if (left_num.contains(target)){
						answer+="L";
						lx = i;
						ly = j;
					}
					else if (right_num.contains(target)){
						answer+="R";
						rx = i;
						ry = j;
					}
					else{
						int ldis = Math.abs(lx - i) + Math.abs(ly - j);
						int rdis = Math.abs(rx - i) + Math.abs(ry - j);
						if (hand.equals("left")) {
							if (ldis <= rdis) {
								lx = i;
								ly = j;
								answer += "L";
							} else {
								rx = i;
								ry = j;
								answer += "R";
							}
						} else {
							if (ldis < rdis) {
								lx = i;
								ly = j;
								answer += "L";
							} else {
								rx = i;
								ry = j;
								answer += "R";
							}
						}
					}

				}
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] ints = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		System.out.println(solution.solution(ints, "right"));
	}
}
