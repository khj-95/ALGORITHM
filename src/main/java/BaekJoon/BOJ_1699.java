package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_1699 {
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
        for (int i = 1, j = 1; i < dp.length; i++) {
            if (i == j * j) {
                dp[i] = 1;
                j += 1;
                continue;
            }
            int squareNumber = (j - 1) * (j - 1);
            dp[i] = dp[i - squareNumber] + 1;
            for (int k = 1, l = 1; k < squareNumber; k = l * l) {
                dp[i] = Math.min(dp[i], dp[i - k] + 1);
                l += 1;
            }
        }
    }
}
