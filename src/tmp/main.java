package tmp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
		Map<String , Integer> mbtiMap = new HashMap<>();

		mbtiMap.entrySet()
				.stream()
				.map(entry -> {
					if (entry.getValue() <= 0) {
						return entry.getKey().substring(0, 1);
					} else {
						return entry.getKey().substring(1);
					}
				}).collect(Collectors.joining());
	}
}
