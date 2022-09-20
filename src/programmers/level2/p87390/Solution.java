package programmers.level2.p87390;

import java.util.Arrays;

public class Solution {
	private int N, l_row, r_row;
	public int[] solution(int n, long left, long right) {
		int[] answer = {};
		N = n;
		l_row = (int)(left / n); // 0부터시작
		r_row = (int)(right / n);


		return makeArr(left, right);
	}

	private int[] makeArr(long left, long right){
		long left_idx = left - N * l_row;
		long right_idx = right - N * r_row;

		if (l_row == r_row){
			return Arrays.copyOfRange(n_row(l_row + 1), (int)left_idx, (int)right_idx + 1);
		}
		int[] result = new int[(int)(right - left) + 1];
		int idx = 0;
		for(int i=l_row; i<=r_row; i++){
			int[] tmp = n_row(i+1);
			if (i == l_row){
				for (int j=(int)left_idx; j<N; j++){
					result[idx++] = tmp[j];
				}
			}
			else if (i == r_row){
				for (int j=0; j<=(int)right_idx; j++){
					result[idx++] = tmp[j];
				}
			}
			else{
				for (int j=0; j<N; j++){
					result[idx++] = tmp[j];
				}
			}
		}
		return result;
	}

	private int[] n_row(int num){
		int[] result = new int[N];

		for(int i=0; i<N; i++){
			if (i < num)
				result[i] = num;
			else
				result[i] = i+1;
		}
		return result;
	}
}
