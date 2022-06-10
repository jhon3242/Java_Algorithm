package thisIsCodingTest.q_10;

class Graph{

	int[][] graph;
	int     n;

	// 생성자
	public Graph(int[][] graph) {
		this.graph = graph;
		n = graph.length;
	}
}

class Lock extends Graph{

	void sum

	boolean match_ck(int[][] key, int[][] lock){
		for (int i=1; i< key.length; i++){
			for (int j=1; j< key.length; j++){
				System.out.println();
			}
		}
		return true;
	}

	// Lock 3배
	void triple_maze(){
		int[][] result = new int[3*n][3*n];
		for (int i=0; i<3*n ;i++){
			for (int j=0; j<3*n ;j++){
				result[i][j] = 0;
			}
		}
		for (int i=0; i<n ;i++){
			for (int j=0; j<n ;j++){
				result[n + i][n + j] = graph[i][j];
			}
		}
		graph = result;
	}

	public Lock(int[][] graph) {
		super(graph);
	}
}

class Key extends Graph{

	// 90도 시계방향 회전
	void rotate(){
		int[][] result = new int[n][n];
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				result[j][n - i - 1] = graph[i][j];
			}
		}
		graph = result;
	}

	public Key(int[][] graph) {
		super(graph);
	}
}



class Solution {
	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = true;
		Key key_graph = new Key(key);
		Lock lock_graph = new Lock(lock);
		lock_graph.triple_maze();
		key_graph.rotate();
		return answer;
	}
}

public class Q_10 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] tmp = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] tmp2 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		solution.solution(tmp, tmp2);
	}
}
