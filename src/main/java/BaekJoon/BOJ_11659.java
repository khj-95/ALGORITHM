package BaekJoon;

import java.io.*;

public class BOJ_11659 {
    private static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        sum = new int[n + 1];
        String[] numbers = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(numbers[i - 1]);
        }
        for (int i = 0; i < m; i++) {
            String[] range = br.readLine().split(" ");
            bw.write(sum[Integer.parseInt(range[1])] - sum[Integer.parseInt(range[0]) - 1] + "\n");
        }
        bw.flush();
    }
}
