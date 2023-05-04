package programmers.level2.p42888;

import java.util.*;

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


/**
 * 2회 차 인데
 * 1회차 방법이 더 깔끔하고 좋을듯하다.
 */
//import java.util.*;
//
//class Solution {
//	Map<String, User> users = new HashMap<>();
//
//	public String[] solution(String[] record) {
//		List<String> records = new ArrayList<>();
//
//		for (String rec : record) {
//			String[] recSplited = rec.split(" ");
//			String recId = recSplited[1];
//			if (recSplited[0].equals("Enter")) {
//				records.add("Enter " + recId);
//				if (!users.containsKey(recId)) {
//					users.put(recId, new User(recId, recSplited[2]));
//				} else {
//					User tmpUser = users.get(recId);
//					tmpUser.change(recSplited[2]);
//				}
//			} else if (recSplited[0].equals("Leave")) {
//				records.add("Leave " + recId);
//			} else {
//				User tmpUser = users.get(recId);
//				tmpUser.change(recSplited[2]);
//			}
//		}
//
//		return records.stream().map(str -> {
//			String[] sp = str.split(" ");
//			String status = sp[0].equals("Enter") ? "들어왔습니다." : "나갔습니다.";
//			return users.get(sp[1]).username + "님이 " + status;
//		}).toArray(String[]::new);
//
//		// for (String key : users.keySet()) {
//		//     // System.out.println(users.get(key));
//		// }
//
//
//		// return records.toArray(new String[0]);
//	}
//}
//
//class User {
//
//	public String id ;
//	public String username;
//
//	public User(String id, String username) {
//		this.id = id;
//		this.username = username;
//	}
//
//	public void change(String newName) {
//		this.username = newName;
//	}
//
//	@Override
//	public String toString() {
//		return "id " + this.id + " username " + this.username;
//	}
//}