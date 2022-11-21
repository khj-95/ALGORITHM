package BaekJoon;

import java.io.*;

public class BOJ_2579 {
    private static int[] stairs;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stairs = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            stairs[i + 1] = Integer.parseInt(br.readLine());
        }

        dp();

        System.out.println(dp[n]);
    }

    private static void dp() {
        dp[1] = stairs[1];
        if (dp.length > 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }
    }
}
