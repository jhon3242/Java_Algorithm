package programmers.level2.p42888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
	private HashMap<String, String> store = new HashMap<>();
	private ArrayList<String> answer = new ArrayList<>();
	private int idx;

	public String[] solution(String[] record) {

		for (String rec : record) {
			StringTokenizer st = new StringTokenizer(rec);
			String action = st.nextToken();
			String userId = st.nextToken();
			if (action.equals("Leave"))
				leave(userId);
			else{
				String userName = st.nextToken();
				if (action.equals("Enter"))
					enter(userId, userName);
				else
					change(userId, userName);
			}
		}
		String[] result = new String[idx];
		for (int i = 0; i < idx; i++) {
			String line = answer.get(i);
			String userId = line.substring(0, line.indexOf("@"));
			result[i] = line.replaceAll(userId + "@", store.get(userId));
		}
		return result;
	}

	private void enter(String userId, String userName){
		answer.add(userId + "@님이 들어왔습니다.");
		store.put(userId,userName);
		idx++;
	}

	private void leave(String userId){
		answer.add(userId + "@님이 나갔습니다.");
		idx++;
	}

	private void change(String userId, String userName){
		store.put(userId,userName);
	}
}