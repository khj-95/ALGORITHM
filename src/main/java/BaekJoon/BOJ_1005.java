package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_1005 {
    private static List<Integer>[] buildings;
    private static int[] indegree;
    private static int[] time;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] result = new int[t];
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            buildings = new ArrayList[n + 1];
            indegree = new int[n + 1];
            time = new int[n + 1];
            dp = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                buildings[j] = new ArrayList<>();
            }

            String[] timeString = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                time[j] = Integer.parseInt(timeString[j - 1]);
            }

            for (int j = 0; j < k; j++) {
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                buildings[x].add(y);
                indegree[y] += 1;
            }
            int destination = Integer.parseInt(br.readLine());
            result[i] = calculate(destination);
        }
        for (int res : result) {
            System.out.println(res);
        }
    }

    private static int calculate(int destination) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                dp[i] = time[i];
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            Integer now = q.poll();
            if (buildings[now].isEmpty()) {
                continue;
            }

            for (Integer building : buildings[now]) {
                dp[building] = Math.max(dp[building], dp[now] + time[building]);
                indegree[building] -= 1;
                if (indegree[building] == 0) {
                    q.add(building);
                }
            }
        }
        return dp[destination];
    }
}
