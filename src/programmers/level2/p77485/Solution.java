package programmers.level2.p77485;

class Solution {
	private static int[][] graph;
	private static int x, y;

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		graph = new int[rows][columns];
		x = rows;
		y = columns;
		initGraph();


		for (int i=0; i<queries.length; i++){
			int[] cur = queries[i];
			answer[i] = rotateWithMin(cur[0]-1 , cur[1]-1, cur[2]-1, cur[3]-1);
		}
		// display();
		return answer;
	}

	private int rotateWithMin(int x1, int y1, int x2, int y2){
		int tmp1 = 10001;
		int tmp2;
		int min = 10001;
		// top
		for (int i=y1; i<=y2; i++){
			tmp2 = graph[x1][i];
			graph[x1][i] = tmp1;
			min = Math.min(tmp2, min);
			tmp1 = tmp2;
		}
		// right
		for (int i=x1+1; i<=x2; i++){
			tmp2 = graph[i][y2];
			graph[i][y2] = tmp1;
			min = Math.min(tmp2, min);
			tmp1 = tmp2;
		}
		// bottom
		for (int i=y2-1; i>=y1; i--){
			tmp2 = graph[x2][i];
			graph[x2][i] = tmp1;
			min = Math.min(tmp2, min);
			tmp1 = tmp2;
		}
		// left
		for (int i=x2-1; i>=x1; i--){
			tmp2 = graph[i][y1];
			graph[i][y1] = tmp1;
			min = Math.min(tmp2, min);
			tmp1 = tmp2;
		}
		return min;
	}

	private void display(){
		for (int i=0; i<x; i++){
			for (int j=0; j<y; j++){
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void initGraph(){
		int num = 1;
		for (int i=0; i<x; i++){
			for (int j=0; j<y; j++){
				graph[i][j] = num;
				num++;
			}
		}
	}
}