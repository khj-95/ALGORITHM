package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_2866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        String[] rows = new String[r];
        for (int j = 0; j < r; j++) {
            rows[j] = br.readLine();
        }

        String[] columns = new String[c];
        for (int i = 0; i < c; i++) {
            String temp = "";
            for (int j = 0; j < r; j++) {
                temp += rows[j].charAt(i);
            }
            columns[i] = temp;
        }

        int count = 0;
        int answer = 0;
        for (int i = 1; i < r; i++) {
            Set<String> newString = new HashSet<>();
            for (int j = 0; j < c; j++) {
                newString.add(columns[j].substring(i));
            }
            if (newString.size() < c) {
                break;
            }
            count++;
        }
        answer = count;
        System.out.println(answer);
    }
}
