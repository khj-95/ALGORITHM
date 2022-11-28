package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_5052 {
    private static String[][] phoneBook;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        phoneBook = new String[t][];
        for (int i = 0; i < t; i++) {
            int count = Integer.parseInt(br.readLine());
            phoneBook[i] = new String[count];
            for (int j = 0; j < count; j++) {
                phoneBook[i][j] = br.readLine();
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(checkConsistency(i));
        }

    }

    private static String checkConsistency(int test) {
        String result = "YES";
        String[] numbers = phoneBook[test];
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1].length() < numbers[i].length()) {
                continue;
            }
            if (numbers[i].equals(numbers[i + 1].substring(0, numbers[i].length()))) {
                result = "NO";
                break;
            }
        }
        return result;
    }
}
