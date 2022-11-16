package BaekJoon;

import java.io.*;

/*
* dp[n]에 n번 까지 n번째 숫자 numbers[n]를 포함하는 max 값 저장
* dp[n]을 어떻게 구할 것인지
* 경우 1 : numbers[n]
* 경우 2 : numbers[n] + dp[n-1]
* 경우 1,2 중 큰 값
*  */
public class BOJ_1912 {
    private static int N;
    private static int[] numbers;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        dp = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        dp();

        int max = Integer.MIN_VALUE;
        for (int sum : dp) {
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }

    private static void dp() {
        dp[0] = numbers[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(numbers[i], numbers[i] + dp[i - 1]);
        }
    }
}
