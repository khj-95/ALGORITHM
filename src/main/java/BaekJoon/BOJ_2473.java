package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_2473 {
    private static int[] solution;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int solutionCount = Integer.parseInt(br.readLine());
        solution = new int[solutionCount];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < solutionCount; i++) {
            solution[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(solution);

        int[] result = calculate();
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    private static int[] calculate() {
        long min = Long.MAX_VALUE;
        int[] result = new int[3];

        for (int i = 0; i < solution.length; i++) {
            long[] temp = twoPointer(solution[i]);
            if (Math.abs(min) > Math.abs(temp[0])) {
                min = temp[0];
                result[0] = (int) temp[1];
                result[1] = (int) temp[2];
                result[2] = solution[i];
            }
        }

        Arrays.sort(result);
        return result;
    }

    private static long[] twoPointer(int c) {
        int l = 0;
        int r = solution.length - 1;
        long min = Long.MAX_VALUE;

        int a = 0;
        int b = 0;

        while (l < r) {
            long sum = solution[l] + solution[r] + (long) c;

            if (solution[l] == c) {
                l++;
                continue;
            }

            if (solution[r] == c) {
                r--;
                continue;
            }

            if (Math.abs(min) > Math.abs(sum)) {
                min = sum;
                a = solution[l];
                b = solution[r];
            }

            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        return new long[]{min, a, b};
    }
}
