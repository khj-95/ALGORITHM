package BaekJoon;

import java.io.*;

public class BOJ_1929 {
    private static boolean[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        numbers = new boolean[n + 1];

        calculate();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = m; i < numbers.length; i++) {
            if (numbers[i]) {
                continue;
            }
            bw.write(i + "\n");
        }

        bw.flush();
    }

    private static void calculate() {
        numbers[1] = true;
        for (int i = 2; i < numbers.length; i++) {
            if (!isPrimeNumber(i)) {
                continue;
            }
            int j = 2;
            while (j * i < numbers.length) {
                numbers[j * i] = true;
                j += 1;
            }
        }
    }

    private static boolean isPrimeNumber(int i) {
        return i / i == 1 && i % i == 0;
    }
}
