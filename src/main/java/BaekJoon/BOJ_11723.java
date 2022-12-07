package BaekJoon;

import java.io.*;
import java.util.Arrays;

public class BOJ_11723 {
    private static boolean[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        numbers = new boolean[21];

        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            switch (data[0]) {
                case "add":
                    numbers[Integer.parseInt(data[1])] = true;
                    break;
                case "remove":
                    numbers[Integer.parseInt(data[1])] = false;
                    break;
                case "check":
                    if (numbers[Integer.parseInt(data[1])]) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    if (numbers[Integer.parseInt(data[1])]) {
                        numbers[Integer.parseInt(data[1])] = false;
                    } else {
                        numbers[Integer.parseInt(data[1])] = true;
                    }
                    break;
                case "all":
                    Arrays.fill(numbers, true);
                    break;
                case "empty":
                    Arrays.fill(numbers, false);
            }
        }
        bw.flush();
    }
}
