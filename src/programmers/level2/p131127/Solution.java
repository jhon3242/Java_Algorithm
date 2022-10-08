package programmers.level2.p131127;

import java.util.*;

class Solution {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		for (int i=0; i<discount.length; i++){
			Map<String, Integer> saleMap = getSaleMap(discount, i);
			if (allSaleCk(want, number, saleMap))
				answer++;
		}
		return answer;
	}

	private Map<String, Integer> getSaleMap(String[] discount, int start){
		Map<String, Integer> list = new HashMap<>();
		for (int i=start; i<Math.min(start+10, discount.length); i++){
			if (list.containsKey(discount[i])){
				list.put(discount[i], list.get(discount[i]) + 1);
			}
			else
				list.put(discount[i], 1);
		}
		return list;
	}

	private boolean allSaleCk(String[] want, int[] number, Map<String, Integer> list) {
		for (int j=0; j<number.length; j++){
			if (!list.containsKey(want[j]))
				return false;
			if (list.get(want[j]) < number[j])
				return false;
		}
		return true;
	}
}
