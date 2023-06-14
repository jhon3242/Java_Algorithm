package programmers.level2.p17683;

class Solution {
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int maxTime = 0;

		m = getNewCode(m);

		for (String info : musicinfos) {
			String[] infos = info.split("\\,");
			int time = getTimeDiff(infos[0], infos[1]);
			boolean result = isSameMusic(m, getNewCode(infos[3]), time);
			if (result && maxTime < time) {
				maxTime = time;
				answer = infos[2];
			}
		}
		return answer;
	}

	private String getNewCode(String code) {
		String newCode;
		newCode = code.replace("C#", "X");
		newCode = newCode.replace("D#", "Y");
		newCode = newCode.replace("F#", "Z");
		newCode = newCode.replace("G#", "U");
		newCode = newCode.replace("A#", "O");
		return newCode;
	}

	private int getTimeDiff(String start, String end) {
		return getMinute(end) - getMinute(start);
	}

	private int getMinute(String time) {
		String[] t = time.split(":");
		return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
	}

	private boolean isSameMusic(String m, String tmpMusic, int time) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < time; i++) {
			sb.append(tmpMusic.charAt(i % tmpMusic.length()));
		}
		return sb.toString().contains(m);
	}
}