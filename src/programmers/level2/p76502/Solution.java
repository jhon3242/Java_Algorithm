package programmers.level2.p76502;

import java.util.*;

class Solution {
	private static Queue<Character> queue = new LinkedList<>();
	private static char[] open = {'{', '[', '('};
	private static char[] close = {'}', ']', ')'};

	public int solution(String s) {
		int answer = 0;
		// init
		for (int i = 0; i < s.length(); i++) {
			queue.add(s.charAt(i));
		}
		for (int i = 0; i < s.length(); i++) {
			String cur = queue.toString().replace(", ", "");
			cur = cur.substring(1, cur.length()-1);

			if (isRight(cur)){
				answer++;
			}

			Character poll = queue.poll();
			queue.add(poll);
		}
		return answer;
	}

	private boolean isRight(String str){
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			// open pattern check
			if (contains(cur, open)){
				s.add(str.charAt(i));
			}
			// close pattern check
			else if (contains(cur, close)){
				if (s.isEmpty())
					return false;

				Character poped = s.pop();
				int matchIdx = -1;
				for (int j = 0; j < close.length; j++) {
					if (close[j] == cur){
						matchIdx = j;
					}
				}
				// open & close match check
				if (poped != open[matchIdx]){
					return false;
				}
			}
		}
		if (s.isEmpty())
			return true;
		else
			return false;
	}

	private boolean contains(char tar, char[] arr){
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == tar)
				return true;
		}
		return false;
	}
}




