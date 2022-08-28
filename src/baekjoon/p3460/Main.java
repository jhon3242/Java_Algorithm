package baekjoon.p3460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int n;
		int T;
		String bits;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			bits = Integer.toBinaryString(n);

			for (int i = bits.length() - 1; i >= 0 ; i--) {
				if (bits.charAt(i) == '1'){
					System.out.print(bits.length() - 1 - i);
					System.out.print(' ');
				}
			}
		}

	}
}
