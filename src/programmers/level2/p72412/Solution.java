package programmers.level2.p72412;

import java.util.*;

import java.util.*;

class Solution {
	static HashMap<String, List<Integer>> map;

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		map = new HashMap<>();

		for (int i = 0; i < info.length; i++) {
			String[] p = info[i].split(" ");
			makeSentence(p, "", 0);
		}

		for (String key : map.keySet())
			Collections.sort(map.get(key));

		int idx = 0;
		for (String q : query){
			q = q.replaceAll(" and ", "");
			String[] split = q.split(" ");
			answer[idx++] = map.containsKey(split[0]) ? binarySearch(split[0], Integer.parseInt(split[1])) : 0;
		}

		return answer;
	}

	// 이분 탐색
	private static int binarySearch(String key, int score) {
		List<Integer> list = map.get(key);
		int start = 0, end = list.size() - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (list.get(mid) < score)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return list.size() - start;
	}

	// info가 포함될 수 있는 문장
	private static void makeSentence(String[] split, String str, int d) {
		if (d == 4){
			if (!map.containsKey(str)){
				map.put(str, new ArrayList());
			}
			map.get(str).add(Integer.parseInt(split[4]));
			return ;
		}
		makeSentence(split, str + split[d], d + 1);
		makeSentence(split, str + "-", d + 1);
	}
}