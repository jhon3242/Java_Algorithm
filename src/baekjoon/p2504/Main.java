package baekjoon.p2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s = new Stack<>();
		String line = br.readLine();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			char tmp;
			if (c == '(' || c == '[') {
				s.push(c);
				continue;
			}
			tmp = s.pop();

		}

	}
}
