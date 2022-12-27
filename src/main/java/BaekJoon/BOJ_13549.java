package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_13549 {
	public static int[] dp = new int[100_001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		Arrays.fill(dp, 100_002);

		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		dp[n] = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			if (isValid(now - 1) && dp[now - 1] > dp[now]) {
				dp[now - 1] = dp[now] + 1;
				q.add(now - 1);
			}
			if (isValid(now + 1) && dp[now + 1] > dp[now]) {
				dp[now + 1] = dp[now] + 1;
				q.add(now + 1);
			}
			if (isValid(2 * now) && dp[2 * now] > dp[now]) {
				dp[2 * now] = dp[now];
				q.add(2 * now);
			}
		}
		System.out.println(dp[k]);
	}

	private static boolean isValid(int i) {
		return 0 <= i && i < dp.length;
	}
}
