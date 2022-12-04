package BaekJoon;

import java.io.*;

public class BOJ_2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] data = br.readLine().split(" ");
            boolean[] numbers = new boolean[1001];
            for (int j = 0; j < 10; j++) {
                numbers[Integer.parseInt(data[j])] = true;
            }
            bw.write(find(numbers) + "\n");
        }
        bw.flush();
    }

    private static int find(boolean[] numbers) {
        int count = 0;
        int res = 0;
        for (int i = 1000; i > 0; i--) {
            if (numbers[i]) {
                count++;
            }
            if (count == 3) {
                res = i;
                break;
            }
        }
        return res;
    }
}
