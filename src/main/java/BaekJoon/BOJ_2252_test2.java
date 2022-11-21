package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_2252_test2 {
    private static List<Integer>[] nodes;
    private static int[] linkCount;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        nodes = new LinkedList[n + 1];
        linkCount = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);

            nodes[a].add(b);
            linkCount[b] += 1;
        }

        calculate();

        System.out.print(result.toString());
    }

    private static void calculate() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < linkCount.length; i++) {
            if (linkCount[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer now = q.poll();
            result.append(now + " ");
            if (Objects.isNull(nodes[now])) {
                continue;
            }
            for (Integer next : nodes[now]) {
                linkCount[next] -= 1;
                if (linkCount[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
