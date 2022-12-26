package BaekJoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        int gcd = numbers[1] - numbers[0];

        for (int i = 2; i < n; i++) {
            gcd = gcd(gcd, numbers[i] - numbers[i - 1]);
        }

        List<Integer> answer = divisor(gcd);

        for (Integer num : answer) {
            bw.write(num + " ");
        }
        bw.flush();
    }

    private static List<Integer> divisor(int gcd) {
        Set<Integer> res = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= (int) Math.sqrt(gcd); i++) {
            if (gcd % i == 0) {
                res.add(i);
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            res.add(gcd / q.poll());
        }

        res.remove(1);

        return res.stream().sorted().collect(Collectors.toList());
    }

    private static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return gcd(b, r);
    }
}
