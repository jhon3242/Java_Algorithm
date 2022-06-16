package programmers.level1.p12977_2;


class Solution {
	private static boolean[] visited;
	private static int r;


	public int solution(int[] nums) {
		visited = new boolean[nums.length];
		return -1;
	}


	private boolean isPrime(int n){
		int max = (int)Math.sqrt(n);
		for (int i=2; i<+max; i++){
			if (n % i == 0)
				return false;
		}
		return true;
	}

}