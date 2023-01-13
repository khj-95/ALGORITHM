package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
	private static String input;
	private static String bomb;
	private static Stack<Character> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		input = bufferedReader.readLine();
		bomb = bufferedReader.readLine();

		StringBuilder stringBuilder = new StringBuilder();
		stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));

			if (stack.size() >= bomb.length()) {
				if (isBomb()) {
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		for (Character ch : stack) {
			stringBuilder.append(ch);
		}

		if (stringBuilder.length() == 0) {
			stringBuilder.append("FRULA");
		}

		System.out.println(stringBuilder);

	}

	private static boolean isBomb() {
		int start = stack.size() - bomb.length();
		for (int i = 0; i < bomb.length(); i++) {
			if (bomb.charAt(i) != stack.get(start + i)) {
				return false;
			}
		}
		return true;
	}
}
