package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_1208_2 {
    private static int[] a;
    private static int[] b;
    private static Map<Integer, Integer> aM = new HashMap<>();
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

        dfsA(0, a, 0);

        dfsB(0, b, 0);

        System.out.println(count);
    }

    private static void dfsA(int i, int[] array, int sum) {
        if (i > array.length - 1) {
            return;
        }
        dfsA(i + 1, array, sum + array[i]);
        dfsA(i + 1, array, sum);
        Integer c = aM.get(sum + array[i]);
        if (c == null) {
            c = 0;
        }
        aM.put(sum + array[i], c + 1);
        if (sum + array[i] == s) {
            count++;
        }
    }

    private static void dfsB(int i, int[] array, int sum) {
        if (i > array.length - 1) {
            return;
        }
        dfsB(i + 1, array, sum + array[i]);
        dfsB(i + 1, array, sum);
        Integer c = aM.get(s - (sum + array[i]));
        if (c != null) {
            count += c;
        }
        if (sum + array[i] == s) {
            count++;
        }
    }
}