package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Order {
	public static void main(String[] args) {
		//System.out.println(
		//	solution(5, new int[][] {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
		System.out.println(
			solution(6, new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4));



	}

	public static int solution(int N, int[][] road, int K) {

		int[][] path = new int[N + 1][N + 1];
		for (int i = 0; i < road.length; i++) {
			int[] now = road[i];
			if (path[now[0]][now[1]] == 0) {
				path[now[0]][now[1]] = now[2];
				path[now[1]][now[0]] = now[2];
				continue;
			}
			if (path[now[0]][now[1]] > now[2]) {
				path[now[0]][now[1]] = now[2];
				path[now[1]][now[0]] = now[2];
			}
		}

		int[] dp = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			dp[i] = 5_000_000;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		dp[1] = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 1; i < path[now].length; i++) {
				if (path[now][i] == 0) {
					continue;
				}
				if (dp[i] > dp[now] + path[now][i]) {
					dp[i] = dp[now] + path[now][i];
					queue.add(i);
				}
			}
		}

		int count = 0;
		for (int i = 1; i < dp.length; i++) {
			if (dp[i] <= K) {
				count++;
			}
		}

		return count;
	}
}
