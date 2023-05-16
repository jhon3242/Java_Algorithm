package programmers.level2.p150369;

import java.util.*;

/**
 * 정답 확인
 *
 * 항상 최대값으로 배달을 가져가서 배달하고
 * 항상 최대값으로 픽업하는 것만 생각하면 되고 어디에 얼마나 배달할지에 대해선 중요하지 않는다는 것을
 * 깨달지 못해서 어렵게 접근한듯 하다.
 */
class Solution {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int del = -1;
		int pic = -1;
		int size = cap;

		for (int i = n - 1; i >=0 ; i--) {
			if (deliveries[i] != 0) {
				del = i;
				break;
			}
		}

		for (int i = n - 1; i >=0 ; i --) {
			if (pickups[i] != 0) {
				pic = i;
				break;
			}
		}

		// int i = 0;
		while (true) {
			if (del < 0 && pic < 0) break;
			// System.out.println("add " + Math.max(del + 1, pic + 1));
			answer += Math.max(del + 1, pic + 1) * 2;

			while (true) {
				// System.out.println("cap " + cap + " del " + del);
				if (del < 0  || cap == 0 && deliveries[del] != 0 ) break;
				int count = Math.min(cap, deliveries[del]);
				cap -= count;
				deliveries[del] -= count;

				if (deliveries[del] == 0) {
					del--;
				}
			}
			cap = size;

			while (true) {
				// System.out.println("cap " + cap + " del " + del);
				if (pic < 0  || cap == 0 && pickups[pic] != 0 ) break;
				int count = Math.min(cap, pickups[pic]);
				cap -= count;
				pickups[pic] -= count;

				if (pickups[pic] == 0) {
					pic--;
				}
			}

			// System.out.println("deliveries " + Arrays.toString(deliveries));
			// System.out.println("pickups " + Arrays.toString(pickups));
			// System.out.println();
			cap = size;
			// i++;
			// if (i > 3) break;
		}
		return answer;
	}
}
