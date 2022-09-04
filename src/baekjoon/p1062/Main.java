package baekjoon.p1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static List<Character> learn = new ArrayList<>(30);
	public static List<Character> candidate = new ArrayList<>(25);
	public static List<String> words = new ArrayList<>(55);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int N = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());

		// a n t i c
		learn.add('a');
		learn.add('n');
		learn.add('t');
		learn.add('i');
		learn.add('c');

		if (K < 5){
			System.out.println(0);
			return;
		}

		// add to array
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if (word.length() <= 8)
				continue;
			word = word.substring(4, word.length()- 4);
//			System.out.println("word = " + word);

			// add candidate character
			for (int j = 0; j < word.length(); j++) {
				char wordCharacter = word.charAt(j);
				if (candidate.contains(wordCharacter))
					continue;
				candidate.add(wordCharacter);
//				System.out.println("wordCharacter = " + wordCharacter);
			}

			// add substring word
			words.add(word);
		}

		Combination com = new Combination(candidate.size(), K - 5);
		com.combinationWithOp(0, 0);
		System.out.println(com.maxCount);
	}
	static class Combination{
		int n;
		int r;
		int[] result;
		int maxCount = 0;

		public Combination(int n, int r) {
			this.n = n;
			this.r = r;
			result = new int[r];
		}

		public void combinationWithOp(int cnt, int idx){
			if (cnt == r){
				// picked random idx
				for (int i : result){
					Character newChar = candidate.get(i);
					learn.add(newChar);
				}
				int matchCount = 0;
				for(String word : words){
					if (matchCk(word))
						matchCount++;
				}
				maxCount = Math.max(maxCount, matchCount);
				for (int i : result){
					Character newChar = candidate.get(i);
					learn.remove(newChar);
				}
				return;
			}

			for (int i = idx; i < n; i++) {
				result[cnt] = i;
				combinationWithOp(cnt + 1, idx + 1);
			}
		}
	}

	private static boolean matchCk(String word) {
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!learn.contains(c))
				return false;
		}
		return true;
	}
}

