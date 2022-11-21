package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_2252 {
    private static Node[] nodes;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1);
        }
        int m = Integer.parseInt(input[1]);

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int front = Integer.parseInt(input2[0]) - 1;
            int back = Integer.parseInt(input2[1]) - 1;

            nodes[front].out.add(nodes[back]);
            nodes[back].in.add(nodes[front]);
        }
        calculate();

        System.out.print(result.toString());
    }

    private static void calculate() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].in.size() == 0) {
                q.add(nodes[i]);
            }
        }
        while (!q.isEmpty()) {
            Node now = q.poll();
            result.append(now.data + " ");
            for (int i = 0; i < now.out.size(); i++) {
                Node next = now.out.get(i);
                next.in.remove(now);
                if (next.in.size() == 0) {
                    q.add(next);
                }
            }
        }
    }

    static class Node {
        private int data;
        private List<Node> in;
        private List<Node> out;

        public Node(int data) {
            this.data = data;
            in = new LinkedList<>();
            out = new LinkedList<>();
        }
    }
}
