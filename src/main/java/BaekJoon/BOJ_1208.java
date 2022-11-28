package BaekJoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_1208 {
    private static int[] a;
    private static int[] b;
    private static Map<Integer, Integer> aM = new HashMap<>();
    private static Map<Integer, Integer> bM = new HashMap<>();
    private static int s;
    private static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        a = new int[(int) Math.ceil(n / 2f)];
        b = new int[(int) Math.floor(n / 2f)];

        String[] data = br.readLine().split(" ");
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(data[i]);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(data[i + a.length]);
        }

        dfs(0, a, aM, 0);

        dfs(0, b, bM, 0);

        List<Integer> al = aM.keySet().stream().sorted().collect(Collectors.toList());
        List<Integer> bl = bM.keySet().stream().sorted().collect(Collectors.toList());

        int ap = al.size() - 1;
        int bp = 0;
        while (bp < bl.size() && ap >= 0) {
            if (al.get(ap) + bl.get(bp) == s) {
                count += (aM.get(al.get(ap)) * (long) bM.get(bl.get(bp)));
            }
            if (al.get(ap) + bl.get(bp) > s) {
                ap--;
                continue;
            }
            bp++;
        }

        System.out.println(count);
    }

    private static void dfs(int i, int[] array, Map<Integer, Integer> map, int sum) {
        if (i > array.length - 1) {
            return;
        }
        dfs(i + 1, array, map, sum + array[i]);
        dfs(i + 1, array, map, sum);
        Integer c = map.get(sum + array[i]);
        if (c == null) {
            c = 0;
        }
        map.put(sum + array[i], c + 1);
        if (sum + array[i] == s) {
            count++;
        }
    }
}