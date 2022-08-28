package programmers.level2.p118667;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution2 {
	/** 원형 리스트를 사용해서 해보려고 했는데 생각해보니까 최소 횟수를 찾기는 어려울듯??
	 */
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		int target = 0;
		int size = 0;
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

		for (int i = 0; i < size; i++) {
			int     tmp = 0;
			boolean flag = false;
			for (int j = 0; j < size; j++) {
				int idx = i + j;
				if (idx >= size)
					idx -= size;

				tmp += arr.get(idx);
				if (tmp == target){
					flag = true;
				}

			}
		}



		return answer;
	}

}
