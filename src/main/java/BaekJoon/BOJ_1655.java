package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                left.add(num);
            }
            if (i % 2 == 1) {
                right.add(num);
            }

            if (i == 0) {
                bw.write(left.peek() + "\n");
                continue;
            }

            if (left.peek() > right.peek()) {
                int temp = right.poll();
                right.add(left.poll());
                left.add(temp);
            }
            bw.write(left.peek() + "\n");

        }
        bw.flush();
    }
}
