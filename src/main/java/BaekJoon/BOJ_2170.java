package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            q.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        int prevY = -1_000_000_001;
        int len = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] < prevY) {
                if (now[1] < prevY) {
                    continue;
                }
                len -= (prevY - now[0]);
            }
            len += (now[1] - now[0]);
            prevY = now[1];
        }
        System.out.println(len);
    }
}
