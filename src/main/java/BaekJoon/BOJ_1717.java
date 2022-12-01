package BaekJoon;

import java.io.*;

public class BOJ_1717 {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        numbers = new int[n + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] oab = br.readLine().split(" ");
            int o = Integer.parseInt(oab[0]);
            int a = Integer.parseInt(oab[1]);
            int b = Integer.parseInt(oab[2]);
            if (o == 0) {
                union(a, b);
            }
            if (o == 1) {
                if (find(a) == find(b)) {
                    sb.append("YES").append("\n");
                    continue;
                }
                sb.append("NO").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static int find(int a) {
        if (numbers[a] == a) {
            return a;
        }
        return numbers[a] = find(numbers[a]);
    }

    private static void union(int a, int b) {
        numbers[find(b)] = find(a);
    }
}
