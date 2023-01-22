package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class BOJ_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = bufferedReader.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		Map<Integer, String> hash = new HashMap<>();
		Map<String, Integer> hash2 = new HashMap<>();
		for (int i = 1; i < n + 1; i++) {
			String name = bufferedReader.readLine();
			hash.put(i, name);
			hash2.put(name, i);
		}

		for (int i = 0; i < m; i++) {
			String input2 = bufferedReader.readLine();
			if (isNumber(input2.charAt(0))) {
				bufferedWriter.write(hash.get(Integer.parseInt(input2)) + "\n");
				continue;
			}
			bufferedWriter.write(hash2.get(input2) + "\n");
		}
		bufferedWriter.flush();
	}

	private static boolean isNumber(char ch) {
		return ch >= '0' && ch <= '9';
	}
}
