package programmers.level2.p118667;

import java.util.*;

/**
 * stream 을 사용해 tmp 합을 구했었어서 fail 했었다.
 * tmp = (long)(Arrays.stream(queue1).sum());
 * 위와 같이 사용했었는데 시간초과가 아닌 fail 이 떴었다.
 */

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
			target += queue1[i];
			tmp += queue1[i];
		}
		for (int i = 0; i < q2Size; i++) {
			concat[i + q1Size] = queue2[i];
			target += queue2[i];
		}
		end = q1Size;
		if (target % 2 == 1)
			return -1;

		target /= 2;

		while (start != end && answer <= q1Size * 3){
			if (tmp > target){
				tmp -= concat[start % (q1Size + q2Size)];
				start++;
				answer++;
			}
			else if (tmp < target){
				tmp += concat[end % (q1Size + q2Size)];
				end++;
				answer++;
			}
			else{
				return answer;
			}
			start %= q1Size + q2Size;
			end %= q1Size + q2Size;
		}
		return -1;
	}
}