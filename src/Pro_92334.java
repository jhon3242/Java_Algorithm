import programmers.level2.p118667.Solution2;
import x_lib.combination.Combination;

import java.io.*;

public class Pro_92334 {

	static int[] arr = new int[10];
	static int target = 5;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		recursion(0, 10);
	}

	static void recursion(int st, int ed){
		if (arr[st] == target){
			System.out.println(target + "의 위치 : " + st);
			return;
		}
		int mid = (st + ed) / 2;
		if (target >= arr[mid])
			recursion(mid, ed);
		else
			recursion(st, mid);
	}
}
