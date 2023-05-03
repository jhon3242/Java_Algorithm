package programmers.level1.p42889;

/**
 * Lv1 문제인데 너무 오래걸렸다.
 * PriorityQueue 에 대해 익숙하지 않아서 오래 걸린듯 하다.
 *
 * *    compareTo 를 오버라이딩 했다고 큐가 정렬되는 것이 아니라
 *      Collections.sort 를 통해 정렬을 시켜야 큐가 정렬된다.
 *
 *      compareTo 를 오름차순으로 정렬하게 해놓고
 *      Collections.sort(pq, Collections.reverseOrder()) 를 사용해
 *      내림차순으로 바꿀 수 있다.
 */

import java.util.*;

class Solution {

	private List<Integer> stageIdx;
	private PriorityQueue<Stage> pq = new PriorityQueue<>();

	public int[] solution(int N, int[] stages) {
		int count = stages.length;
		List<Integer> answer = new ArrayList<>();
		stageIdx = new ArrayList<>();

		// init
		for (int i = 0 ; i < N + 2; i ++) {
			stageIdx.add(0);
		}

		// add
		for (int sta : stages) {
			stageIdx.set(sta, stageIdx.get(sta) + 1);
		}

		// add Stage Obj
		for (int i = 1 ; i < stageIdx.size() - 1; i++) {
			int achiveCount = stageIdx.subList(i, stageIdx.size())
					.stream()
					.mapToInt(v -> v)
					.sum();
			// System.out.println("stage " + i + " achiveCount " + achiveCount);
			Float failRate;
			if (achiveCount == 0) failRate = 0f;
			else failRate = (stageIdx.get(i) +0.0f) / achiveCount;
			pq.add(new Stage(i, failRate));
		}

		while (!pq.isEmpty()) {
			// System.out.println(pq.poll());
			answer.add(pq.poll().stage);
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}

class Stage implements Comparable<Stage> {
	public int stage;
	public Float failRate;

	public Stage(int stage, Float failRate) {
		this.stage = stage;
		this.failRate = failRate;
	}

	@Override
	public int compareTo(Stage s) {
		int diff = this.failRate.compareTo(s.failRate);
		if (diff == 0) {
			return this.stage - s.stage;
		}
		return diff * -1;
	}

	@Override
	public String toString() {
		return "stage " + this.stage + " failRate " + this.failRate +"\n";
	}
}