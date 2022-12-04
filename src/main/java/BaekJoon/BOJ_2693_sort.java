package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_2693_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] data = br.readLine().split(" ");
            int[] numbers = new int[data.length];
            for (int j = 0; j < data.length; j++) {
                numbers[j] = Integer.parseInt(data[j]);
            }
            Arrays.sort(numbers);
            bw.write(numbers[data.length - 3] + "\n");
        }
        bw.flush();
    }
}
