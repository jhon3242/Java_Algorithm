package baekjoon.p2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2차시도
 * NumberOfFormat 런타임 발생
 */

public class Main {
	private static Stack<Character> stack;
	private static Stack<Integer> resultStack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stack = new Stack<>();
		String line = br.readLine();


		if (isFail(line)) {
			System.out.println(0);
			return;
		}
		int result = op(line);
		System.out.println(result);

//		System.out.println(isFail("(())[][]"));
	}

	public static boolean isFail(String line) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '(') a++;
			if (line.charAt(i) == '[') b++;
			if (line.charAt(i) == ')') a--;
			if (line.charAt(i) == ']') b--;

			if (a < 0 || b < 0) return true;
		}
		return a != 0 || b != 0;
	}

	// (2()()[[]])([])
	public static int op(String line) {

		boolean isEnd = true;
		while (isEnd) {
			isEnd = false;
			Matcher matcher2 = Pattern.compile("(\\d*)\\((\\d*)\\)(\\d*)").matcher(line);

//			if (!matcher2.matches() && !matcher3.matches()) break;
//			String group = matcher2.group();
//			System.out.println("group = " + group);
//			System.out.println("matcher.group(1) = " + matcher2.group(1));
//			System.out.println("matcher.group(2) = " + matcher2.group(2));
//			System.out.println("matcher.group(3) = " + matcher2.group(3));
			String prefix, suffix, midfix;
			int preNum, midNum, sufNum;

			if (matcher2.find()) {
//				System.out.println("matcher.group(3) = " + matcher2.group(3));
				prefix = matcher2.group(1);
				preNum = 0;
				if (!Objects.equals(prefix, "")) {
					preNum = Integer.parseInt(matcher2.group(1));
				}
				suffix = matcher2.group(3);
				sufNum = 0;
				if (!Objects.equals(suffix, "")) {
					sufNum = Integer.parseInt(matcher2.group(3));
				}

				midfix = matcher2.group(2);
				midNum = 1;
				if (!Objects.equals(midfix, "")) {
					midNum = Integer.parseInt(matcher2.group(2));
				}
				line = matcher2.replaceFirst(String.valueOf(preNum + 2 * midNum + sufNum));
				isEnd = true;
//				System.out.println("line = " + line);
			}
			Matcher matcher3 = Pattern.compile("(\\d*)\\[(\\d*)\\](\\d*)").matcher(line);
			if (matcher3.find()) {

				prefix = matcher3.group(1);
				preNum = 0;
				if (!Objects.equals(prefix, "")) {
					preNum = Integer.parseInt(matcher3.group(1));
				}
				suffix = matcher3.group(3);
				sufNum = 0;
				if (!Objects.equals(suffix, "")) {
					sufNum = Integer.parseInt(matcher3.group(3));
				}

				midfix = matcher3.group(2);
				midNum = 1;
				if (!Objects.equals(midfix, "")) {
					midNum = Integer.parseInt(matcher3.group(2));
				}
				line = matcher3.replaceFirst(String.valueOf(preNum + 3 * midNum + sufNum));
				isEnd = true;
//				System.out.println("line = " + line);
			}
		}

		return Integer.parseInt(line);

//		line = line.replaceAll("\\(\\)", "2");
//		line = line.replaceAll("\\[\\]", "3");
//		System.out.println("line = " + line);
//
//		line = line.replaceAll("23", "5");
//		line = line.replaceAll("32", "5");
//		line = line.replaceAll("33", "6");
//		line = line.replaceAll("22", "4");
//		System.out.println("line = " + line);
//
//
//		Matcher mul2 = Pattern.compile("(\\()([0-9]+)(\\))").matcher(line);
//
//		if (mul2.find()) {
//			String group = mul2.group();
//			int replaceNum = Integer.parseInt(mul2.group(2)) * 2;
//			line = mul2.replaceAll("" + replaceNum);
//		}
//		System.out.println("line = " + line);
//
//		Matcher mul3 = Pattern.compile("(\\[)([0-9]+)(\\])").matcher(line);
//		if (mul3.find()) {
//			String group = mul3.group();
//			int replaceNum = Integer.parseInt(mul3.group(2)) * 3;
//			line = mul3.replaceAll("" + replaceNum);
//		}
//		System.out.println("line = " + line);

//		StringBuilder sb = new StringBuilder(line);
//
////		sb.rep
//
//		for (int i = 0; i < line.length(); i++) {
//
//		}

//		return 0;
	}
}
