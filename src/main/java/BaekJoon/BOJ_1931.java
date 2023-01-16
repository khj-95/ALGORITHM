package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1931 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bufferedReader.readLine());

		int[][] se = new int[N][2];

		for (int i = 0; i < N; i++) {
			String[] input = bufferedReader.readLine().split(" ");
			se[i][0] = Integer.parseInt(input[0]);
			se[i][1] = Integer.parseInt(input[1]);
		}

		Arrays.sort(se, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}

				return o1[1] - o2[1];
			}

		});

		int count = 0;
		int prevEnd = 0;

		for (int i = 0; i < N; i++) {
			if (prevEnd <= se[i][0]) {
				prevEnd = se[i][1];
				count++;
			}
		}

		System.out.println(count);
	}
}