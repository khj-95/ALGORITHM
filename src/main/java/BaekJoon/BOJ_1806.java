package BaekJoon;

import java.io.*;

public class BOJ_1806 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        dp = new int[n + 1];
        String[] data = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] + Integer.parseInt(data[i]);
        }
        int a = 0;
        int b = 1;
        int min = dp.length + 1;
        while (a < dp.length && b < dp.length) {
            if (dp[b] - dp[a] < s) {
                b++;
                continue;
            }
            min = Math.min(min, b - a);
            a++;
        }
        if (min == dp.length + 1) {
            min = 0;
        }
        System.out.println(min);
    }
}
