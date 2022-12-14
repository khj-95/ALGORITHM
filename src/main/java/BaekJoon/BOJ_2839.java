package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 5000);

        dp[3] = 1;

        if (n >= 5) {
            dp[5] = 1;
        }

        for (int i = 5; i < dp.length; i++) {
            dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            dp[i] = Math.min(dp[i], dp[i - 5] + 1);

        }

        if (dp[n] == 5000) {
            dp[n] = -1;
        }
        System.out.println(dp[n]);
    }
}
