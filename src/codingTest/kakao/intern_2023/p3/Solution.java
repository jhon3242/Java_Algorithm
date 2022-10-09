package codingTest.kakao.intern_2023.p3;

class Solution {
	private int eCount;
	private int[] sales, answer;
	private int[][] users;
	private int[] emoticons;

	public int[] solution(int[][] users, int[] emoticons) {
		this.users = users;
		this.emoticons = emoticons;
		answer = new int[2];
		eCount = emoticons.length;
		sales = new int[eCount];
		bfs(0, 0);

		return answer;
	}

	private int[] sell(){
		int userCount = users.length;
		int[] userBuy = new int[userCount];
		int[] result = new int[2];
		result[0] = 0;
		result[1] = 0;
		for (int i = 0; i < userCount; i++) {
			int[] user = users[i];
			userBuy[i] = 0;
			// check emo
			for (int j = 0; j < eCount; j++) {
				// buy
				if (user[0] <= sales[j]){
					userBuy[i] += emoticons[j] - emoticons[j] * sales[j] / 100 ;

				}
			}
			// System.out.println(userBuy[i] + " " + user[1]);
			if (userBuy[i] >= user[1]){
				result[0]++;
			}
			else{
				result[1] += userBuy[i];
			}
		}

		return result;
	}

	private void bfs(int now, int d){
		if (d == eCount){
			int[] sellResult = sell();
			// System.out.println(sellResult[0] + " " + sellResult[1]);
			if (answer[0] == sellResult[0]){
				if (answer[1] < sellResult[1])
					answer = sellResult;
			}
			else if (answer[0] < sellResult[0]){
				answer = sellResult;
			}

			return;
		}

		for (int i=0; i<=40; i+=10){
			sales[now] = i;
			bfs(now + 1, d + 1);
		}
	}
}