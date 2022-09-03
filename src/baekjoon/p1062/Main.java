package baekjoon.p1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int N = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());

//		HashSet<Character> word = new HashSet<>(); // a n t i c
		boolean[] word = new boolean[26];
		ArrayList<Character> newWord = new ArrayList<>(); // 새롭게 추가될 후보 단어들
		ArrayList<String> strs = new ArrayList<>(); // 입력받은 문자열들

		String def = "antatica";
		for (int i = 0; i < def.length(); i++) {
			word[(byte)def.charAt(i) - 'a'] = true;
		}

		if (K < 5){ // a n t i c
			System.out.println(0);
			return;
		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String subStr = str.substring(4, str.length() - 4);
			strs.add(str);
			// contain check
			if (subStr.length() == 0 || includeCk(word, subStr))
				continue;

			// add to newWord
			for (int j = 0; j < subStr.length(); j++) {
				if (!word[(byte)subStr.charAt(j) - 'a'] && !newWord.contains(subStr.charAt(j))) {
					newWord.add(subStr.charAt(j));
				}
			}
		}

		// combination
		int cnt = newWord.size();
		int result = 0;
		Combination com = new Combination(cnt, K - 5); // anta tica 가 이미 5개여서
		for (int[] c : com.result){
			char [] pickedWord = new char[K - 5];
			for (int i = 0; i < K - 5; i++) {
				pickedWord[i] = newWord.get(c[i]);
			}
			result = Math.max(result, pickResult(word, pickedWord, strs));
		}
		System.out.println(result);
	}

	private static int wordToSet(HashSet<Character> word, String str){
		for (int i = 0; i < str.length(); i++) {
			word.add(str.charAt(i));
		}
		return word.size();
	}

	private static boolean includeCk(boolean[] word, String str){
		for (int i = 0; i < str.length(); i++) {
			if (!word[(byte)(str.charAt(i)) - 'a']){
				return false;
			}
		}
		return true;
	}

	private static int pickResult(boolean[] word, char[] pick, ArrayList<String> strs){
		int result = 0;
		for (char c : pick){
			word[c - 'a'] = true;
		}
		for (int i = 0; i < strs.size(); i++) {
			String s = strs.get(i);
			if (includeCk(word, s))
				result++;
		}
		for (char c : pick){
			word[c - 'a'] = false;
		}
		return result;
	}
}


class Combination {

	public int n;
	public int r;
	public int[] tmp;
	public LinkedList<int[]> result = new LinkedList<>();

	public Combination(int n, int r) {
		this.n = n;
		this.r = r;
		tmp = new int[r];
		combination(0, 0);
	}

	private void combination(int cnt, int idx){
		if (cnt == r){
			result.add(tmp.clone());
			return;
		}

		for (int i = idx; i < n; i++) {
			tmp[cnt] = i;
			combination(cnt + 1, idx + 1);
		}
	}
}
