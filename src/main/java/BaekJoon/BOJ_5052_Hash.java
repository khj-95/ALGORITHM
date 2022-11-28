package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_5052_Hash {
    private static String[][] phoneBook;
    private static Map<Integer, Set<String>>[] numberLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        phoneBook = new String[t][];
        numberLength = new Map[t];
        for (int i = 0; i < numberLength.length; i++) {
            numberLength[i] = new HashMap<>();
            for (int j = 1; j <= 10; j++) {
                numberLength[i].put(j, new HashSet<>());
            }
        }

        for (int i = 0; i < t; i++) {
            int count = Integer.parseInt(br.readLine());
            phoneBook[i] = new String[count];
            for (int j = 0; j < count; j++) {
                String number = br.readLine();
                numberLength[i].get(number.length()).add(number);
                phoneBook[i][j] = number;
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(checkConsistency(i));
        }
    }

    private static String checkConsistency(int test) {
        String[] numbers = phoneBook[test];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j <= numbers[i].length(); j++) {
                Set<String> numSet = numberLength[test].get(j);
                if (numSet.contains(numbers[i])) {
                    continue;
                }
                if (numSet.contains(numbers[i].substring(0, j))) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}
