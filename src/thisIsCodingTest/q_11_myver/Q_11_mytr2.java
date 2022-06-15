package thisIsCodingTest.q_11_myver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11_mytr2 {
	static int N, K, L;
	static int x, y, dir, tx, ty;
	static int [][] map;
	static int [] turn;
	static int [] dx = {-1, 0, 1, 0};
	static int [] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N][N];
		// 사과 넣기
		for (int i=0; i<K; i++){
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1] = -1;
		}

		// 방향 정보 넣기
		L = Integer.parseInt(br.readLine());
		turn = new int[10000];
		for (int i=0; i<L; i++){
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			if (d=='D') turn[t] = 1;
			else turn[t] = -1;
		}

		int sec = 0;
		x = 0;
		y = 0;
		dir = 1;
		map[x][y] = 1;
		while (true){
			// 방향 전환 해야 하는 경우
			if (turn[sec] != 0)
				map[x][y] = (dir + turn[sec]) % 4;

			int nx = x + dx[dir % 4];
			int ny = y + dy[dir % 4];

			// 맵에서 벗어난 경우
			if (nx < 0 | ny < 0 | nx >= N | ny >= N)
				break;

			// 사과인 경우
			if (map[nx][ny] == -1){
				map[nx][ny] = dir % 4;
				x = nx;
				y = ny;
			}
			else{// 그냥 움직이는 경우
				// 꼬리 먼저 비우기
				tx = tx + dx[map[tx][ty] % 4];
				ty = ty + dy[map[tx][ty] % 4];
				map[tx][ty] = 0;

				// 몸이 있는 경유
				if (map[nx][ny] > 0)
					break;

				map[nx][ny] = dir % 4;
				x = nx;
				y = ny;
			}

			sec++;
		}
		System.out.println(sec);
	}
}
