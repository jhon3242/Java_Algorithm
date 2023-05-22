package baekjoon.p2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 3차 시도
 * 정답 확인
 * 2(a + b) 를 2a + 2b 로 생각할 수 있었으면 풀 수 있었을듯?
 * 열린괄호가 오면 value 를 곱하고 닫힌괄호가 오면  value 를 나누는
 * 아이디어를 생각하지 못했음
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String  N = br.readLine();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		int value = 1;

		for (int i = 0; i < N.length(); i++) {
			if (N.charAt(i) == '(') {
				value *= 2;
				stack.push(N.charAt(i));
			} else if (N.charAt(i) == '[') {
				value *= 3;
				stack.push(N.charAt(i));
			} else if (N.charAt(i) == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break;
				}
				if (N.charAt(i - 1) == '(') {
					result += value;
				}
				value /= 2;
				stack.pop();
			} else if (N.charAt(i) == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				}
				if (N.charAt(i - 1) == '[') {
					result += value;
				}
				value /= 3;
				stack.pop();
			}
		}
		if (!stack.isEmpty()) System.out.println(0);
		else System.out.println(result);
	}
}
