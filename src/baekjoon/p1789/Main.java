package baekjoon.p1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long n = 1;
		while (S >= sumN(n)){
			n++;
		}
		System.out.println(n - 1);
	}

	public static long sumN(long n){
		return (n * (n + 1)) / 2;
	}
}
