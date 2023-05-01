package programmers.level2.p72411;

import java.util.*;
import java.util.stream.*;

/**
 * 2차시도 이지만 1차 시도를 보고 만들었고
 * 1차 시도 방법이 더 깔끔한듯?
 */
class Solution {
	private Map<String, Integer> store = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {
		List<String> answer = new ArrayList<>();

		for (int cour : course) {
			for (String order : orders) {
				String newOrder = Stream.of(order.split(""))
						.sorted()
						.collect(Collectors.joining());
				dfs(newOrder, "", cour, 0, 0);
			}

			if (store.size() == 0) continue;
			int maxCount = Collections.max(store.values());
			if (maxCount < 2) continue;
			for (String key : store.keySet()) {
				if (store.get(key) == maxCount) {
					answer.add(key);
				}
			}
			// System.out.println(answer);
			store.clear();
		}
		Collections.sort(answer);
		return answer.toArray(new String[0]);
	}

	private void dfs(String order, String result, int size, int level, int start) {
		if (level == size) {
			store.compute(result, (k ,v) -> v == null ? 1 : v + 1);
			return ;
		}

		for (int i = start; i < order.length(); i++) {
			String newResult = result + order.substring(i, i + 1);
			dfs(order, newResult,  size, level + 1, i + 1);
		}
	}
}