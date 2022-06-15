package programmers.level1.p12977_2;


class Solution {
	private static boolean[] visited;
	private static int r;

	private void combination(int start, int depth){
		if (depth = r){

		}
	}

	public int solution(int[] nums) {
		visited = new boolean[nums.length];

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