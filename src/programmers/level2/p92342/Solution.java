package programmers.level2.p92342;

import java.util.*;
import java.util.stream.*;

/*
System.out.println("x = " + x);
*/

class Solution {

	private List<Integer> finalResult;
	private int maxResult = 0;

	public int[] solution(int n, int[] info) {
		int[] answer = {};
		dfs(n, 10,info, new ArrayList<>());
		// System.out.println("Final result = " + this.result);
		if (maxResult == 0) return new int[]{-1};
		return this.finalResult.stream().mapToInt(Integer::intValue).toArray();
	}


	// 라이언이 쏠 번호 리스트를 구하는 dfs
	// 쏜다면 이길수 있는 값만큼 쏴야함
	private void dfs(int left, int curNum, int pitchInfo[], List<Integer> result) {


		// 더이상 못 쏠 때
		if (left == 0) {
			int count = 10 - result.size() + 1;
			for (int i = 0 ; i < count; i++){
				result.add(0);
			}
			int totalScore = getScore(result, pitchInfo);

			// 정답을 업데이트 해야하는 경우
			if (isUpdate(totalScore, result)) {
				// 점수 업데이트

				updateResult(totalScore, result);
				// System.out.println("update result = " + this.finalResult);
			}
			// updateResult(totalScore, result);
			for (int i = 0 ; i < count; i++){
				result.remove(result.size() - 1);
			}
			return;
		}

		// 다 쐈을 때
		if (curNum == 0) {
			result.add(left);
			int totalScore = getScore(result, pitchInfo);
			if (isUpdate(totalScore, result)) {
				// System.out.println("update result = " + this.result);
				updateResult(totalScore, result);
				// System.out.println("update result = " + this.finalResult);
			}
			result.remove(result.size() - 1);
			return;
		}

		// 안 쏜 경우
		result.add(0);
		dfs(left, curNum - 1 , pitchInfo, result);
		result.remove(result.size() - 1);

		int winCount = getWinCount(curNum, pitchInfo);
		// 쏜 경우
		if (winCount <= left) {
			result.add(winCount);
			dfs(left - winCount, curNum - 1, pitchInfo, result);
			result.remove(result.size() - 1);
		}
	}

	private int getWinCount(int curNum, int[] info) {
		return info[10 - curNum] + 1;
	}

	private int getScore(List<Integer> list, int[] info) {
		int result = 0;
		for (int i = 0 ; i < 11; i++) {
			int score = 10 - i;

			// 둘다 못맞출 때
			if (info[i] == 0 && list.get(i) == 0) {
				continue;
			}

			// 피치가 이긴 경우
			if (info[i] >= list.get(i)) {
				result -= score;
			} else {
				// 라이언이 이긴 경우
				result += score;
			}
		}
		return result;
	}

	// 점수 업데이트
	private void updateResult(int score, List<Integer> lien) {
		this.maxResult = score;
		this.finalResult = new ArrayList<>(lien);
		// System.out.println("this.result = " + this.result);
	}


	// 정답을 바꿔야 하는지
	private boolean isUpdate(int score, List<Integer> list) {
		// 못이기는 경우
		if (score <= 0) return false;

		// 더 좋은 결과가 있는 경우
		if (score > maxResult) return true;

		// 점수가 같은 경우
		if (score == maxResult) {

			for (int i = 10; i >= 0 ; i--) {
				int tmp = list.get(i);
				int reTmp = finalResult.get(i);

				if (tmp == reTmp) continue;
				if (tmp > reTmp) {
					return true;
				}
				return false;
			}
		}
		return false;
	}
}