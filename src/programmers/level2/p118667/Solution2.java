package programmers.level2.p118667;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution2 {
	import java.util.*;

	class Solution {
		private int[] q1;
		private int[] q2;
		private int target, start, end, tmp, q1Size, q2Size;

		public int solution(int[] queue1, int[] queue2) {
			int answer = 0;
			q1 = queue1;
			q2 = queue2;
			q1Size = q1.length;
			q2Size = q2.length;
			end = q1Size;
			target += Arrays.stream(queue1).reduce(0, (a, b) -> a + b);
			target += Arrays.stream(queue2).reduce(0, (a, b) -> a + b);
			if (target % 2 == 1)
				return -1;
			target /= 2;
			while (true){
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
				// start end 가 인덱스를 초기화 하는 경우에 대한 처리가 필요
			}

			return answer;
		}

		private int sumArr(int start, int end){
			int result = 0;

		}
	}

}
