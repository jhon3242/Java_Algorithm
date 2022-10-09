package programmers.level2.p86971;

import java.util.*;

class Solution {

	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;

		for (int i=0; i<n-1; i++){
			answer = Math.min(answer, getCount(wires, i, n));
		}

		return answer;
	}

	private int getCount(int[][] wires, int idx, int n){
		int[] parents = new int[n+1];
		for (int i=0; i<=n; i++){
			parents[i] = i;
		}

		for (int i=0; i<n-1; i++){
			if (i == idx)
				continue;
			int from = wires[i][0];
			int to = wires[i][1];

			union_parents(parents, from , to);
		}
		int tmp = find_parents(parents, 1), count = 0;
		for (int i=1; i<=n; i++){
			if (find_parents(parents, i) == tmp)
				count++;
			else
				count--;
		}
		return Math.abs(count);
	}

	private int find_parents(int[] parents, int n){
		if (parents[n] != n)
			parents[n] = find_parents(parents, parents[n]);
		return parents[n];
	}

	private void union_parents(int[] parents, int a, int b){
		int x = find_parents(parents, a);
		int y = find_parents(parents, b);
		if (x < y)
			parents[y] = x;
		else
			parents[x] = y;
	}
}