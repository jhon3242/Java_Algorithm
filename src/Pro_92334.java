import programmers.level2.p118667.Solution2;

import java.util.*;
public class Pro_92334 {


	public static void main(String[] args) {

		int[] q1 = {3, 2, 7, 2};
		ArrayList<Integer> arrList = new ArrayList<>();

		arrList.add(3);
		arrList.add(2);
		arrList.add(7);
		arrList.add(2);

		int i = arrList.indexOf(7);
		System.out.println(i);
		int asInt = Arrays.stream(q1).max().getAsInt(); // 7
	}


}
