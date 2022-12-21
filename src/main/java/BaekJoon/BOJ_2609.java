package BaekJoon;

import java.io.*;

public class BOJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int gcd = gcd(a, b);

        System.out.println(gcd);
        System.out.println(a * b / gcd);
    }

    private static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return gcd(b, r);
    }
}
