package programmers.level1.p64061;

import java.util.Stack;

class Solution {
	private int[][] board;
	private int n;
	private final Stack<Integer> basket = new Stack<>();
	private int answer = 0;

	/***
	 * 스택에서 인형을 넣기전에 삭제할거면 삭제하고 넣는 함수
	 */
	void pick(int move){
		int doll = 0;
		int c = move - 1; // columns

		// 인형 꺼내기
		for (int i=0; i<n; i++){
			doll = board[i][c];
			if (doll != 0){
				board[i][c] = 0;
				break;
			}
		}
		if (doll == 0)
			return ;

		// 인형 넣기
		if (!basket.isEmpty() && basket.peek() == doll){
			basket.pop();
			answer+= 2;
		} else {
			basket.push(doll);
		}
	};




	public int solution(int[][] board, int[] moves) {
		this.board = board;
		n = board.length;
		for (int move : moves) {
			pick(move);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] ints = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] ints1 = {1, 5, 3, 5, 1, 2, 1, 4};
		solution.solution(ints, ints1);
	}
}