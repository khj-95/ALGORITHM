package Programmers;

public class Number {
	public static void main(String[] args) {
		System.out.println(solution(2, 4, 2, 1));
		System.out.println(solution(16,16,2,1));
		System.out.println(solution(16,16,2,2));
	}

	public static String solution(int n, int t, int m, int p) {
		String total = "0";
		int i = 1;
		while (total.length() <= t * m) {
			total += conversion(i, n);
			i++;

		}

		String answer = "";

		for (int j = 0; j < t; j++) {
			answer += total.charAt(p - 1 + m * j);
		}

		return answer;
	}

	public static String conversion(int number, int n) {
		StringBuilder sb = new StringBuilder();
		int current = number;

		while (current > 0) {
			if (current % n < 10) {
				sb.append(current % n);
			} else {
				sb.append((char)(current % n - 10 + 'A'));
			}
			current /= n;
		}
		return sb.reverse().toString();
	}
}
