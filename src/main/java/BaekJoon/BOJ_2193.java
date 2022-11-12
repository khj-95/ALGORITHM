package BaekJoon;

import java.io.*;

public class BOJ_2193 {
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n < 3){
            System.out.println(1);
            return;
        }
        dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp();
        System.out.println(dp[n]);
    }

    private static void dp() {
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
    }
}