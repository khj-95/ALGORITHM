package BaekJoon;

import java.io.*;

public class BOJ_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int[] numbers = new int[20];
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < 20; j++) {
                numbers[j] = Integer.parseInt(data[j + 1]);
            }
            int count = 0;
            for (int j = 1; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if (numbers[k] > numbers[j]) {
                        int temp = numbers[j];
                        for (int l = j; l > k; l--) {
                            numbers[l] = numbers[l - 1];
                            count++;
                        }
                        numbers[k] = temp;
                    }
                }
            }
            bw.write(i + " " + count + "\n");
        }
        bw.flush();
    }
}
