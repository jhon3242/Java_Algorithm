package thisIsCodingTest.q_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

interface GraphOp{
	boolean move(); // 본인의 방향으로 한칸 움직이는 함수
	void turnLeft();
	void turnRight();
	boolean endCk(Position position);
	boolean turing();
}

class Position{
	int x;
	int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Diretion{
	int time;
	String direction;

	public Diretion(int time, String direction) {
		this.time = time;
		this.direction = direction;
	}
}

class Graph implements  GraphOp{
//	int[][] graph;
	Deque<Position> apples = new LinkedList<Position>();
	Deque<Diretion> direction = new LinkedList<Diretion>();
	Deque<Position> snake = new LinkedList<Position>();
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	int dir = 1; // 0북 , 1동, 2남, 3서
	int n;
	Position now = new Position(0, 0);
	int time = 0; // 총 걸린 시간

	private boolean containCk(Deque<Position> deque, Position position){
		for (Position node : deque) {
			if (node.x == position.x && node.y == position.y)
				return true;
		}
		return false;
	}

	private boolean removeApple(Deque<Position> deque, Position position){

		for (int i=0; i<deque.size(); i++){
			Position pos = deque.poll();
			if (pos.x == position.x && pos.y == position.y)
				return true;
			else
				deque.offer(pos);
		}
		return false;
	}

	@Override
	public boolean move() {

		Position newPosition = new Position(now.x+dx[dir], now.y+dy[dir]);

		snake.offer(newPosition); // 머리 늘리기
		if (!removeApple(apples, newPosition)){ // 그냥 움직이는 경우
			if (endCk(newPosition)) // 벽 끝에 도달했거나 머리가 꼬리에 닿은 경우
				return false;
			snake.poll(); // 꼬리 움직이기
		}
		now = newPosition;
		time++; // 시간 증가
		return true;
	}

	@Override
	public void turnLeft() {
		dir--;
		if (dir < 0)
			dir = 3;
	}

	@Override
	public void turnRight() {
		dir++;
		if (dir > 3)
			dir = 0;
	}

	@Override
	public boolean endCk(Position position) {
		// 벽 끝에 도달했거나 머리가 꼬리에 닿은 경우
		if (position.x < 0 || position.y < 0 || position.x >= n || position.y >= n)
			return true;
		Position tmp = snake.pollLast(); // 잠시 빼기
		if (containCk(snake, tmp)) // 몸에 닿은 경우
			return true;
		snake.offer(tmp); // 다시 넣기
		return false;
	}

	@Override
	public boolean turing() {
		if (!direction.isEmpty() && direction.peek().time == this.time){
			Diretion dir = direction.poll();
			if (dir.direction.equals("L"))
				turnLeft();
			else
				turnRight();
//			this.time++;
			return true;
		}
		return false;
	}

	public Graph(int n) {
		this.n = n;
	}
}

class Solution{
	Graph graph;

	int start(){
		int result = 0;
		graph.snake.offer(new Position(0, 0));
		while (true) {
			if (graph.turing());
			else if (!graph.move())
				break;
		}
		return graph.time;
	}

	public Solution(Graph graph) {
		this.graph = graph;
	}
}

public class Q_11 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Graph graph = new Graph(n);

		// 사과 넣기
		int end = Integer.parseInt(br.readLine());
		for (int i=0;i<end; i++){
			String[] strings = br.readLine().split(" ");
			int x = Integer.parseInt(strings[0]) - 1;
			int y = Integer.parseInt(strings[1]) - 1;
			Position apple = new Position(x, y);
			graph.apples.add(apple);
		}

		// 방향 넣기
		end = Integer.parseInt(br.readLine());
		for (int i=0;i<end; i++){
			String[] strings = br.readLine().split(" ");
			int time = Integer.parseInt(strings[0]);

			Diretion diretion = new Diretion(time, strings[1]);
			graph.direction.offer(diretion);
		}

		Solution solution = new Solution(graph);
		System.out.println(solution.start() + 1);
	}
}
