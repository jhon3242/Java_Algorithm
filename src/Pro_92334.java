import programmers.level2.p118667.Solution2;
import x_lib.combination.Combination;

import java.util.*;

public class Pro_92334 {


	public static void main(String[] args) {

		int[] q1 = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] slice = Arrays.copyOfRange(q1, 1, 4); // {2, 3, 4}
		for (int i = 0; i < slice.length; i++) {
			System.out.println(slice[i]);
		}
//		int sum = Arrays.stream(ints).sum();
//		System.out.println(sum);
	}
}
