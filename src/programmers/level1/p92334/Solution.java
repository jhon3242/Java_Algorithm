package programmers.level1.p92334;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;



class Solution {

	static HashMap<String, Report> reports = new HashMap<>();
	static int[] repTime;
	static int[][] myRep;
	static int n;

	public int[] solution(String[] id_list, String[] report, int k) {
		n = id_list.length;
		int[] answer = new int[n];
		StringTokenizer st;

		// init
		for (String name : id_list) {
			reports.put(name, new Report(name, n));
		}

		for (String s : report) {
			st = new StringTokenizer(s);
			String from = st.nextToken();
			String to = st.nextToken();

			// 신고 한 사람 처리
			Report fromReport = reports.get(from);
			if (fromReport.enmy.contains(to))
				continue;
			fromReport.enmy.add(to);
			fromReport.repTime++;

			// 신고 당한 사람 처리
			Report toReport = reports.get(to);
			toReport.repedTime++;
		}
		int i = 0;
		for (String name : id_list) {
			Report myReport = reports.get(name);
			ArrayList<String> enmys = myReport.enmy;
			for (String s : enmys) {
				Report victom = reports.get(s);
				if (victom.repedTime >= k)
					answer[i]++;
			}
			i++;
		}
		return answer;
	}

	static class Report{
		String name;
		ArrayList<String> enmy;
		int repTime = 0;
		int repedTime = 0;

		public Report(String name, int n) {
			this.name = name;
			this.enmy = new ArrayList<>(n);
		}
	}
}