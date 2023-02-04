package Programmers;

public class Number124 {
	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));

		System.out.println(solution(6));
		System.out.println(solution(7));
		System.out.println(solution(8));
		System.out.println(solution(9));
		System.out.println(solution(10));
	}

	public static String solution(int n) {
		StringBuilder answer = new StringBuilder();
		int[] numbers = new int[] {1,2,4};

		while (n > 0) {
			int index = n % 3 == 0 ? 2 : n % 3 - 1;
			n /= 3;

			if(index == 2){
				n--;
			}
			answer.append(numbers[index]);
		}

		return answer.reverse().toString();
	}
}
