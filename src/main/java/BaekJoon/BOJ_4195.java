package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_4195 {
    private static int[] parent;
    private static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int f = Integer.parseInt(br.readLine());
            Map<String, Integer> friends = new HashMap<>();
            size = new int[f * 2];
            parent = new int[f * 2];
            int idx = 0;
            for (int j = 0; j < f; j++) {
                String[] names = br.readLine().split(" ");
                String name1 = names[0];
                String name2 = names[1];

                if (!friends.containsKey(name1)) {
                    friends.put(name1, idx);
                    parent[idx] = idx;
                    size[idx] = 1;
                    idx++;
                }
                if (!friends.containsKey(name2)) {
                    friends.put(name2, idx);
                    parent[idx] = idx;
                    size[idx] = 1;
                    idx++;
                }

                union(friends.get(name1), friends.get(name2));
                bw.write(size[parent[friends.get(name2)]] + "\n");
            }
        }
        bw.flush();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        parent[a] = b;
        size[b] += size[a];
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
