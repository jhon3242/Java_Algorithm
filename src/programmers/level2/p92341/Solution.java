package programmers.level2.p92341;

import java.util.*;

/**
 System.out.println("x = " + x);
 */
class Solution {

	private final int Time = 0;
	private final int Num = 1;
	private final int Status = 2;
	private Map<String, Car> store = new HashMap<>();

	public int[] solution(int[] fees, String[] records) {
		for (String rec : records) {
			String[] split = rec.split(" ");
			handleRecord(split);
		}
		handle24();

		for (Car tmp : store.values()) {
			tmp.calculate(fees);
			// System.out.println("tmp = " + tmp);
		}
		List<Car> cars = new ArrayList<>(store.values());
		Collections.sort(cars);
		return cars.stream().mapToInt(v -> v.totalFee).toArray();
	}

	private void handleRecord(String[] split) {
		Car tmpCar = store.getOrDefault(split[Num], new Car(split));
		// 입차
		if (split[Status].equals("IN")) {
			tmpCar.handleIn(split[Time]);
			store.put(split[Num], tmpCar);
			return ;
		}
		// 출차
		tmpCar.handleOut(split[Time]);
	}


	// 출차 안한 차들 업데이트
	private void handle24() {
		for (Car tmp : store.values()) {
			if (tmp.status.equals("IN")) {
				tmp.handleOut("23:59");
			}
		}
	}



	class Car implements Comparable<Car>{
		String status;
		String time;
		String num;
		int total;
		int totalFee;

		public Car(String[] split) {
			this.num = split[Num];
			this.time = split[Time];
			this.status = "IN";
			this.total = 0;
			this.totalFee = 0;
		}

		public void handleIn(String time) {
			this.time = time;
			this.status = "IN";
			// System.out.println("In : " + time + " " + this);
		}

		public void handleOut(String time) {
			this.total += getNumTime(time) - getNumTime(this.time);
			this.time = time;
			this.status = "OUT";
			// System.out.println("Out : " + time + " " + this);
		}

		private int getNumTime(String time) {
			String[] split = time.split("\\:");
			return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
		}

		public String toString() {
			return "num : " + num + " time : " + time + " total : " + total + " totalFee : " + totalFee;
		}

		public void calculate(int[] fees)  {
			final int BasicT = 0;
			final int BasicF = 1;
			final int UnitT = 2;
			final int UnitF = 3;

			// 기본 요금
			if (this.total <= fees[BasicT]) {
				this.totalFee = fees[BasicF];
				return;
			}

			// 초과 요금
			this.totalFee = fees[BasicF] + getRound(this.total -
					fees[BasicT], fees[UnitT]) * fees[UnitF];
		}

		private int getRound(int a, int b) {
			return (int)Math.ceil(a*1.0 / b);
		}

		@Override
		public int compareTo(Car o) {
			return Integer.parseInt(this.num) - Integer.parseInt(o.num);
		}
	}

}