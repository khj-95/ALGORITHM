package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bufferedReader.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(bufferedReader.readLine());
			if (now == 0) {
				if (queue.isEmpty()) {
					bufferedWriter.write(now + "\n");
					continue;
				}
				bufferedWriter.write(queue.poll() + "\n");
				continue;
			}
			queue.add(now);
		}
		bufferedWriter.flush();
	}
}
