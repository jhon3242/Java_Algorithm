package baekjoon.p1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 2회차 답 봤음

 -  앞자리 기준으로 정렬하고 반복문을 돌면서 뒷자리만 비교해도 되는데
    이 생각을 못해서 못푼듯
 */

public class Main {

	private static List<Integer[]> store;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			N =  Integer.parseInt(br.readLine());
			store = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				store.add( new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}

			Collections.sort(store, Comparator.comparingInt(a -> a[0]));

//			store.forEach(a -> System.out.println(Arrays.toString(a)));

			int answer = 1;
			int min = store.get(0)[1];
			for (int j = 1; j < store.size(); j++) {
//				System.out.println("min = " + min + " target " + store.get(j)[1]);
				if (min > store.get(j)[1]) {
//					System.out.println("min " + Arrays.toString(store.get(j)));
					answer++;
					min = store.get(j)[1];
				}
			}
			System.out.println(answer);
		}
	}


}
