package programmers.level2.p150369;

import java.util.*;

class Solution {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int dI = -1;
		int pI = -1;
		int curCap;
		int removeCount = 0;

		for (int i = n - 1 ; i >= 0 ; i--) {
			if (deliveries[i] > 0) {
				dI = i;
				break;
			}
		}

		for (int i = n - 1 ; i >= 0 ; i--) {
			if (pickups[i] > 0) {
				pI = i;
				break;
			}
		}

		while (true) {
			curCap = cap;
			if (pI < 0 && dI < 0) break;
			answer += Math.max(pI + 1, dI + 1) * 2;
			// while (dI >= 0) {
			//     if (deliveries[dI] > 0) {
			//         if (curCap == 0) break;
			//         removeCount = Math.min(curCap, deliveries[dI]);
			//         curCap -= removeCount;
			//         deliveries[dI] -= removeCount;
			//         continue;
			//     }
			//     dI--;
			// }
			while (true) {
				if (dI < 0 || curCap == 0 && deliveries[dI] != 0) break;
				removeCount = Math.min(curCap, deliveries[dI]);
				curCap -= removeCount;
				deliveries[dI] -= removeCount;
				if (deliveries[dI] == 0) {
					dI--;
				}
			}
			curCap = cap;

			while (true) {
				if (pI < 0 || (curCap == 0 && pickups[pI] != 0)) break;
				removeCount = Math.min(curCap, pickups[pI]);
				curCap -= removeCount;
				pickups[pI] -= removeCount;
				if (pickups[pI] == 0) {
					pI--;
				}
			}

		}
		return answer;
	}
}