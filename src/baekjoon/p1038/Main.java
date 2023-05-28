package baekjoon.p1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	private static int[][] dp = new int[11][10];
	private static int sum = -1; // 한자리 0 은 카운트 되면 안되기 때문
	private static int level = 1;
	private static int digit = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());


		op();

		if (sum < N) {
			System.out.println(-1);
			return;
		}

//		System.out.println("level = " + level);
//		System.out.println("sum = " + sum);
//		System.out.println("digit = " + digit);
		getResult();
	}

	private static void op() {
		while (level <= 10) {
			for (digit = level - 1; digit < 10; digit++) {
				if (level == 1) {
					dp[level][digit] = 1;
				} else {
					dp[level][digit] = getArrSum(digit, level - 1);
				}
				sum += dp[level][digit];
				if (sum >= N) return;
			}
			level++;
		}
	}

	private static int getArrSum(int i, int level) {
		int result = 0;
		for (int j = 0; j < i; j++) {
			result += dp[level][j];
		}
		return result;
	}

	private static void getResult() {
		StringBuilder numStr = new StringBuilder();

		for (int i = 0; i < level; i++) {
			numStr.append(digit - i);
		}

		int tmpLevel = level - 1;
		int tmpDigit = digit - 1;

		if (sum == N) {
			System.out.println(numStr);
			return;
		}

		while (true) {
			if (sum - dp[tmpLevel][tmpDigit] > N) {
				sum -= dp[tmpLevel][tmpDigit];
				tmpDigit--;
				numStr.replace(numStr.length() -
						tmpLevel, numStr.length() - tmpLevel + 1, String.valueOf(tmpDigit));
				continue;
			}
			if (sum - dp[tmpLevel][tmpDigit] == N) {
				for (int i = tmpLevel; i >= 1; i--) {
					tmpDigit--;
					numStr.replace(numStr.length() -
							i, numStr.length() - i + 1, String.valueOf(tmpDigit));
				}
				System.out.println(numStr);
				return ;
			}
			tmpDigit--;
			tmpLevel--;
			numStr.replace(numStr.length() -
					tmpLevel, numStr.length() - tmpLevel + 1, String.valueOf(tmpDigit));
		}
	}
}
