package programmers.level2.p87377;

import java.util.*;

class Point{
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return x == point.x && y == point.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}

class Solution {
	private Set<Point> points = new HashSet<>();
	private int[] order = new int[2];
	private int INF = 1000;

	public String[] solution(int[][] line) {
		char[][] graph;
		dfs(line, 0, 0);
		int maxR = 0, maxC = 0, minR = INF, minC = INF, r_size = 0, c_size = 0;

		// x, y 에 칼럼, 로우가 맞춰짐
		for (Point p : points){
			maxC = Math.max(maxC, p.x);
			maxR = Math.max(maxR, p.y);
			minC = Math.min(minC, p.x);
			minR = Math.min(minR, p.y);
		}

		r_size = maxR - minR + 1;
		c_size = maxC - minC + 1;
		graph = new char[r_size][c_size];
		System.out.println("r size : " + r_size + " c_size : " + c_size);
		for (int i=0; i<r_size; i++){
			Arrays.fill(graph[i], '.');
		}

		for (Point p : points){
			p.x = p.x + minC * (-1);
			p.y = p.y + minR * (-1);
			// System.out.println(p);
			graph[p.y][p.x] = '*';
		}

		// System.out.println("maxR = " + maxR);
		// System.out.println("maxC = " + maxC);
		// System.out.println("minR = " + minR);
		// System.out.println("minC = " + minC);
		String[] answer = new String[r_size];
		for (int i=0; i<r_size; i++){
			answer[r_size - i - 1] = new String(graph[i]);
		}
		return answer;
	}

	private void addPoint(int[][] line, int[] r1, int[] r2){
		if ((r1[0]*r2[1] - r1[1]*r2[0]) == 0){
			return ;
		}
		if ((r1[1]*r2[2] - r1[2]*r2[1]) % (r1[0]*r2[1] - r1[1]*r2[0]) != 0 ||
				(r1[2]*r2[0] - r1[0]*r2[2]) % (r1[0]*r2[1] - r1[1]*r2[0]) != 0
		)
			return ;

		int x = (r1[1]*r2[2] - r1[2]*r2[1]) / (r1[0]*r2[1] - r1[1]*r2[0]);
		int y = (r1[2]*r2[0] - r1[0]*r2[2]) / (r1[0]*r2[1] - r1[1]*r2[0]);
		points.add(new Point(x, y));
	}

	private void dfs(int[][] line, int start, int d){
		if (d == 2){
			addPoint(line, line[order[0]], line[order[1]]);
			return;
		}
		for (int i=start; i<line.length; i++){
			order[d] = i;
			dfs(line, start + 1, d + 1);
		}
	}
}