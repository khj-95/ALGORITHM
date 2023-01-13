package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9935_2 {
	private static String input;
	private static String bomb;
	private static StringBuilder stringBuilder;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		input = bufferedReader.readLine();
		bomb = bufferedReader.readLine();
		stringBuilder = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			stringBuilder.append(input.charAt(i));

			if (stringBuilder.length() >= bomb.length()) {
				if (isBomb()) {
					for (int j = 0; j < bomb.length(); j++) {
						stringBuilder.deleteCharAt(stringBuilder.length() - 1);
					}
				}
			}
		}

		if (stringBuilder.length() == 0) {
			stringBuilder.append("FRULA");
		}

		System.out.println(stringBuilder);

	}

	private static boolean isBomb() {
		int start = stringBuilder.length() - bomb.length();
		for (int i = 0; i < bomb.length(); i++) {
			if (bomb.charAt(i) != stringBuilder.charAt(start + i)) {
				return false;
			}
		}
		return true;
	}
}
