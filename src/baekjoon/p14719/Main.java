package baekjoon.p14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2차 시도
 * 간단하게 왼쪽, 오른쪽 인덱스를 구하고
 * 인덱스 안쪽 고인물을 더하는 방식으로 구했다.
 */
class Main {
	private static int[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		graph = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int left = 0;
		int right = 0;
		int result = 0;

		while (right < graph.length - 1) {
			right = getRightIdx(left);
			result += getWater(left, right);
			left = right;
		}
		System.out.println(result);

	}

	private static int getRightIdx(int start) {
		int result = graph.length - 1;
		int maxSize = 0;
		for (int i = start + 1; i < graph.length; i++) {
			if (graph[i] >= maxSize) {
				maxSize = graph[i];
				result = i;
			}
			if (graph[i] >= graph[start]) break;
		}
		return result;
	}

	private static int getWater(int left, int right) {
		int standard = Math.min(graph[left], graph[right]);
		int result = 0;

		for (int i = left + 1; i < right; i++) {
			result += standard - graph[i];
		}
		return result;
	}
}


/**
 * 1차 시도
 * 성공
 */
//public class Main {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		ArrayList<Integer> candidate = new ArrayList<>();
//
//		st = new StringTokenizer(br.readLine());
//		int x = Integer.parseInt(st.nextToken());
//		int y = Integer.parseInt(st.nextToken());
//		String[] splited = br.readLine().split(" ");
//		int[] arr = Arrays.stream(splited).mapToInt(Integer::parseInt).toArray();
//
//		// add candidate
//		addCandidate(candidate, arr);
//
//		// filter candidate
//		filterCandidate(candidate, arr);
//
////		candidate.forEach(i -> System.out.print(i + " "));
//
//		if (candidate.size() < 2)
//			System.out.println(0);
//		else{
//			int i = 0;
//			int result = 0;
//			while (i < candidate.size() - 1){ // 기둥이 2개이면 1번 3개이면 2번 해야하기 때문
//				int leftIdx = candidate.get(i);
//				int rightIdx = candidate.get(i + 1);
//				int target = Math.min(arr[leftIdx], arr[rightIdx]);
////				System.out.println("target = " + target);
////				System.out.println("q = " + q);
////				System.out.println("p = " + p);
//				for (int j = leftIdx + 1; j < rightIdx; j++) {
//					if (arr[j] < target){
//						result += target - arr[j];
//					}
//					else
//						break;
//				}
//				i++;
//			}
//			System.out.println(result);
//		}
//	}
//
//	private static void filterCandidate(ArrayList<Integer> candidate, int[] arr) {
//		int canIdx = 0;
//		while (true){
//			int leftBlock = arr[candidate.get(canIdx)];
//			int rightMaxSize = -1;
////			System.out.println("canIdx = " + canIdx);
//			for (int i = canIdx + 1; i < candidate.size(); i++) {
//				rightMaxSize = Math.max(rightMaxSize, arr[candidate.get(i)]);
//			}
////			System.out.println("leftBlock = " + leftBlock);
////			System.out.println("rightMaxSize = " + rightMaxSize);
//			boolean flag = true;
//			for (int i = canIdx + 1; i < candidate.size(); i++) {
//				int blockSize = arr[candidate.get(i)];
////				System.out.println("blockSize = " + blockSize);
//				if (blockSize >= leftBlock || blockSize == rightMaxSize){
//					canIdx = i;
//					flag = false;
//					break;
//				}
//				else{
//					candidate.set(i, -1);
//				}
//			}
////			candidate.forEach(i -> System.out.print(i + " "));
//			if (flag)
//				break;
//		}
//		candidate.removeIf(i -> i == -1);
//	}
//
//	private static void addCandidate(ArrayList<Integer> candidate, int[] arr) {
//		int pastIdx = 0;
//		for (int i = 1; i < arr.length; i++) {
//			if (arr[pastIdx] > arr[i])
//				candidate.add(pastIdx);
//			else if (i == arr.length - 1)
//				candidate.add(i);
//			pastIdx = i;
//		}
//	}
//}

/*
TestCase

4 4
2 2 2 2
result : 0

4 4
1 2 3 4
result : 0

4 4
4 3 1 2
result : 1

4 8
4 1 2 3 2 2 4
result : 10

4 9
10 1 3 1 5 1 2 1 3
후보 0, 2, 4, 6, 8
result : 15

*
* */