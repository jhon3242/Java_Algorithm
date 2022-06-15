package programmers.level1.p12977;

import java.util.ArrayList;
import java.util.Arrays;

class Combination{
	int[] num; // 조합할 숫자 배열
	int[] tmp;
	int n; // 몇게를 뽑을 건지
	boolean [] visited;
	ArrayList<int[]> result = new ArrayList<>();

	void combination(int start, int depth){
		if (depth >= n){
			result.add(tmp.clone());
		}
		else{
			for (int i=start; i< num.length; i++){
				if (!visited[i]){
					visited[i] = true;
					tmp[depth] = i;
					combination(i + 1, depth + 1);
					visited[i] = false;
				}
			}
		}
	}

	public Combination(int[] num, int n) {
		this.num = num;
		this.n = n;
		this.tmp = new int[n];
		this.visited = new boolean[n + 1];
		combination(0, 0);
	}
}

class Prime{
	public boolean[] prime;

	public void makePrime(int N){
		prime = new boolean[N + 1];

		if (N < 2)
			return ;

		prime[0] = prime[1] = true; // 소수가 아닌경우 true

		for (int i=2; i<=Math.sqrt(N); i++){
			if (prime[i])
				continue;
			for (int j=i*i; j< prime.length; j=j+i){
				prime[j] = true;
			}
		}
	}

	public Prime(int N) {
		makePrime(N);
	}
}

class Solution {
	static int answer;

	public int solution(int[] nums) {

		Prime prime = new Prime(1000);

		Combination combination = new Combination(nums, 3);
		ArrayList<int[]> result = combination.result;
		for (int[] com : result) {
			int sumNum = Arrays.stream(com).sum();
			if (!prime.prime[sumNum])
				answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4};
		Solution solution = new Solution();
		int solution1 = solution.solution(num);
		return ;
	}
}
