package programmers.level2.p17683;

import java.util.*;

class Solution {


	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int maxDiff = 0;

		m = getNewCodes(m);

		for (String info : musicinfos) {
			String[] infos = info.split("\\,");
			int timeDiff = getTimeDiff(infos[0], infos[1]);
			infos[3] = getNewCodes(infos[3]);
			// System.out.println("start");
			// System.out.println("end");

			// isMatch
			StringBuilder sb = new StringBuilder();
			int time = 0;
			while (time < timeDiff) {
				sb.append(infos[3].charAt(time % infos[3].length()));
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

	private String getNewCodes(String code) {
		code = code.replaceAll("C#", "Q");
		code = code.replaceAll("D#", "W");
		code = code.replaceAll("F#", "X");
		code = code.replaceAll("G#", "Y");
		return code;
	}


}