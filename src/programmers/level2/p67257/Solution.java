package programmers.level2.p67257;

import java.util.*;

class Solution {
	private List<String> list = new ArrayList<>();
	private List<String> opList = new ArrayList<>();
	private Long maxValue = 0L;

	public long solution(String expression) {
		long answer = 0;
		splitString(expression);

		dfs(new boolean[3], 0);
		// System.out.println(list);
		return this.maxValue;
	}

	// 연산자와 숫자를 구분하여 배열에 넣는다.
	private void splitString(String expression) {
		String op = "+*-";
		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < expression.length(); i++) {
			String tmp = expression.substring(i, i + 1);
			if (op.contains(tmp)) {
				// System.out.println(tmp);
				if (sb.length() > 0) {
					list.add(sb.toString());
					sb = new StringBuilder();
				}
				list.add(tmp);
			} else {
				sb.append(tmp);
			}
		}
		if (sb.length() > 0) {
			list.add(sb.toString());
			sb = new StringBuilder();
		}
	}

	// 연산자 우선순위를 dfs 로 만든다.
	private void dfs(boolean[] visited, int level) {
		String op = "+-*";

		if (level == 3) {
			// System.out.println(opList);
			updateResult();
			return;
		}

		for (int i = 0; i < 3; i ++) {
			if(!visited[i]) {
				visited[i] = true;
				opList.add(op.substring(i, i + 1));
				dfs(visited, level + 1);
				visited[i] = false;
				opList.remove(opList.size() - 1);
			}
		}
	}

	// 우선순위에 따라 계산한 결과를 최대값과 비교한다.
	private void updateResult() {
		List<String> tmpList = Arrays.asList();
		tmpList.addAll(list);
		for (int j = 0 ; j < 3; j++) {
			String nowOp = opList.get(j);
			// System.out.println("nowOp " + nowOp);
			List<String> newList = new ArrayList<>();
			for (int i = 0 ; i < tmpList.size(); i++) {
				if (tmpList.get(i).equals(nowOp)) {
					// System.out.println(newList.get(newList.size() - 1) + " " +nowOp + " " + tmpList.get(i + 1));
					String result = getOpResult(nowOp, newList.get(newList.size() - 1), tmpList.get(i + 1));
					newList.remove(newList.size() - 1);
					newList.add(result);
					i++;
				} else {
					newList.add(tmpList.get(i));
				}
			}
			// System.out.println("newList " + newList);
			tmpList = newList;
		}
		maxValue = Math.max(maxValue, Math.abs(Long.parseLong(tmpList.get(0))));
		// System.out.println("maxValue " + maxValue);
	}

	private String getOpResult(String op, String a, String b) {
		Long result = 0L;
		if (op.equals("+")) {
			result = Long.parseLong(a) + Long.parseLong(b);
		} else if (op.equals("-")) {
			result = Long.parseLong(a) - Long.parseLong(b);
		} else if (op.equals("*")) {
			result = Long.parseLong(a) * Long.parseLong(b);
		}

		// System.out.println("result " + result);
		return String.valueOf(result);
	}
}