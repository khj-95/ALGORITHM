package BaekJoon;

import java.io.*;

public class BOJ_11052 {
    private static int[] p;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        p = new int[n + 1];
        dp = new int[n + 1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i + 1] = Integer.parseInt(input[i]);
        }

        dp();

        System.out.println(dp[n]);
    }

    private static void dp() {
        for (int i = 1; i < p.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (dp[j] < dp[j - i] + p[i]) {
                    dp[j] = dp[j - i] + p[i];
                }
            }
        }
    }
}
