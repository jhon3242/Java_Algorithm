package tmp;

//import programmers.level2.p92341.Car;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile;

import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main {

//	private static int count = 0;
//	private static int answer = Integer.MAX_VALUE;
//	private static Boolean[] visited;
//
//	private static boolean canChange(String now, String target) {
//		int diffCount = 0;
//		for (int i = 0 ; i < target.length(); i++) {
//			if (target.charAt(i) != now.charAt(i)) {
//				diffCount++;
//			}
//		}
//		return diffCount == 1;
//	}
//
//	private static void dfs(String[] words, String now, String target, int level) {
//		for (int i = 0 ; i < words.length; i++) {
//			String word = words[i];
//			if (!visited[i] && canChange(now, word)) {
//				System.out.println(Arrays.toString(visited) + " " + now +" to " + word);
//				visited[i] = true;
//				if (word.equals(target)) {
//					System.out.println("target count : " + (level + 1));
//					answer = Math.min(answer, level + 1);
//					return ;
//				}
//				dfs(words, word, target, level + 1);
//				visited[i] = false;
//			}
//		}
//	}
//
//
//	public static int solution(String begin, String target, String[] words) {
//		visited = new Boolean[words.length];
//
//		for (int i = 0 ; i < visited.length; i++) {
//			visited[i] = false;
//		}
//
//		// System.out.println("visited " + Arrays.toString(visited));
//		dfs(words, begin, target, 1);
//
//		return answer == Integer.MAX_VALUE ? 0 : answer;
//	}



	public static void main(String[] args) throws ParseException {

		Deque<String> qu = new LinkedList<>();

		qu.addFirst("asd");
		qu.addFirst("seoul");
		qu.addFirst("v");


		String str = "seoul";
		if (qu.contains(str)) {
			qu.remove(str);
		}

		System.out.println("qu = " + qu);
	}
}
