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

class Lock {

	Graph graph;
	int n;

	boolean match_op(int[][] key, int[][] lock, int x, int y){
		boolean result = true;
		for (int i=0; i< key.length; i++){
			for (int j=0; j< key.length; j++){
				lock[i + x][j + y] += key[i][j];
			}
		}

		for (int i=n; i<2*n; i++){
			for (int j=n; j<2*n; j++){
				if (lock[i][j] != 1){
					result = false;
					break;
				}
			}
		}

		for (int i=0; i< key.length; i++){
			for (int j=0; j< key.length; j++){
				lock[i + x][j + y] -= key[i][j];
			}
		}
		return result;
	}



	boolean match_ck(int[][] key, int[][] lock){
		for (int i=1; i< 2*n; i++){
			for (int j=1; j< 2*n; j++){
				if (match_op(key, lock, i, j))
					return true;
			}
		}
		return false;
	}

	// Lock 3배
	void triple_maze(){
		int[][] result = new int[3*n][3*n];

		// 3배 크기 배열 생성
		for (int i=0; i<3*n ;i++){
			for (int j=0; j<3*n ;j++){
				result[i][j] = 0;
			}
		}
		// 가운데에 기존의 lock 대입
		for (int i=0; i<n ;i++){
			for (int j=0; j<n ;j++){
				result[n + i][n + j] = graph.graph[i][j];
			}
		}
		graph.graph = result;
	}

	public Lock(int[][] graph) {
		this.graph = new Graph(graph);
		this.n = this.graph.n;
	}
}

class Key {

	Graph graph;
	int n;

	// 90도 시계방향 회전
	void rotate(){
		int[][] result = new int[n][n];
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				result[j][n - i - 1] = graph.graph[i][j];
			}
		}
		graph.graph = result;
	}

	public Key(int[][] graph) {
		this.graph = new Graph(graph);
		this.n = this.graph.n;
	}
}



class Solution {

	public boolean solution(int[][] key, int[][] lock) {
		Key key_graph = new Key(key);
		Lock lock_graph = new Lock(lock);
		lock_graph.triple_maze();
		for (int i=0; i<4; i++){
			key_graph.rotate();
			if (lock_graph.match_ck(key_graph.graph.graph, lock_graph.graph.graph))
				return true;
		}
		return false;
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
