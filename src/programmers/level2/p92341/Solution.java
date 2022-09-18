package programmers.level2.p92341;

import java.util.*;

class Car implements Comparable<Car>{
	int carNum;
	int totalTime;
	int lastTime;
	boolean state;

	Car(int carNum){
		this.carNum = carNum;
	}

	void setLastTime(int lastTime){
		this.lastTime = lastTime;
	}

	int getLastTime(){
		return this.lastTime;
	}

	void addTotalTime(int num){
		totalTime += num;
	}

	@Override
	public int compareTo(Car o){
		return carNum - o.carNum;
	}
}

public class Solution {
	public int[] solution(int[] fees, String[] records) {
		List<Integer> answerList = new LinkedList<>();
		// PriorityQueue<Car> q = new PriorityQueue<>(); // 우선순위 큐로 구현하면 탐색을 계속 N 만큼 해줘야 해서 비효율적이다.
		Car[] carArr = new Car[10000];
		final int basicTime = fees[0];
		final int basicFee = fees[1];
		final int unitTime = fees[2];
		final int unitFee = fees[3];

		for (String reco : records){
			String[] splited = reco.split(" ");
			String status = splited[2];
			String time = splited[0];
			int carNum = Integer.parseInt(splited[1]);

			if (status.equals("IN")){
				if (carArr[carNum] == null)
					carArr[carNum] = new Car(carNum);
				carArr[carNum].setLastTime(timeToNum(time));
				carArr[carNum].state = true;
			}
			else{
				carArr[carNum].addTotalTime(timeToNum(time) - carArr[carNum].getLastTime());
				carArr[carNum].state = false;
			}
		}

		for(int i = 0; i < 10000; i++){
			if (carArr[i] == null)
				continue;
			if (carArr[i].state) // 마지막에 출차하지 않은 경우
				carArr[i].addTotalTime(timeToNum("23:59") - carArr[i].getLastTime());
			int curTime = carArr[i].totalTime;

			int result = basicFee;
			if (curTime > basicTime){
				int diff = curTime - basicTime;
				if (diff % unitTime != 0){
					diff /= unitTime;
					diff += 1;
				}
				else{
					diff /= unitTime;
				}
				result += diff * unitFee;
			}
			answerList.add(result);
		}

		int[] answer = answerList.stream()
				.mapToInt(i -> i)
				.toArray();

		return answer;
	}

	private int timeToNum(String time){
		String[] tmp = time.split(":");
		return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
	}
}