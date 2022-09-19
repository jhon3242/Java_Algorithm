package programmers.level2.p92335;

public class Solution {
	public int solution(int n, int k) {
		int answer = 0;
		String kString = Integer.toString(n, k);
		System.out.println(kString);
		String[] words = kString.split("0");
		for (String word : words){
			if (word.length() <= 0)
				continue;
			if (isPrime(Long.parseLong(word)))
				answer++;
		}

		return answer;
	}

	private boolean isPrime(long num){
		if (num <= 1)
			return false;
		for (long i = 2; i*i <= num; i++){
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
