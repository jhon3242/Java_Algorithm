package programmers.level2.p68936;

class Solution {
	static int[][] graph;

	public int[] solution(int[][] arr) {
		int[] answer = new int[]{0, 0};
		graph = arr;

		int n = arr[0].length;
		while (n != 0){
			System.out.println("n : " + n);
			for (int i=0; i<arr.length; i+=n){
				for (int j=0; j<arr[0].length; j+=n){
					int cur = zipCk(new int[]{i, j}, n);
					if (cur == 0)
						answer[0]++;
					else if (cur == 1)
						answer[1]++;
				}
			}
			n /= 2;
		}
		return answer;
	}

	private int zipCk (int[] start, int n){
		int target = graph[start[0]][start[1]];
		for (int i=start[0]; i<start[0]+n; i++){
			for (int j=start[1]; j<start[1] + n; j++){
				if (graph[i][j] == -1 || graph[i][j] != target)
					return -1;
			}
		}

		for (int i=start[0]; i<start[0]+n; i++){
			for (int j=start[1]; j<start[1] + n; j++){
				graph[i][j] = -1;
			}
		}
		return target;
	}
}