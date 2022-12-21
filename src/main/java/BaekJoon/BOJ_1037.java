package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        if (n == 1) {
            System.out.println((int) Math.pow(Integer.parseInt(input[0]), 2));
            return;
        }

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(numbers);
        System.out.println(numbers[0] * numbers[numbers.length - 1]);
    }
}
