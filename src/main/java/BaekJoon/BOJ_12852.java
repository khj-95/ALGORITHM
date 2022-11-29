package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_12852 {
    private static int[] dp;
    private static int[] before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        before = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp(n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(dp[1] + "\n");
        find(1, bw);
        bw.flush();
    }

    private static void dp(int n) {
        dp[n] = 0;
        for (int i = n; i > 0; i--) {
            if (dp[i - 1] > dp[i] + 1) {
                dp[i - 1] = dp[i] + 1;
                before[i - 1] = i;
            }
            if (i % 2 == 0) {
                if (dp[i / 2] > dp[i] + 1) {
                    dp[i / 2] = dp[i] + 1;
                    before[i / 2] = i;
                }
            }
            if (i % 3 == 0) {
                if (dp[i / 3] > dp[i] + 1) {
                    dp[i / 3] = dp[i] + 1;
                    before[i / 3] = i;
                }
            }
        }
    }

    private static void find(int n, BufferedWriter res) throws IOException {
        if (n == dp.length - 1) {
            res.write(n + " ");
            return;
        }
        find(before[n], res);
        res.write(n + " ");
    }
}
