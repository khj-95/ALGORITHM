package BaekJoon;

import java.io.*;

public class BOJ_1149 {
    private static int[][] costs;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        costs = new int[n + 1][3];
        dp = new int[n + 1][3];
        for (int i = 1; i < n + 1; i++) {
            String[] input = br.readLine().split(" ");
            costs[i][0] = Integer.parseInt(input[0]);
            costs[i][1] = Integer.parseInt(input[1]);
            costs[i][2] = Integer.parseInt(input[2]);
        }

        dp();

        int min = Integer.MAX_VALUE;
        for (int i : dp[n]) {
            if (i < min) {
                min = i;
            }
        }

        System.out.println(min);
    }

    private static void dp() {
        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1];
        dp[1][2] = costs[1][2];

        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
    }
}
