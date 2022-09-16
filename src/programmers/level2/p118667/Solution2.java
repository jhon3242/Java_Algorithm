package programmers.level2.p118667;

import java.util.*;
import java.util.stream.Stream;

class Solution {
	private int[] q1;
	private int[] q2;
	private int[] concat;
	private int start, end, q1Size, q2Size;
	private long target, tmp;

	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		q1 = queue1;
		q2 = queue2;
		q1Size = q1.length;
		q2Size = q2.length;
		concat = new int[q1Size + q2Size];
		for (int i = 0; i < q1Size; i++) {
			concat[i] = queue1[i];
		}
		for (int i = 0; i < q2Size; i++) {
			concat[i + q1Size] = queue2[i];
		}
		end = q1Size;
		target = Arrays.stream(concat).reduce(0, (a, b) -> a + b);
		if (target % 2 == 1)
			return -1;

		target /= 2;

		while (answer < q1Size * 3){
			tmp = sumArr(start, end);
			if (tmp > target){
				start++;
				answer++;
			}
			else if (tmp < target){
				end++;
				answer++;
			}
			else{
				return answer;
			}
			if (start >= q1Size + q2Size){
				start -= q1Size + q2Size;
			}
			if (end >= q1Size + q2Size){
				end -= q1Size + q2Size;
			}
		}
		return -1;
	}

	private long sumArr(int start, int end){
		long result = 0;
		if (start < end){
			for (int i = start; i < end; i++) {
				result += concat[i];
			}
		}
		else{
			for (int i = start; i < concat.length; i++) {
				result += concat[i];
			}
			for (int i = 0; i < end; i++) {
				result += concat[i];
			}
		}
		return result;
	}
}

public class Solution2 {

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] q1 = {3, 2, 7, 2};
//		int[] q2 = {4, 6, 5, 1};

//		int[] q1 = {1, 2, 1, 2};
//		int[] q2 = {1, 10, 1, 2};

		int[] q1 = {1, 5};
		int[] q2 = {1, 1};

		int solution1 = solution.solution(q1, q2);
		System.out.println("solution1 = " + solution1);
	}
}
