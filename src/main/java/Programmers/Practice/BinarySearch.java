package Programmers.Practice;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] t = new int[]{10, 20, 30, 40, 60, 110, 120, 130, 170};
        Arrays.sort(t);
        int l = 0;
        int r = t.length - 1;
        int m = (r - l) / 2;

        int g = 175;

        int answer = -1;

        while (l <= r) {

            if (t[m] > g) {
                r = m - 1;
                m = l + (r - l) / 2;
                continue;
            }

            if (t[m] < g) {
                l = m + 1;
                m = l + (r - l) / 2;
                continue;
            }

            if (t[m] == g) {
                answer = m;
                break;
            }
        }

        System.out.println(answer);
    }
}
