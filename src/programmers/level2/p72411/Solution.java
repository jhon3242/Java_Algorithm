package programmers.level2.p72411;

import java.util.*;

class Solution {
	Map <String, Integer> store = new HashMap<>();
	public String[] solution(String[] orders, int[] course) {
		List<String> answer = new ArrayList<>();

		int idx = 0;
		for (int cour : course){
			for (String ord : orders){
				if (ord.length() >= cour){
					// System.out.println("bfs");
					bfs(ord, cour, new char[cour],0, 0);
				}
			}
			if (store.isEmpty())
				continue;
			int maxCount = Collections.max(store.values());
			for (String key : store.keySet()){
				// System.out.println("key : " + key + " value : " + store.get(key));
				if (maxCount > 1 && store.get(key) == maxCount)
					answer.add(key);
			}
			store = new HashMap<>();
		}

		Collections.sort(answer);

		return answer
				.toArray(new String[0]);
	}

	private void bfs(String str, int size, char[] arr, int start, int d){
		if (d == size){
			char[] t_arr = arr.clone();
			Arrays.sort(t_arr);
			String key = new String(t_arr);
			// System.out.println("key : " + key);
			if (store.containsKey(key))
				store.put(key, store.get(key) + 1);
			else
				store.put(key, 1);
			return ;
		}

		for (int i=start; i<str.length(); i++){
			arr[d] = str.charAt(i);
			bfs(str, size, arr, i + 1, d + 1);
		}
	}


}