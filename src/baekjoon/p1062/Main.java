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
		int size = 0;

		HashSet<Character> word = new HashSet<>(); // a n t i c
		HashSet<Character> newWord = new HashSet<>(); // 새롭게 추가되는 단어들
		LinkedList<String> strs = new LinkedList<>(); // 입력받은 문자열들

		String def = "antatica";
		size = wordToSet(word, def);
		if (K < size){
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
				if (!word.contains(subStr.charAt(j)))
					newWord.add(subStr.charAt(j));
			}
		}

		// combination
		ArrayList<Character> subWordsList = new ArrayList<Character>(newWord);
		int cnt = subWordsList.size();
		int result = 0;
		Combination com = new Combination(cnt, K - 5); // antatica 가 이미 5개여서
		for (int[] c : com.result){
			char [] pickedWord = new char[K - 5];
			for (int i = 0; i < K - 5; i++) {
				pickedWord[i] = subWordsList.get(c[i]);
			}
			result = Math.max(result, pickResult(word, pickedWord, strs));
		}
		System.out.println(result);
	}

	private static int wordToSet(HashSet word, String str){
		for (int i = 0; i < str.length(); i++) {
			word.add(str.charAt(i));
		}
		return word.size();
	}

	private static boolean includeCk(HashSet word, String str){
		for (int i = 0; i < str.length(); i++) {
			if (!word.contains(str.charAt(i))){
				return false;
			}
		}
		return true;
	}

	private static int pickResult(HashSet<Character> word, char[] pick, LinkedList<String> strs){
		HashSet<Character> tmp = (HashSet<Character>)word.clone();
		int result = 0;
		for (char c : pick){
			tmp.add(c);
		}
		for (int i = 0; i < strs.size(); i++) {
			String s = strs.get(i);
			if (includeCk(tmp, s))
				result++;
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
