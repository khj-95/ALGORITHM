package BaekJoon;

import java.io.*;

public class BOJ_11053 {
    private static int[] numbers;
    private static int[] length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        length = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        calc();

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, length[i]);
        }

        System.out.println(max);
    }

    private static void calc() {
        for (int i = 0; i < numbers.length; i++) {
            int longest = length[i];
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    if (longest < length[j]) {
                        longest = length[j];
                    }
                }
            }
            length[i] = longest + 1;
        }
    }
}
