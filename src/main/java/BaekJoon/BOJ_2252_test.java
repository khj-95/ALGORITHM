package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_2252_test {
    private static Map<Integer, List<Integer>> nodes = new HashMap<>();
    private static int[] inCount;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        inCount = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes.put(i, new LinkedList<>());
        }

        int m = Integer.parseInt(input[1]);
        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int front = Integer.parseInt(input2[0]);
            int back = Integer.parseInt(input2[1]);

            nodes.get(front).add(back);
            inCount[back] += 1;
        }
        calculate();

        System.out.print(result.toString());
    }

    private static void calculate() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < inCount.length; i++) {
            if (inCount[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer now = q.poll();
            result.append(now + " ");
            if (Objects.isNull(nodes.get(now))) {
                continue;
            }
            for (Integer next : nodes.get(now)) {
                inCount[next] -= 1;
                if (inCount[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
