package thisIsCodingTest.q_03;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q_03 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String  s = br.readLine();
		char    c;
		char    now;
		int     result;
		boolean flag = (s.charAt(0) == '0') ? false : true;

		result = 0;
		for (int i = 1 ; i < s.length(); i++){
			c = s.charAt(i);
			if (s.charAt(i - 1) != c) {
				if (!flag) {
					if (c == '1')
						result++;
				} else {
					if (c == '0')
						result++;
				}
			}
		}
		System.out.println(result);
	}
}
