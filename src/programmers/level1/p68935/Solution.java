package programmers.level1.p68935;

class Answer{
	public int solution(int n) {
		String a = "";

		while (n > 0){
			a += (n % 3);
			n /= 3;
		}
		a = new StringBuilder(a).reverse().toString();
		return Integer.parseInt(a, 3);
	}
}

public class Solution {
	public int solution(int n) {
		int answer = 0;
		String bit = to3th(n);
		StringBuilder tmp = new StringBuilder(bit);
		bit = tmp.reverse().toString();

		return to10th(bit);
	}

	private String to3th(int n){
		String result = "";
		if (n >= 3){
			result += to3th(n / 3);
			result += to3th(n % 3);
		}
		else{
			result += String.valueOf(n);
		}
		return result;
	}
	private int to10th(String str){
		int result = 0;
		for (int i=0; i<str.length(); i++){
			result *= 3;
			char c = str.charAt(i);
			result += c - '0';
		}
		return result;
	}
}