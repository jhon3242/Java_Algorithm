package programmers.level2.p118667;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution2 {
	/** 원형 리스트를 사용해서 해보려고 했는데 생각해보니까 최소 횟수를 찾기는 어려울듯??
	 *  그러면 모든 경우의 수를 배열에 넣고 각각의 값을 구한 뒤에 최소 횟수를 찾으면 되는거 아닌가?
	 */
	private int[] queue1;
	private int[] queue2;
	public int solution(int[] queue1, int[] queue2) {
		int target = 0;
		int size = 0;
		this.queue1 = queue1;
		this.queue2 = queue2;

		ArrayList<Integer> arr = new ArrayList<>();

		for(int i = 0; i < queue1.length; i++){
			arr.add(queue1[i]);
			target += queue1[i];
		}

		for(int i = 0; i < queue2.length; i++){
			arr.add(queue2[i]);
			target += queue2[i];
		}


		target /= 2;
		size = arr.size();
		return getCandidate(target, size, arr);
	}

	private int getMoveCount(int i, int count){
		int len = queue1.length;
		int result = 0;
		if (i >= len){
			i -= len;
		}
		if (i + count < len){
			result += i + count;
			result += i + len;
		}
		else{
			if (i > 0){
				result += i;
			}
			result += i + count - len;
		}

		return result;
	}

	private int getCandidate(int target, int size, ArrayList<Integer> arr) {
		int i = 0;
		int min = Integer.MAX_VALUE;
		while (i < size){
			int j = i;
			int count = 1;
			int sum = 0;
			while (count < size){
				sum += arr.get(j);
				if (sum == target){
					int moveCount = getMoveCount(i, count);
					min = Math.min(min, moveCount);
					break;
				}
				else if (sum > target){
					break;
				}
				j++;
				count++;
				if (j == size){
					j = 0;
				}
			}

			i++;
		}
		if (min == Integer.MAX_VALUE){
			return -1;
		}
		return min;
	}

}
