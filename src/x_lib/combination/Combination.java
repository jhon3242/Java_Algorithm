package x_lib.combination;

import java.util.LinkedList;

public class Combination {

	public int n;
	public int r;
	public int[] tmp;
	public LinkedList<int[]> result = new LinkedList<>();

	public Combination(int n, int r) {
		this.n = n;
		this.r = r;
		tmp = new int[r];
		combination(0, 0);
	}

	public void display(){
		for (int[] tmp : result) {
			for (int j = 0; j < r; j++) {
				System.out.print(tmp[j] + " ");
			}
			System.out.println();
		}
	}

	private void combination(int cnt, int idx){
		if (cnt == r){
			result.add(tmp.clone());
			return;
		}

		for (int i = idx; i < n; i++) {
			tmp[cnt] = i;
			combination(cnt + 1, idx + 1);
		}
	}
}
