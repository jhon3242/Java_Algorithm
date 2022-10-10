package programmers.level2.p72412;

import java.util.*;

class Solution {
	Map<String, LinkedList> store = new HashMap<>();
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		for (String lan : new String[]{"python", "cpp", "java", "-"}){
			StringBuilder sb = new StringBuilder();
			sb.append(lan);
			for(String part : new String[]{"backend", "frontend", "-"}){
				sb.append(part);
				for(String career : new String[]{"junior", "senior", "-"}){
					sb.append(career);
					for(String food : new String[]{"chicken", "pizza", "-"}){
						sb.append(food);
						// System.out.println("#" + sb + "#");
						store.put(sb.toString(), new LinkedList<>());
						sb.setLength(sb.length() - food.length());
					}
					sb.setLength(sb.length() - career.length());
				}
				sb.setLength(sb.length() - part.length());
			}
			sb.setLength(sb.length() - lan.length());
		}
		// for(String k : store.keySet()){
		// 	System.out.println("k = " + k);
		// }

		for (String i : info){
			String[] split = i.split(" ");
			for (String lan : new String[]{split[0], "-"}){
				StringBuilder sb = new StringBuilder();
				sb.append(lan);
				for(String part : new String[]{split[1], "-"}){
					sb.append(part);
					for(String career : new String[]{split[2], "-"}){
						sb.append(career);
						for(String food : new String[]{split[3], "-"}){
							sb.append(food);
							store.get(sb.toString()).add(Integer.parseInt(split[4]));
							sb.setLength(sb.length() - food.length());
						}
						sb.setLength(sb.length() - career.length());
					}
					sb.setLength(sb.length() - part.length());
				}
				sb.setLength(sb.length() - lan.length());
			}
		}

		for(String k : store.keySet()){
			Collections.sort(store.get(k), Collections.reverseOrder());
		 }

		int idx = 0;
		for (String q : query){
			String[] split = q.split(" ");
			String curKey = split[0] + split[2] + split[4] + split[6];
			int score = Integer.parseInt(split[7]);

			LinkedList<Integer> list = store.get(curKey);
			int count = getCount(list, score);
			System.out.println("count = " + count);
			answer[idx++] = count;
		}
		return answer;
	}

	private int getCount(LinkedList<Integer> list, int score){
		int start = 0, end = list.size() - 1;
		while (start <= end){
			int mid = (start + end) / 2;
			if (list.get(mid) < score) // 오른쪽에 있는 경우
				start = mid + 1;
			else
				end = mid - 1;
		}
		return list.size() - start;
	}
}