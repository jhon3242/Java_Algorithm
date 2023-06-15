package programmers.level2.p17677;

import java.util.*;

class Solution {
	private List<String> zip1;
	private List<String> zip2;

	public int solution(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		zip1 = getSplit(str1);
		zip2 = getSplit(str2);

		int sameCount = getSameCount();
		int allCount = zip1.size() + zip2.size() + sameCount;

		if (allCount == 0) {
			return 65536;
		}

		double result = sameCount * 1.0 / allCount * 65536;
		return (int)result;
	}

	private List<String> getSplit(String str) {
		List<String> result = new ArrayList<>();

		for (int i = 0 ; i < str.length() - 1; i++) {
			String tmp = str.substring(i, i + 2);
			if (isAlpha(tmp)) result.add(tmp);
		}
		return result;
	}

	private boolean isAlpha(String str) {
		for (int i = 0 ; i < str.length(); i++) {
			if ('A' > str.charAt(i) || str.charAt(i) > 'Z') {
				return false;
			}
		}
		return true;
	}

	private int getSameCount() {
		List<String> newZ1 = new ArrayList<>();
		int count = 0;
		for (String target : zip1) {
			if (zip2.remove(target)) {
				count++;
				continue;
			}
			newZ1.add(target);
		}
		zip1 = newZ1;
		return count;
	}
}