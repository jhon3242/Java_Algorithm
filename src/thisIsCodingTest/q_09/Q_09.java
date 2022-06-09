package thisIsCodingTest.q_09;

import java.util.HashMap;

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
}

public class Q_09 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("aabbaccc");
	}
}
