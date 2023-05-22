package baekjoon.p1062;

/**
 * 2차 시도
 * 사용중인 문자를 list 로 넘겨주어 확인하는 방식으로 구현했는데
 * 1회차에서 그냥 int[] 로 문자 사용여부를 파악했던것 보다는 시간이
 * 많이 걸렸다. 1회차 방법이 더 빠르고 명확해 보인다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static List<String> words = new ArrayList<>();
	private static Set<Character> candidate = new HashSet<>();
	private static List<Character> candidateList;
	private static int maxValue = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		init(br, N);
		getResult(K);
		System.out.println(maxValue);
	}

	private static void init(BufferedReader br, int N) throws IOException {
		List<Character> has = Arrays.asList('a', 'n', 't', 'i', 'c');

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			String substring = word.substring(4, word.length() - 4);
			words.add(substring);

			substring.chars().forEach(v -> {
				if (!has.contains((char)v)) {
					candidate.add((char)v);
				}
			});
		}
	}

	private static void getResult(int K) {
		if (K < 5) return;
		candidateList = new ArrayList<>(candidate);
		dfs(0, K - 5, new ArrayList<>());
	}

	private static void dfs(int start, int count, List<Character> list) {
		if (list.size() >= count || list.size() == candidateList.size()) {
			updateResult(list);
			return;
		}

		for (int i = start; i < candidateList.size(); i++) {
			list.add(candidateList.get(i));
			dfs(i + 1, count, list);
			list.remove(list.size() - 1);
		}
	}

	private static void updateResult(List<Character> list) {
		List<Character> canUse = new ArrayList<>();
		canUse.addAll(list);
		canUse.addAll(Arrays.asList('a', 'n', 't', 'i', 'c'));

		int count = (int) words.stream().filter(word -> {
			char[] charArray = word.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (!canUse.contains(charArray[i])) return false;
			}
			return true;
		}).count();
		maxValue = Math.max(maxValue, count);
	}
}



//
//public class Main {
//	public static boolean [] visited = new boolean[26];
//	public static ArrayList<String> words = new ArrayList<>(50);
//	public static int N;
//	public static int K;
//	public static int maxCount = 0;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		N = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(st.nextToken());
//
//		// a n t i c
//		visited['a' - 'a'] = true;
//		visited['n' - 'a'] = true;
//		visited['t' - 'a'] = true;
//		visited['i' - 'a'] = true;
//		visited['c' - 'a'] = true;
//
//		if (K < 5){
//			System.out.println(0);
//			return;
//		}
//		else if (K >= 26){
//			System.out.println(N);
//			return;
//		}
//		else{
//			for (int i = 0; i < N; i++) {
//				String word = br.readLine();
//				word = word.substring(4, word.length() - 4);
//				words.add(word);
//			}
//			bfs(0, 0);
//			System.out.println(maxCount);
//		}
//	}
//	public static void bfs(int start, int count){
//		if (count == K - 5){
//			int matchCount = 0;
//			for (int i = 0; i < words.size(); i++) {
//				String wd = words.get(i);
//				boolean flag = true;
//				for (int j = 0; j < wd.length(); j++) {
//					if (!visited[wd.charAt(j) - 'a']) {
//						flag = false;
//						break;
//					}
//				}
//				if (flag){
//					matchCount++;
//				}
//			}
//			maxCount = Math.max(maxCount, matchCount);
//		}
//
//		for (int i = start; i < 26; i++) {
//			if (!visited[i]){
//				visited[i] = true;
//				bfs(i, count + 1);
//				visited[i] = false;
//			}
//		}
//	}
//}

