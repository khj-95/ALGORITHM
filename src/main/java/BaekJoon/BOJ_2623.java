package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_2623 {
    private static Set<Integer>[] singers;
    private static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        singers = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            singers[i] = new HashSet<>();
        }
        indegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 2; j <= Integer.parseInt(data[0]); j++) {
                if (singers[Integer.parseInt(data[j - 1])].contains(Integer.parseInt(data[j]))) {
                    continue;
                }
                singers[Integer.parseInt(data[j - 1])].add(Integer.parseInt(data[j]));
                indegree[Integer.parseInt(data[j])] += 1;
            }
        }

        Queue<Integer> res = topologicalSort();
        if (res.size() != singers.length - 1) {
            System.out.println(0);
            return;
        }
        while (!res.isEmpty()) {
            System.out.println(res.poll());
        }
    }

    private static Queue<Integer> topologicalSort() {
        Queue<Integer> res = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            res.add(now);
            if (singers[now].isEmpty()) {
                continue;
            }
            for (Integer singer : singers[now]) {
                indegree[singer] -= 1;
                if (indegree[singer] == 0) {
                    q.add(singer);
                }
            }
        }
        return res;
    }
}
