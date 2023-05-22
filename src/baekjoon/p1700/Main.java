package baekjoon.p1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 2차 시도
 */
public class Main {
	private static int[] arr;
	private static List<Integer> consent = new ArrayList<>();
	private static int N;
	private static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int count = 0;

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < K; i++) {
			if (consent.contains(arr[i])) continue;
			if (consent.size() == N) {
				removeNum(i);
				count++;
			}
			consent.add(arr[i]);
//			System.out.println("add arr[i] = " + arr[i]);
//			System.out.println("consent = " + consent);
		}
		System.out.println(count);
	}

	private static void removeNum(int idx) {
		List<Integer> left = Arrays.stream(arr).boxed().collect(Collectors.toList()).subList(idx, arr.length);
		List<Integer> candidate = new ArrayList<>(consent);

		for (int i = 0; i < left.size(); i++) {
			Integer tmpNum = left.get(i);
			if (consent.contains(tmpNum)) {
				candidate.remove(tmpNum);
			}
			if (candidate.size() == 1) break;
		}
		Integer removeNum = candidate.get(0);
//		System.out.println("removeNum = " + removeNum);
		consent.remove(removeNum);
	}
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//
//public class Main {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		LinkedList<Integer> multiTap = new LinkedList<>();
//
//		final int N = Integer.parseInt(st.nextToken()); // tap size
//		final int K = Integer.parseInt(st.nextToken()); // use count
//		String[] splitString = br.readLine().split(" ");
//		ArrayList<Integer> numArr = new ArrayList<>();
//		int result = 0;
//
//		// init
//		for(String num : splitString){
//			int i = Integer.parseInt(num);
//			numArr.add(i);
//		}
//
//		for (int i = 0; i < numArr.size(); i++) {
//			Integer num = numArr.get(i);
//			if (multiTap.contains(num)) {
////				System.out.println("include num = " + num);
//				continue;
//			}
////			System.out.println("multiTap.size() = " + multiTap.size());
//			if (multiTap.size() >= N){ // 빼야하는 작업이 필요함
//
//				LinkedList<Integer> candidate = (LinkedList<Integer>)  multiTap.clone();
//				for (int j = i + 1; j < numArr.size(); j++) {
//					Integer nextNum = numArr.get(j);
//					if (multiTap.contains(nextNum)){
//						candidate.remove(nextNum);
//////						System.out.println("remove candidate nextNum = " + nextNum);
//						if (candidate.size() <= 1)
//							break;
//					}
//				}
////				System.out.println("candidate.size() = " + candidate.size());
//				Integer target;
//				if (candidate.size() > 0){
//					target = candidate.pop();
//				}
//				else{
//					target = multiTap.pop();
//				}
////				System.out.println("remove target = " + target);
//				multiTap.remove(target);
//				result++;
//			}
////			System.out.println("add num = " + num);
//			multiTap.add(num);
//		}
//
//		System.out.println(result);
//	}
//}

/**

3 10
1 2 3 4 4 5 2 1 1 4
result : 3

3 5
1 1 1 1 1
result : 0

1 10
1 2 3 4 5 6 7 1 2 3
result : 9

*/