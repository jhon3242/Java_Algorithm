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

		boolean[] word = new boolean[26];
		ArrayList<Character> newWord = new ArrayList<>(26); // 새롭게 추가될 후보 단어들
		ArrayList<String> strs = new ArrayList<>(55); // 입력받은 문자열들

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

		int cnt = newWord.size();
		Combination com = new Combination(cnt, K - 5, newWord, word, strs); // anta tica 가 이미 5개여서
		System.out.println(com.maxCount);
	}


	private static boolean includeCk(boolean[] word, String str){
		for (int i = 0; i < str.length(); i++) {
			if (!word[(byte)(str.charAt(i)) - 'a']){
				return false;
			}
		}
		return true;
	}
}


class Combination {

	public int n;
	public int r;
	public int[] tmp;
	public ArrayList<Character> newWord;
	public boolean[] word;
	public ArrayList<String> strs;
	public int maxCount = 0;

	public Combination(int n, int r, ArrayList<Character> newWord, boolean[] word, ArrayList<String> strs) {
		this.n = n;
		this.r = r;
		tmp = new int[r];
		this.newWord = newWord;
		this.word = word;
		this.strs = strs;
		combination(0, 0);
	}

	private void combination(int cnt, int idx){
		if (cnt == r){
			// 해당 조합된 단어들로 확인
			for (int i : tmp){
				Character c = newWord.get(i);
				word[c - 'a'] = true;
			}

			// 문자열을 순회하면서 몇개가 맞는지 확인
			maxCount = Math.max(maxCount, matchCount());

			// 다시 초기값으로 돌리기
			for (int i : tmp){
				Character c = newWord.get(i);
				word[c - 'a'] = false;
			}
			return;
		}

		for (int i = idx; i < n; i++) {
			tmp[cnt] = i;
			combination(cnt + 1, idx + 1);
		}
	}

	private int matchCount() {
		int result = 0;
		for (int i = 0; i < this.strs.size(); i++) {
			String s = this.strs.get(i);
			if (includeCk(s))
				result++;
		}
		return result;
	}

	private boolean includeCk(String s) {
		for (int j = 0; j < s.length(); j++) {
			if (!this.word[s.charAt(j) - 'a'])
				return false;
		}
		return true;
	}
}
