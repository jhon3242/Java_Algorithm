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

		for (int i = 0; i < 10; i++) {
			int N = getRandomNum(new int[]{10, 11});
			int S = getRandomNum(new int[]{45, 45});

			int[] arr = getRandomIntArr(N, new int[]{1, 10});

			int my = My.op(N, S, arr);
			int an = An.op(N, S, arr);
			if (my != an) {
				System.out.println(Arrays.toString(arr));
				System.out.println("S = " + S);
				System.out.println("my = " + my + " an = " + an);
			}
		}

	}
}


class My {
	public static int op(int N, int S, int[] arr) {
		int s = 0;
		int e = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;

		while (s < N) {
			if (sum >= S) {
				min = Math.min(e - s, min);
				sum -= arr[s++];
			} else if (e == N) {
				break;
			} else {
				sum += arr[e++];
			}
		}
		return min;
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