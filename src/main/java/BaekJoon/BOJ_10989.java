package BaekJoon;

import java.io.*;

public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[10_001];
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[number] += 1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < 10_001; i++) {
            for (int j = 0; j < numbers[i]; j++) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
