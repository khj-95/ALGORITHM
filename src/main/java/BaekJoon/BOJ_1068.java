package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_1068 {
    private static Map<Integer, Set<Integer>> tree;
    private static int[] parents;
    private static int leafNodeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        parents = new int[n];

        for (int i = 0; i < n; i++) {
            tree.put(i, new HashSet<>());
        }

        String[] input = br.readLine().split(" ");
        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(input[i]);
            parents[i] = parent;
            if (parent == -1) {
                root = i;
                continue;
            }
            tree.get(parent).add(i);
        }

        int node = Integer.parseInt(br.readLine());

        if (node == root) {
            System.out.println(0);
            return;
        }

        remove(node);

        findLeafNode(root);

        System.out.println(leafNodeCount);
    }

    private static void findLeafNode(int root) {
        Set<Integer> children = tree.get(root);
        if (children.size() == 0) {
            leafNodeCount++;
            return;
        }
        for (Integer child : children) {
            findLeafNode(child);
        }
    }

    private static void remove(int node) {
        tree.get(parents[node]).remove(node);
    }
}
