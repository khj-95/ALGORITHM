package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bufferedReader.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		Queue<Integer> q = new LinkedList<>();
		List<Integer> res = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		int j = 1;
		while (!q.isEmpty()) {
			while (j != k) {
				q.add(q.poll());
				j++;
			}
			res.add(q.poll());
			j = 1;
		}

		String str = Arrays.toString(res.toArray());
		str = str.replace("[", "<");
		str = str.replace("]", ">");
		System.out.println(str);
	}
}
