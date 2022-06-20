// 체육복
// https://programmers.co.kr/learn/courses/30/lessons/42862

package programmers.level1.p42862;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		LinkedList<Integer> lostArr = new LinkedList<>();
		LinkedList<Integer> reserveArr = new LinkedList<>();

		Arrays.sort(lost);
		Arrays.sort(reserve);
		for (int i : lost) {
			lostArr.add(i);
		}
		for (int i : reserve) {
			reserveArr.add(i);
		}

		int size = reserveArr.size();
		for (int i = 0; i< size; i++){
			Integer num = reserveArr.pollFirst();
			int idx = lostArr.indexOf(num);
			if (idx >= 0){
				lostArr.remove(idx);
				answer++;
			}
			else
				reserveArr.addLast(num);
		}

		for (Integer num : lostArr) {
			int idxM = reserveArr.indexOf(num - 1);
			int idxP = reserveArr.indexOf(num + 1);
			if (idxM >= 0){
				reserveArr.remove(idxM);
			}
			else if (idxP >= 0){
				reserveArr.remove(idxP);
			}
			else
				continue;
			answer++;
		}
		return answer;
	}
}
