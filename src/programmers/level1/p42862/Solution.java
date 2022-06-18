package programmers.level1.p42862;
/*

2 4 / 1 3

2 5 / 1 3

 */


import java.util.Arrays;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		Arrays.stream(lost).sorted();
		Arrays.stream(reserve).sorted();

//		Arrays.asList(reserve).contains()
		int[] have = new int[n + 1];

		for (int i=0; i<n+1; i++){
			have[i] = 1;
		}

		for (int l : lost) {
			have[l] = 0;
			for (int i=0; i< reserve.length; i++){
				if (reserve[i] == l){
					answer++;
					have[l] = 1;
					reserve[i] = -1;
					break;
				}
			}
		}

		for (int r : reserve) {

			if (r > 0 && have[r - 1] == 0)
				have[r - 1] = 1;
			else if (r + 1 < have.length && have[r + 1] == 0)
				have[r + 1] = 1;
			else
				continue;
			answer++;
		}

		return answer;
	}
}
