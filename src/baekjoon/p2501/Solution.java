package baekjoon.p2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Integer n = Integer.parseInt(st.nextToken());
		Integer k =  Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			if (n % i == 0){
				k--;
			}
			if (k == 0){
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
