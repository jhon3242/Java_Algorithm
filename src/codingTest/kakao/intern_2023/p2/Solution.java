package codingTest.kakao.intern_2023.p2;

import java.util.Arrays;

class Solution {
	private int[] deliveries,  pickups;
	private int cap, n;
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		this.cap = cap;
		this.n = n;
		this.deliveries = deliveries;
		this.pickups = pickups;

		int pickIdx, delIdx, newBox, pickedBox;

		while (true){
			pickIdx = getPickIdx();
			delIdx = getDelIdx();
			if (pickIdx < 0 && delIdx < 0)
				return answer;

			pickedBox = 0;
			newBox = Math.min(cap, Arrays.stream(deliveries).reduce(0,(a, b)->  a + b));
			// deliver first
			if (pickIdx <= delIdx){
				System.out.println("deliver first");
				answer += delIdx * 2;

				for (int i = delIdx; i >= 0; i--) {
					//
					if (deliveries[i] > 0 && newBox > 0){
						int count = Math.min(deliveries[i], newBox);
						deliveries[i] -= count;
						newBox -= count;
						System.out.println("deliver to " + (i+1) + " count : " + count);
					}
					if (pickups[i] > 0 && newBox + pickedBox < cap){
						int count = Math.min(pickups[i], cap - newBox + pickedBox);
						pickups[i] -= count;
						pickedBox += count;
						System.out.println("pickup to " + (i+1) + " count : " + count);
					}
				}
			}
			else{
				System.out.println("pickup first");
				answer += pickIdx * 2;

				for (int i = 0; i <= pickIdx; i++) {
					if (deliveries[i] > 0 && newBox > 0) {
						int count = Math.min(deliveries[i], newBox);
						deliveries[i] -= count;
						newBox -= count;
						System.out.println("deliver to " + (i+1) + " count : " + count);
					}
				}
				for (int i = pickIdx; i >= 0; i--) {
					if (pickups[i] > 0 && newBox + pickedBox < cap){
						int count = Math.min(pickups[i], cap - newBox + pickedBox);
						pickups[i] -= count;
						pickedBox += count;
						System.out.println("pickup to " + (i+1) + " count : " + count);
					}
				}
			}
		}
	}

	private int getDelIdx(){
		for (int i = n-1; i >=0; i--) {
			if (deliveries[i]>0)
				return i;
		}
		return -1;
	}

	private int getPickIdx(){
		for (int i = n-1; i >=0; i--) {
			if (pickups[i]>0)
				return i;
		}
		return -1;
	}

}