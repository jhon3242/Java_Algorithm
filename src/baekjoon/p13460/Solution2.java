package baekjoon.p13460;
import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2 {

	private static char[][] graph;
	private static int n;
	private static int m;
	private static int[] b_pos;
	private static int[] r_pos;
	private static int[] o_pos;
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]>visited = new Stack<>();
		Stack<int[][]> posStack = new Stack<>();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b_pos = new int[2];
		r_pos = new int[2];
		o_pos = new int[2];


		// init graph
		initGraph(br);

		// init pos
		initPos();

		int[][] tmp = new int[2][2];
		tmp[0] = r_pos;
		tmp[1] = b_pos;
		posStack.add(tmp);

		while (!posStack.isEmpty()){
			int[][] popPos = posStack.pop();
			int[] now_r_pos = popPos[0];
			int[] now_b_pos = popPos[1];
			visited.add(now_r_pos);

			for (int i = 0; i < 4; i++) {
				int[] tmp_r_pos = new int[2];
				tmp_r_pos[0] = now_r_pos[0] + dx[i];
				tmp_r_pos[1] = now_r_pos[1] + dy[i];

				if (visited.contains(tmp_r_pos))
					continue;
				if (tmp_r_pos[0] < 0)
					continue;

			}
		}
	}

	private static void initPos() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 'B') {
					b_pos[0] = i;
					b_pos[1] = j;
				} else if (graph[i][j] == 'R') {
					r_pos[0] = i;
					r_pos[1] = j;
				} else if (graph[i][j] == 'O') {
					o_pos[0] = i;
					o_pos[1] = j;
				}
			}
		}
	}

	private static void initGraph(BufferedReader br) throws IOException {
		graph = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				graph[i][j] = line.charAt(j);
			}
		}
	}


}
