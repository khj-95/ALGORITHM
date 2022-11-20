package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_1699_Prac {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp();

        System.out.println(dp[n]);
    }

    private static void dp() {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i == j * j) {
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }
    }
}
