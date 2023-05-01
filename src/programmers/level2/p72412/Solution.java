package programmers.level2.p72412;

/**
 * 2차 시도
 */

import java.util.*;

class Solution {
	private static Map<String, List<Integer>> store = new HashMap<>();

	public int[] solution(String[] info, String[] query) {
		List<Integer> answer = new ArrayList<>();


		initInfo(info);

		for (List<Integer> list : store.values()) {
			Collections.sort(list);
		}

		// for (String key : store.)


		// store.values()
		//     .stream()
		//     .forEach(l -> Collections.sort(l));

		for (String qu : query) {
			String[] sp = qu.replaceAll(" and ", " ").split(" ");
			// System.out.println(Arrays.toString(sp.split(" ")));
			String key = String.join("", Arrays.copyOfRange(sp, 0, 4));
			// System.out.println(Arrays.toString(keyArr));
			if (!store.containsKey(key)) {
				answer.add(0);
				continue;
			}
			List<Integer> li = store.get(key);
			int result = bSearch(li, Integer.parseInt(sp[4]));
			answer.add(result);
			// System.out.println(result);
		}
		return answer.stream().mapToInt(i -> i).toArray();
	}

	private void initInfo(String[] info) {
		for (String in : info) {
			String[] sp = in.split(" ");
			recursive(sp, "", 0);
		}
	}

	private void recursive(String[] sp, String key, int level) {

		if (level == 4) {
			List<Integer> list = store.computeIfAbsent(key, v -> new ArrayList<>());
			list.add(Integer.parseInt(sp[4]));
			return;
		}

		recursive(sp, key + sp[level], level + 1);
		recursive(sp, key + "-", level + 1);
	}

	private int bSearch(List<Integer> arr, int target) {
		int start = 0;
		int end = arr.size() - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (arr.get(mid) < target) start = mid + 1;
			else end = mid - 1;
		}
		return arr.size() - start;
	}
}