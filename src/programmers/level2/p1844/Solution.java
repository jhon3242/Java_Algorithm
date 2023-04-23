package programmers.level2.p1844;

/**
 * 이미 방문한 곳을 그냥 0으로 초기화 했더니 효율성을 통과함
 * 어차피 이미 방문했던 곳은 if (this.maps[tx][ty] != 1 && this.maps[tx][ty] < node[0] + 1) continue;
 * 이 부분에서 걸러지지 않나 싶은데 이유를 모르겠다.
 */
import java.util.*;

class Solution {

	private static final PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] a, int[] b) {
			return Integer.compare(a[0], b[0]);
		}
	});
	private static int[][] maps;


	public int solution(int[][] maps) {
		int answer = 0;
		this.maps = maps;
		this.pq.add(new int[] {1, 0, 0});
		bfs();
		return this.maps[this.maps.length - 1][this.maps[0].length - 1] == 1 ? -1 : this.maps[this.maps.length - 1][this.maps[0].length - 1];
	}


	private void bfs() {
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int f = 0;
		while (!pq.isEmpty()) {
			// f++;
			int[] node = pq.poll();
			for (int i = 0 ; i < 4; i++) {
				int tx = dx[i] + node[1];
				int ty = dy[i] + node[2];
				// System.out.println("tx " + tx + " ty " + ty);
				if (isNotValide(tx, ty)) continue;
				if (this.maps[tx][ty] != 1 && this.maps[tx][ty] < node[0] + 1) continue;
				this.maps[tx][ty] = node[0] + 1;
				if (tx == this.maps.length - 1 && ty == this.maps[0].length - 1) return ;
				this.maps[tx][ty] = 0;
				pq.add(new int[] {node[0] + 1, tx, ty});
				// printMap();
			}
			// if (f == 5) break;
		}
	}

	private boolean isNotValide(int tx, int ty) {
		if (tx < 0 || ty < 0 || tx >= this.maps.length || ty >= this.maps[0].length) {
			return true;
		}
		if (tx == 0 && ty == 0) return true;
		if (this.maps[tx][ty] == 0) return true;
		return false;
	}

	private void printMap() {
		for (int i = 0; i < this.maps.length; i++) {
			System.out.println(Arrays.toString(this.maps[i]));
		}
		System.out.println();
	}
}