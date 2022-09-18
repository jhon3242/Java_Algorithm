package programmers.level2.p92341;

import java.util.*;

class Car implements Comparable<Car>{
	static int fee = 0;
	int carNum;
	int lastTime = 0;
	int countTime = 0;


	Car(int num, int lastTime){
		this.carNum = num;
		this.lastTime = lastTime;
	}

	void addFee(int num){
		fee += num;
	}

	@Override
	public int compareTo(Car o) {
		return carNum - o.carNum;
	}
}

class Solution {
	public int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		HashMap<Integer, Car> carHash = new HashMap<>();
		PriorityQueue<Car> queue = new PriorityQueue<>();

		for (String reco : records){
			String[] splited = reco.split(" ");
			String time = splited[0];
			int carNum = Integer.parseInt(splited[1]);
			String status = splited[2];

			if (status.equals("IN")){
				System.out.println("in" + carNum);
				Car newCar = new Car(carNum, timeToNum(time));
				if (!queue.contains(carNum))
					queue.add(newCar);
				carHash.put(carNum, newCar);
			}
			else{
				System.out.println("out" + carNum);
				Car current = carHash.get(carNum);
				current.addFee(current.lastTime - timeToNum(time));
				carHash.remove(current);
			}
		}
		carHash.forEach((carNum, car) -> {
			car.addFee(car.lastTime - timeToNum("23:59"));
		});

		return answer;
	}

	private int timeToNum(String time){
		int result = 0;
		String[] splited = time.split(":");
		result += Integer.parseInt(splited[0]) * 60;
		result += Integer.parseInt(splited[1]);
		return result;
	}
}