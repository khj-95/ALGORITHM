package BaekJoon;

import java.io.*;

public class BOJ_1182 {
    private static int[] numbers;
    private static int s;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        numbers = new int[n];

        String[] data = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }

        dfs(0, 0);

        System.out.println(count);
    }

    private static void dfs(int i, int sum) {
        if (i > numbers.length - 1) {
            return;
        }
        dfs(i + 1, sum + numbers[i]);
        dfs(i + 1, sum);
        if (sum + numbers[i] == s) {
            count++;
        }
    }
}
