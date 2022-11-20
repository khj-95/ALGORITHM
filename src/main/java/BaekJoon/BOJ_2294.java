package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_2294 {
    private static int[] coins;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        coins = new int[n];
        dp = new int[k + 1];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp();

        System.out.println(dp[k]);
    }

    private static void dp() {
        for (Integer coin : coins) {
            if(coin < dp.length){
                dp[coin] = 1;
            }
            for (int i = coin; i < dp.length; i++) {
                if(dp[i - coin] < 0){
                    continue;
                }
                if(dp[i] < 0){
                    dp[i] = dp[coin] + dp[i - coin];
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[coin] + dp[i - coin]);
            }
        }
    }
}
