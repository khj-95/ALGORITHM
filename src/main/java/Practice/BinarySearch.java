package Practice;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] t = new int[]{19, 15, 10, 17};
        int l = 1;
        int r = Arrays.stream(t).max().getAsInt();
        int m = (r - l) / 2;
        int g = 6;
        int sa = 0;
        while (l <= r) {
            int s = 0;
            for (int i = 0; i < t.length; i++) {
                if (t[i] - m > 0) {
                    s += (t[i] - m);
                }
            }

            if (s > g) {
                sa = m;
                l = m + 1;
            }
            if (s < g) {
                r = m - 1;
            }
            if (s == g) {
                sa = m;
                break;
            }

            m = l + (r - l) / 2;
        }
        if (sa == 0 && l > r) {
            System.out.println(-1);
        } else {
            System.out.println(sa);
        }
    }
}
