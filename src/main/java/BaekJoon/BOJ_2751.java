package BaekJoon;

import java.io.*;

public class BOJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        if (n - 1 > 0) {
            sort(0, n - 1, array);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int number : array) {
            bw.write(number + "\n");
        }
        bw.flush();
    }

    private static void sort(int start, int end, int[] array) {
        int l = start;
        int r = end;
        int pivot = array[start + (int) (Math.random() * (end - start + 1))];

        while (l < r) {
            while (l <= end && array[l] < pivot) {
                l++;
            }

            while (r > l && array[r] > pivot) {
                r--;
            }

            if (l < r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }

        if (r - 1 > start) {
            sort(start, r - 1, array);
        }
        if (r + 1 < end) {
            sort(r + 1, end, array);
        }
    }
}
