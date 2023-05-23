package x_lib.programersDiff;

import java.util.*;

public class Diff {
	private static int[] getRandomIntArr(int size, int[] range) {
		Random random = new Random();
		return random.ints(size, range[0], range[1] + 1).toArray();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			MySolution mySolution = new MySolution();
			AnswerSolution answerSolution = new AnswerSolution();
			int[] queue1 = getRandomIntArr(300000, new int[]{1, (int)1e9 - 1});
			int[] queue2 = getRandomIntArr(300000, new int[]{1, (int)1e9 - 1});
			int myAnswer = mySolution.solution(queue1.clone(), queue2.clone());
			int answer = answerSolution.solution(queue1.clone(), queue2.clone());
			if (myAnswer != answer) {
				System.out.println("queue1 " + Arrays.toString(queue1));
				System.out.println("queue2 " + Arrays.toString(queue2));
				System.out.println("myAnswer = " + myAnswer);
				System.out.println("answer = " + answer);
				System.out.println();
			}
		}

//		int[] queue1 = new int[] {6, 6, 10};
//		int[] queue2 = new int[] {4, 6, 8};
//		int myAnswer = mySolution.solution(queue1.clone(), queue2.clone());
//		int answer = answerSolution.solution(queue1.clone(), queue2.clone());
//		System.out.println("queue1 " + Arrays.toString(queue1));
//		System.out.println("queue2 " + Arrays.toString(queue2));
//		System.out.println("myAnswer = " + myAnswer);
//		System.out.println("answer = " + answer);
//		System.out.println();

	}
}

class MySolution {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		Long target = 0L;
		List<Integer> que = new ArrayList<>();
		int[] diffIdx = new int[] {0, queue1.length};

		// init
		for (int i = 0; i < queue1.length; i++) {
			que.add(queue1[i]);
			target += queue1[i];
		}
		for (int i = 0; i < queue1.length; i++) {
			que.add(queue2[i]);
			target += queue2[i];
		}

		if (target % 2 == 1) return -1;
		target /= 2;

		Long diff = new Long(Arrays.stream(queue1).sum());

//		System.out.println("target " + target);
		while (diffIdx[0] != diffIdx[1] && answer < queue1.length * 3) {

			if (diff.equals(target)) return answer;

			if (diff < target) {
				diff += que.get(diffIdx[1] % que.size());
				diffIdx[1]++;
			} else {
				diff -= que.get(diffIdx[0] % que.size());
				diffIdx[0]++;
			}
			// diffIdx[0] = diffIdx[0] % que.size();
			// diffIdx[1] = diffIdx[1] % que.size();
			// System.out.println("diff " + diff);
			answer++;
			// break;
		}

		return -1;
	}
}

class AnswerSolution {
	private int[] q1;
	private int[] q2;
	private int[] concat;
	private int start, end, q1Size, q2Size;
	private long target, tmp;

	public int solution(int[] queue1, int[] queue2) {
//		System.out.println("Answer solution queue1 = " + Arrays.toString(queue1) + " queue2 " + Arrays.toString(queue2));
		int answer = 0;
		q1 = queue1;
		q2 = queue2;
		q1Size = q1.length;
		q2Size = q2.length;
		concat = new int[q1Size + q2Size];
		for (int i = 0; i < q1Size; i++) {
			concat[i] = queue1[i];
			target += queue1[i];
			tmp += queue1[i];
		}
		for (int i = 0; i < q2Size; i++) {
			concat[i + q1Size] = queue2[i];
			target += queue2[i];
		}
		end = q1Size;
//		System.out.println("target = " + target);
		if (target % 2 == 1)
			return -1;

		target /= 2;
//		System.out.println("start != end = " + (start != end));
//		System.out.println("start = " + start);
//		System.out.println("end = " + end);
		while (start != end && answer <= q1Size * 3){
			if (tmp > target){
				tmp -= concat[start % (q1Size + q2Size)];
				start++;
				answer++;
			}
			else if (tmp < target){
				tmp += concat[end % (q1Size + q2Size)];
				end++;
				answer++;
			}
			else{
				return answer;
			}
			start %= q1Size + q2Size;
			end %= q1Size + q2Size;
		}

//		System.out.println("start != end = " + (start != end));
//		System.out.println("answer <= q1Size * 3 = " + (answer <= q1Size * 3));
//		System.out.println();
		return -1;
	}
}


