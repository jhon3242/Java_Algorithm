import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import programmers.level1.p72410.*;


public class Pro_92334 {

	static HashMap<String, Integer> store = new HashMap<>();

	public static void main(String[] args) {
		boolean[] tmp = {true, true, false};
		int[] tmp2 = {1, 2, 3, 4, 5};

		boolean b = Arrays.stream(tmp2).anyMatch(i -> i == 2);
		System.out.println(b);
//		System.out.println(tmp.);
	}
}
