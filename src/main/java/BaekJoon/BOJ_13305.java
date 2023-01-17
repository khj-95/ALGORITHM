package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		int[] length = new int[n - 1];
		int[] costs = new int[n];

		String[] input = bufferedReader.readLine().split(" ");
		for (int i = 0; i < n - 1; i++) {
			length[i] = Integer.parseInt(input[i]);
		}

		String[] input2 = bufferedReader.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			costs[i] = Integer.parseInt(input2[i]);
		}

		Long total = 0L;
		Long cost = (long)costs[0];

		for (int i = 0; i < n - 1; i++) {
			if (costs[i] < cost) {
				cost = (long)costs[i];
			}
			total += cost * length[i];
		}

		System.out.println(total);

	}
}
