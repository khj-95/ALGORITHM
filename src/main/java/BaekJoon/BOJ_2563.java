package BaekJoon;

import java.io.*;

public class BOJ_2563 {
    private static boolean[][] paper = new boolean[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);

            for (int j = 100 - x; j > 90 - x; j--) {
                for (int k = y; k < y + 10; k++) {
                    if (isValid(j, k)) {
                        paper[j][k] = true;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean isValid(int j, int k) {
        return j >= 0 && j < 100 && k >= 0 && k < 100;
    }
}
