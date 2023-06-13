package programmers.level2.p17683;

import java.util.*;

class Solution {


	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int maxDiff = 0;

		for (String info : musicinfos) {
			String[] infos = info.split("\\,");
			int timeDiff = getTimeDiff(infos[0], infos[1]);
			List<String> codes = new ArrayList<>();

			// System.out.println("start");
			// if (m.length() > timeDiff) continue;
			// System.out.println("end");

			for (char c : infos[3].toCharArray()) {
				if (c == '#') {
					String tmp = codes.remove(codes.size() - 1);
					codes.add(tmp + "#");
					continue;
				}
				codes.add(String.valueOf(c));
			}


			// isMatch
			StringBuilder sb = new StringBuilder();
			int time = 0;
			while (time < timeDiff) {
				sb.append(codes.get(time % codes.size()));
				time++;
			}

			// System.out.println("sb " + sb);
			// System.out.println("sb.toString().contains(m) " + sb.toString().contains(m));
			// System.out.println("timeDiff > maxDiff " + (timeDiff > maxDiff));
			if (sb.toString().contains(m) && timeDiff > maxDiff) {
				answer = infos[2];
			}

		}

		return answer;
	}

	private int getTimeDiff(String start, String end) {
		return getMinute(end) - getMinute(start);
	}

	private int getMinute(String str) {
		String[] splited = str.split(":");
		return Integer.parseInt(splited[0]) * 60 + Integer.parseInt(splited[1]);
	}


}