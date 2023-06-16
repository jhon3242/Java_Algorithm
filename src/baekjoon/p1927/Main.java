package baekjoon.p1927;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int op = Integer.parseInt(br.readLine());
			if (op == 0) {
				if (pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
				continue;
			}
			pq.add(op);
		}

	}
}
