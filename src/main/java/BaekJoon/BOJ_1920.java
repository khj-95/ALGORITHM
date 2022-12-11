package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_1920 {
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        StringTokenizer input = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input.nextToken());
        }
        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        int[] numbers = new int[m];
        input = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            numbers[i] = Integer.parseInt(input.nextToken());
        }

        for (int i = 0; i < m; i++) {
            System.out.println(find(numbers[i]));
        }

    }

    private static int find(int number) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == number) {
                return 1;
            }
            if (array[mid] < number) {
                start = mid + 1;
                continue;
            }
            end = mid - 1;
        }
        return 0;
    }
}
