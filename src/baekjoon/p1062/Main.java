package baekjoon.p1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static boolean [] visited = new boolean[26];
	public static ArrayList<String> words = new ArrayList<>(50);
	public static int N;
	public static int K;
	public static int maxCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// a n t i c
		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;

		if (K < 5){
			System.out.println(0);
			return;
		}
		else if (K >= 26){
			System.out.println(N);
			return;
		}
		else{
			for (int i = 0; i < N; i++) {
				String word = br.readLine();
				word = word.substring(4, word.length() - 4);
				words.add(word);
			}
			bfs(0, 0);
			System.out.println(maxCount);
		}
	}
	public static void bfs(int start, int count){
		if (count == K - 5){
			int matchCount = 0;
			for (int i = 0; i < words.size(); i++) {
				String wd = words.get(i);
				boolean flag = true;
				for (int j = 0; j < wd.length(); j++) {
					if (!visited[wd.charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag){
					matchCount++;
				}
			}
			maxCount = Math.max(maxCount, matchCount);
		}

		for (int i = start; i < 26; i++) {
			if (!visited[i]){
				visited[i] = true;
				bfs(i, count + 1);
				visited[i] = false;
			}
		}
	}
}

