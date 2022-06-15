package thisIsCodingTest.q_11_tr2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11_tr2 {
	static int N, K, L;
	static int dir, hx, hy, tx, ty;
	static int[][] map;
	static int[] turn;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];

		// 사과 입력 받기
		for (int i=0; i<K; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = -1;
		}

		L = Integer.parseInt(br.readLine());
		turn = new int[10000];
		for (int i=0; i<L; i++){
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			if (d == 'L')
				turn[t] = -1;
			else
				turn[t] = 1;
		}
		dir = 5;
		map[0][0] = dir;
		int sec = 0;
		while(true){
			dir = (dir + turn[sec]) % 4 + 4;
			int nx = hx + dx[dir - 4];
			int ny = hy + dy[dir - 4];
			if (map[nx][ny] > 0);
		}
	}
}
