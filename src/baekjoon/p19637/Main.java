package baekjoon.p19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Status> list = new ArrayList<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			long strong = Long.parseLong(st.nextToken());
			list.add(new Status(name, strong));
		}

		Collections.sort(list);

		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(br.readLine());

			Status status = list.stream().filter(v -> v.isMatch(target))
					.findFirst()
					.orElse(list.get(list.size() - 1));
			System.out.println(status.name);

		}

	}

	static class Status implements Comparable<Status>{
		private String name;
		private long strong;

		public Status(String name, long strong) {
			this.name = name;
			this.strong = strong;
		}

		public boolean isMatch(long str) {
			return str <= strong;
		}

		@Override
		public int compareTo(Status o) {
			return (int)(strong - o.strong);
		}
	}
}
