package BaekJoon;

import java.io.*;

public class BOJ_9095 {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp = new int[t][];
        for (int i = 0; i < t; i++) {
            dp[i] = new int[Integer.parseInt(br.readLine()) + 1];
        }

        calculate();


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < t; i++) {
            bw.write(dp[i][dp[i].length - 1] + "\n");
        }
        bw.flush();
    }

    private static void calculate() {
        for (int i = 0; i < dp.length; i++) {
            dp(dp[i]);
        }
    }

    private static void dp(int[] memo) {
        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < 4; j++) {
                if (i == j) {
                    memo[i] += 1;
                    continue;
                }
                if (i > j && memo[i - j] > 0) {
                    memo[i] += memo[i - j];
                }
            }
        }
    }
}
