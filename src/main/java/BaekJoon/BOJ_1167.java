package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_1167 {
    private static Set<Node>[] connections;
    private static int diameter = 0;
    private static int nodeNumber = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        connections = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            connections[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            int now = Integer.parseInt(st[0]);
            for (int j = 1; j < st.length - 1; j += 2) {
                int next = Integer.parseInt(st[j]);
                int distance = Integer.parseInt(st[j + 1]);
                connections[now].add(new Node(next, distance));
            }
        }

        calculate(0, 1, 0);
        diameter = 0;
        calculate(0, nodeNumber, 0);

        System.out.println(diameter);
    }

    private static int calculate(int prev, int now, int sum) {
        for (Node next : connections[now]) {
            if (next.data == prev) {
                continue;
            }
            if (diameter < sum + next.distance) {
                diameter = sum + next.distance;
                nodeNumber = next.data;
            }
            sum = calculate(now, next.data, sum + next.distance);
            sum -= next.distance;
        }
        return sum;
    }

    private static class Node {
        private int data;
        private int distance;

        public Node(int data, int distance) {
            this.data = data;
            this.distance = distance;
        }
    }
}
