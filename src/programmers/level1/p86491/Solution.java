package programmers.level1.p86491;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class Solution {
	public int solution(int[][] sizes) {
		int answer = 0;
		ArrayList<Integer> b =new ArrayList<>();
		ArrayList<Integer> s =new ArrayList<>();
		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i][0] < sizes[i][1]){
				b.add(sizes[i][1]);
				s.add(sizes[i][0]);
			}
			else{
				b.add(sizes[i][0]);
				s.add(sizes[i][1]);
			}

		}

		return Collections.max(b) * Collections.max(s);
	}
}