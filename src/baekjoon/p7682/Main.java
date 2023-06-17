package baekjoon.p7682;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String tmp = br.readLine();
			if (tmp.equals("end")) break;
			char[][] graph = new char[3][3];
			graph[0] = tmp.substring(0, 3).toCharArray();
			graph[1] = tmp.substring(3, 6).toCharArray();
			graph[2] = tmp.substring(6).toCharArray();
			printG(graph);
		}
	}

	private static void printG(char[][] graph) {
		for (int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(graph[i]));
		}
		System.out.println();
	}
}
