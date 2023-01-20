package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bufferedReader.readLine());

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			String[] input = bufferedReader.readLine().split(" ");
			if (input.length == 2) {
				stack.push(Integer.valueOf(input[1]));
				continue;
			}

			switch (input[0]) {
				case "pop":
					if (stack.isEmpty()) {
						bufferedWriter.write(-1 + "\n");
					} else {
						bufferedWriter.write(stack.pop() + "\n");
					}
					break;
				case "size":
					bufferedWriter.write(stack.size() + "\n");
					break;
				case "empty":
					if (stack.isEmpty()) {
						bufferedWriter.write(1 + "\n");
					} else {
						bufferedWriter.write(0 + "\n");
					}
					break;
				case "top":
					if (stack.isEmpty()) {
						bufferedWriter.write(-1 + "\n");
					} else {
						bufferedWriter.write(stack.peek() + "\n");
					}
					break;
			}
		}
		bufferedWriter.flush();
	}
}
