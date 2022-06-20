package programmers.level1.p1845;

import java.util.HashSet;

class Solution {
	public int solution(int[] nums) {
		int answer = 0;
		int pickCt = nums.length / 2;
		HashSet<Integer> poketmon = new HashSet<>();
		for (int num : nums) {
			poketmon.add(num);
		}
		if (poketmon.size() > pickCt)
			return pickCt;
		else
			return poketmon.size();
	}
}