package baekjoon.p2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static int N;
	private static List<Integer> primes = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);

		for (int i = 2; i <= N; i++) {
			List<Integer> newPrime = new ArrayList<>();
			for (Integer prime : primes) {
				int cur = prime * 10;
				for (int j = 1; j <= 9; j++) {
					if (isPrime(cur + j)){
						newPrime.add(cur + j);
					}
				}
			}
			primes = newPrime;
		}
		for (Integer prime : primes) {
			System.out.println(prime);
		}

	}

	private static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}
