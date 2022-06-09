package thisIsCodingTest.q_06;

import java.util.*;

class Food implements Comparable<Food>{
	private int index;
	private int time;

	public int getIndex() {
		return index;
	}

	public int getTime() {
		return time;
	}

	public Food(int index, int time) {
		this.index = index;
		this.time = time;
	}

	@Override
	public int compareTo(Food o) {
		if (o.getTime() < this.getTime())
			return 1;
		else if (o.getTime() > this.getTime())
			return -1;
		else
			return 0;
	}
}

class Solution {

	public int solution(int[] food_times, long k) {
		int answer = 0;
		int loop = 0;
		int now_time = 0;
		int sum = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		PriorityQueue<Food> q = new PriorityQueue<Food>();

		for (int i : food_times)
			sum += i;
		if (sum <= k)
			return -1;

		for (int i = 0; i<food_times.length; i++){
			q.add(new Food(i, food_times[i]));
		}

		while (!q.isEmpty()){
			Food food = q.peek();
			if ((food.getTime() - loop) * q.size() + now_time > k)
				break;
			food = q.poll();
			now_time += (food.getTime() - loop) * (q.size() + 1);
			loop = food.getTime();
		}
		while (!q.isEmpty()){
			Food food = q.poll();
			arr.add(food.getIndex());
		}
		Collections.sort(arr);

		long i = k - now_time;

		return arr.get((int)(i % arr.size())) + 1;
	}
}

public class Q_06 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] tmp = {1, 1, 1, 1, 1, 2};

		System.out.println(solution.solution(tmp	,6));
	}
}
