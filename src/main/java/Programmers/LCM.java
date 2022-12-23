package Programmers;

public class LCM {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1}));
    }

    public static int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int lcm = arr[0] * arr[1] / gcd(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            lcm = lcm * arr[i] / gcd(lcm, arr[i]);
        }

        return lcm;
    }

    private static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return gcd(b, r);
    }
}
