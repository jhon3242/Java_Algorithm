package thisIsCodingTest.q_09;


import java.util.*;

class SplitedStr{
	private String str;

	public String getStr() {
		return str;
	}

	public int getCount() {
		return count;
	}

	private int count;

	public void addCount() {
		this.count++;
	}

	public SplitedStr(String str, int count) {
		this.str = str;
		this.count = count;
	}
}

class Solution {

	/***
	 * 주어진 문자열을 길이 단위로 압축했을 때 나오는 문자열길이
	 * @param s "ababbaba"
	 * @param len 8
	 * @return "2ab2ba" -> 6
	 */
	public int zipString(String s, int len){
		int result = 0;
		int endIdx = 0;
		Stack<SplitedStr> store = new Stack<SplitedStr>();


		for (int i = 0; i < s.length(); i+=len) {
			endIdx = i + len;
			if (endIdx > s.length())
				endIdx = s.length();
			String str = s.substring(i, endIdx);
			if (!store.isEmpty()) {
				SplitedStr peekStr = store.peek();
				if (peekStr.getStr().equals(str))
					peekStr.addCount();
				else
					store.add(new SplitedStr(str, 1));
			}
			else
				store.add(new SplitedStr(str, 1));
		}

		while (!store.isEmpty()){
			SplitedStr popStr = store.pop();
			result += popStr.getStr().length();
			if (popStr.getCount() != 1)
				result += (popStr.getCount() + "").length();
		}
		return result;
	}

	public int solution(String s) {
		int answer = s.length();
		int len = s.length() / 2;

		for (int i = len; i > 0 ; i--){
			answer = Integer.min(zipString(s, i), answer);
		}
		return answer;
	}
}
public class Q_09 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution("a"));
	}
}


/*import java.util.HashMap;

class Repository{

	private HashMap<String, Integer> store;

	public Repository() {
		store= new HashMap<String, Integer>();
	}
	public void addCount(String str){
		store.replace(str, store.get(str) + 1);
	}

	public void addString(String str){
		if (store.get(str) == null)
			store.put(str, 1);
		else
			addCount(str);
	}
}

class Solution {
	public int solution(String s) {
		int answer = 0;
		int len = s.length();
		int end_idx = 0;

		for (int i = len / 2; i>0; i--){
			Repository repository = new Repository();
			for (int j = 0; j < len; j += i){
				end_idx = j + i;
				if (j + i > len)
					end_idx = len;
				repository.addString(s.substring(j, end_idx));
			}
			System.out.println();
		}
		return answer;
	}
}*/


