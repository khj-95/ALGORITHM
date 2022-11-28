package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_2108 {
    private static int[] numbers;
    private static int[] count = new int[8001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            count[number + 4000] += 1;
            sum += number;
        }

        System.out.println(calcArithmeticMean(sum, n));
        System.out.println(calcMedian(count, n / 2 + 1));
        System.out.println(calcMode(count));
        System.out.println(calcDiff(count));

    }

    private static int calcDiff(int[] count) {
        int min = -4001;
        int max = 4001;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                min = i - 4000;
                break;
            }
        }
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] > 0) {
                max = i - 4000;
                break;
            }
        }
        return max - min;
    }

    private static int calcMode(int[] count) {
        int maxCount = Arrays.stream(count).max().getAsInt();
        List<Integer> modes = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                modes.add(i - 4000);
            }
        }
        if (modes.size() == 1) {
            return modes.get(0);
        }
        return modes.get(1);
    }

    private static int calcMedian(int[] count, int middle) {
        int c = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                c++;
                if (c == middle) {
                    return i - 4000;
                }
            }
        }
        return -1;
    }

    private static int calcArithmeticMean(int sum, int n) {
        return Math.round(sum / (float) n);
    }
}
