package thisIsCodingTest.q_07;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_07 {
	private static int op(String str){
		int result = 0;

		for (int i = 0; i<str.length(); i++){
			result += (int)(str.charAt(i));
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder(br.readLine());
		int pivot = (int)(input.length() / 2);


		if (op(input.substring(0, pivot)) == op(input.substring(pivot)))
			System.out.println("LUCKY");
		else
			System.out.println("READY");
	}
}
