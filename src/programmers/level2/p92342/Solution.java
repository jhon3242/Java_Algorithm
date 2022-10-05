package programmers.level2.p92342;

import java.util.*;

class Solution {
	private int[] score = new int[11];
	private int[] g_info, result = new int[11];
	private int g_n, maxScore;

	public int[] solution(int n, int[] info) {
		g_n = n;
		g_info = info;
		bfs(0);
		// int[] tmp2 = {1,1,2,0,1,2,2,0,0,0,0};
		// System.out.println(winCk(info, tmp2));
		if (arrCount(result) == 0){
			int[] tmp = {-1};
			return tmp;
		}
		return result;
	}

	private int winCk(int[] apitch, int[] lien){
		int a_score = 0, l_score = 0;
		for (int i=0; i<11; i++){
			if (apitch[i] >= lien[i]){
				if (apitch[i] != 0){
					a_score += (10 - i);
				}
			}
			else
				l_score += (10 - i);
		}
		if (a_score >= l_score)
			return -1;
		else
			return l_score - a_score;
	}

	private void bfs(int idx){
		int curCount = arrCount(score);
		if (curCount == g_n || idx == 11){
			int winScore = winCk(g_info, score);
			score[10] = g_n - curCount;
			if (maxScore <= winScore){
				if (maxScore == winScore && !changeCk(score, result)){
					return ;
				}
				result = score.clone();
				maxScore = winScore;
			}
			return ;
		}
		for (int i=idx; i<11; i++){
			int tmp = g_info[i] + 1;
			if (tmp + curCount <= g_n){
				score[i] = tmp;
			}
			bfs(idx + 1);
			score[i] = 0;
		}
	}

	// 현재 최고 점수 배열을 바꿔야 하는지 확인하는 함수
	private boolean changeCk(int[] cur, int[] max){
		for (int i=10; i>=0 ;i--){
			if (cur[i] < max[i])
				return false;
			else if (cur[i] > max[i])
				return true;
		}
		return false;
	}

	private int arrCount(int[] arr){
		int result = 0;
		for (int i: arr){
			result += i;
		}
		return (result);
	}


}
