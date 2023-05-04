package programmers.level2.p17687;

class Solution {
	public String solution(int n, int t, int m, int p) {
		String answer = "";
		int num = 0;
		int myTurn = p;
		// int time = 0;
		// System.out.println(bits);
		while (answer.length() < t) {
			String bits = Integer.toString(num, n);
			// System.out.println("bits " + bits + " myTurn " + myTurn);
			for (int i = 0 ; i < bits.length(); i++) {
				if (myTurn == 1) {
					answer += bits.substring(i, i + 1);
					// System.out.println("answer " + answer);
					myTurn = m;
					continue;
				}
				myTurn--;
			}
			num++;
			// time++;
			// if (time == 5) break;
		}

		return answer.substring(0, t).toUpperCase();
	}

	// private void print()
}