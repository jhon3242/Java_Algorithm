package baekjoon.p12026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * BOOOOJOOOOOJBO
 * J 를 먼저 찾는다.
 *  없으면 가장 먼 O 를 찾는다.
 * 찾은 J 의 인덱스와 B 사이에 중간에서 가까운 O 를 찾는다
 */
public class Main {
	private static int N;
	private static char[] graph;
	private static int result = Integer.MAX_VALUE;
	private static Map<Character, Character> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = br.readLine().toCharArray();
		map.put('B', 'O');
		map.put('O', 'J');
		map.put('J', 'B');

		// 최대한 BOJ 를 많이 만드는게 제일 적게 가는 방법
		int totalBOJ = getTotalBOJCount();
		int bIdx = 0;
		int oIdx = 0;
		int jIdx = 0;

		while (totalBOJ > 0) {
			if (totalBOJ <= 3) {
				if (totalBOJ == 1) {
					bIdx = findChar(jIdx, 'B');
					// not valid
					if (bIdx != graph.length - 1) {
						System.out.println(-1);
						return;
					}
					result += Math.pow(oIdx - bIdx, 2);
				}
				if (totalBOJ == 2) {

				}

				break;
			}

			bIdx = findChar(jIdx, 'B');
			jIdx = findChar(bIdx, 'J');
			oIdx = findO(bIdx, jIdx);
			result += Math.pow(oIdx - bIdx, 2);
			result += Math.pow(jIdx - oIdx, 2);
			totalBOJ -= 3;
		}



//		if (result == Integer.MAX_VALUE) System.out.println(-1);
//		else System.out.println(result);

	}

	private static int getTotalBOJCount() {
		int result = 0;
		char target = 'B';
		for (int i = 0; i < graph.length; i++) {
			if (graph[i] == target) {
				target = map.get(target);
				result++;
			}
		}
		return result;
	}

	// 사이에 무조건 O 가 있다고 가정
	private static int findO(int b, int j) {

		int midL = (b + j) / 2;
		int midR = ((b + j)) / 2 + 1;

		while (b < j) {
			if (graph[midL] == 'O') return midL;
			if (graph[midR] == 'O') return midR;
			midL--;
			midR++;
		}
		return -1;
	}

	private static int findChar(int start, char chr) {
		for (int i = start; i < graph.length ; i++) {
			if (graph[i] == chr) return i;
		}
		return -1;
	}



}
