package Programmers;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
	private static List<int[]> movement = new ArrayList<>();
	private static int count;

	public static void main(String[] args) {
		solution(3);
		System.out.println(count);
	}

	public static int[][] solution(int n) {
		int[][] answer;

		hanoi(n, 1, 3, 2);

		answer = new int[movement.size()][];
		for (int i = 0; i < movement.size(); i++) {
			answer[i] = movement.get(i);
		}

		return answer;
	}

	private static void hanoi(int n, int from, int to, int temp) {
		if (n == 1) {
			count++;
			movement.add(new int[] {from, to});
			return;
		}
		hanoi(n-1, from, temp, to);
		count++;
		movement.add(new int[] {from, to});
		hanoi(n-1, temp, to, from);
	}
}
