package x_lib.backDiff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	private static int[] getRandomIntArr(int size, int[] range) {
		Random random = new Random();
		return random.ints(size, range[0], range[1] + 1).toArray();
	}

	private static int getRandomNum(int[] range) {
		return (int) (Math.random() * (range[1] - range[0] + 1)) + range[0];
	}

	public static void main(String[] args) throws IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 100; i++) {
			My my = new My();
			my.main(i);
		}

//		for (int i = 0; i < 10; i++) {
//			int N = getRandomNum(new int[]{10, 11});
//			int S = getRandomNum(new int[]{45, 45});
//
//			int[] arr = getRandomIntArr(N, new int[]{1, 10});
//
//			int my = My.op(N, S, arr);
//			int an = An.op(N, S, arr);
//			if (my != an) {
//				System.out.println(Arrays.toString(arr));
//				System.out.println("S = " + S);
//				System.out.println("my = " + my + " an = " + an);
//			}
//		}

	}
}


class My {
	private int N;
	private int[][] dp = new int[11][10];
	private int sum = -1; // 한자리 0 은 카운트 되면 안되기 때문
	private int level = 1;
	private int digit = 0;

	public void main(int n) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = n;


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

	private void op() {
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

	private int getArrSum(int i, int level) {
		int result = 0;
		for (int j = 0; j < i; j++) {
			result += dp[level][j];
		}
		return result;
	}

	private void getResult() {
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

class An {
	private static int minCount;

	public static int op(int N, int S, int[] array) {
		minCount = N + 1;


		// exception ck
		if (sumArr(array) < S){
			return 0;
		}

		int start = 0;
		int end = 1;
		int sumTmp = array[start];

		while (start < end && end <= N){
			if (sumTmp >= S){
				minCount = Math.min(minCount, end - start);
				sumTmp -= array[start];
				start++;
			}
			else{
				if (end < N){
					sumTmp += array[end];
				}
				end++;
			}
		}
		return minCount;
	}

	private static int sumArr(int[] array) {
		int tmp;

		tmp = 0;
		for (int i = 0; i < array.length; i++) {
			tmp += array[i];
		}
		return tmp;
	}
}