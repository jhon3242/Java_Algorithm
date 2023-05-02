package programmers.level2.p60057;

import java.util.*;

class Solution {

	private String target;

	public int solution(String s) {
		int answer = s.length();
		this.target = s;
		// print(splitByLength(s.length() / 2).toString());

		// int re = getCompressLength(Arrays.asList("aabb", "accc"));
		// print("" + re);

		for (int i = s.length() / 2; i > 0; i--) {
			//     print(splitByLength(i).toString());
			List<String>list = splitByLength(i);
			int result = getCompressLength(list);
			answer = Math.min(answer, result);
			// print(list.toString() + " result " + result);

		}

		return answer;
	}

	private List<String> splitByLength(int n) {
		List<String> result = new ArrayList<>();
		if (target.length() < n || n <= 0){
			result.add(target);
			return result;
		}
		for (int i = 0 ; i < target.length(); i+= n) {
			int end = Math.min(target.length(), i + n);
			result.add(target.substring(i, end));
		}
		return result;
	}

	private int getCompressLength(List<String> list) {
		int result = 0;
		String tmp = "";
		int count = 0;
		boolean first = true;
		for (int i = 0 ; i < list.size(); i++) {
			// print(list.get(i));
			if (!tmp.equals(list.get(i))) {
				if (first) {
					tmp = list.get(i);
					count = 1;
					first = false;
					continue;
				}
				result += tmp.length();
				if (count > 1) result += String.valueOf(count).length();
				tmp = list.get(i);
				count = 1;
			} else {
				count++;
			}
		}

		if (count > 1) {
			result += String.valueOf(count).length();
			// print("result " + result);
		}
		result += tmp.length();
		// print("result " + result);
		return result;
	}

	private void print(String s) {
		System.out.println(s);
	}
}

