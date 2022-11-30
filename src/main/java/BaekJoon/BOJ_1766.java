package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_1766 {
    private static Set<Integer>[] problems;
    private static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        problems = new HashSet[n + 1];
        for (int i = 0; i < n; i++) {
            problems[i + 1] = new HashSet<>();
        }
        indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            String[] conn = br.readLine().split(" ");
            int a = Integer.parseInt(conn[0]);
            int b = Integer.parseInt(conn[1]);
            problems[a].add(b);
            indegree[b] += 1;
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(calc());

    }

    private static String calc() {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now + " ");
            Set<Integer> nextSet = problems[now];
            if (nextSet.isEmpty()) {
                continue;
            }
            for (Integer next : nextSet) {
                indegree[next] -= 1;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return sb.toString();
    }
}
