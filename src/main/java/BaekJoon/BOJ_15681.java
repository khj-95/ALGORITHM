package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOJ_15681 {
	private static List<Integer>[] connections;
	private static int[] dp;
	private static int n;
	private static int r;
	private static int q;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] data = bufferedReader.readLine().split(" ");
		n = Integer.parseInt(data[0]);
		r = Integer.parseInt(data[1]);
		q = Integer.parseInt(data[2]);

		connections = new ArrayList[n + 1];
		dp = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			connections[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			String[] input = bufferedReader.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);

			connections[u].add(v);
			connections[v].add(u);
		}

		dp(r, 0);

		for (int i = 0; i < q; i++) {
			int u = Integer.parseInt(bufferedReader.readLine());
			bufferedWriter.write(dp[u] + "\n");
		}
		bufferedWriter.flush();
	}

	private static int dp(int now, int prev) {
		dp[now] += 1;
		if (isLeaf(now)) {
			return dp[now];
		}
		for (int i = 0; i < connections[now].size(); i++) {
			int next = connections[now].get(i);
			if (next == prev) {
				continue;
			}
			dp[now] += dp(next, now);
		}
		return dp[now];
	}

	private static boolean isLeaf(int now) {
		return now != r && connections[now].size() == 1;
	}
}
