package Programmers;

import java.util.Arrays;

public class NumberBlock {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(1, 10)));
	}

	public static int[] solution(long begin, long end) {

		long size = end - begin + 1;
		int[] answer = new int[(int)size];

		int idx = 0;

		for (long i = begin; i <= end; i++) {
			if (i == 1) {
				answer[idx] = 0;
				idx++;
				continue;
			}
			long j = 2;
			while (i % j != 0) {
				j++;
			}
			answer[idx] = (int)(i / (int)j);
			idx++;
		}

		return answer;
	}
}
