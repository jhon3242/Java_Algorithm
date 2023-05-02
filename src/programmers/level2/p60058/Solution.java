package programmers.level2.p60058;

import java.util.*;
import java.util.stream.*;

class Solution {
	public String solution(String p) {
		return op(p);
	}

	private String op(String p) {
		String result = "";
		if (p.length() <= 0) return result;
		String[] splited = splitByOrder(p);
		String u = splited[0];
		String v = splited[1];
		if (isCorrect(u)) result = u + op(v);
		else {
			result += "(" + op(v) + ")" + getTrim(u);
		}
		return result;
	}

	private String[] splitByOrder(String p) {
		String tmp = "";

		int i = 0;
		while (i < p.length()) {
			tmp += p.substring(i, i + 1);
			if (isOrdered(tmp)) break;
			i++;
		}
		String a = p.substring(0, i + 1);
		String b = p.substring(i + 1);
		// System.out.println("a " + a + " b " + b);
		return new String[]{a, b};
	}

	private boolean isOrdered(String p) {
		return p.chars()
				.map(c -> {
					if (c == '(') return 1;
					else return -1;
				})
				.sum() == 0;
	}

	private boolean isCorrect(String p) {
		int[] tmp = p.chars()
				.map(c -> {
					if (c == '(') return 1;
					else return -1;
				})
				.toArray();
		int result = 0;
		for (int i = 0; i<tmp.length; i++) {
			result += tmp[i];
			if (result < 0) return false;
		}
		return result == 0;
	}

	private String getTrim(String u) {
		String result = "";
		for (int i = 1 ; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(') result += ")";
			else result += "(";
		}
		return result;
	}

	private void print(String s) {
		System.out.println(s);
	}
}