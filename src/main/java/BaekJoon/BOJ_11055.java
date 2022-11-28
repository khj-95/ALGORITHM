package BaekJoon;

import java.io.*;

public class BOJ_11055 {
    private static int[] numbers;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        dp = new int[n];

        String[] data = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(data[i]);
            numbers[i] = number;
            dp[i] = number;
        }

        for (int i = 1; i < numbers.length; i++) {
            int temp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < numbers[i]) {
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp + numbers[i];
        }

        int max = -1;
        for (int sum : dp) {
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
