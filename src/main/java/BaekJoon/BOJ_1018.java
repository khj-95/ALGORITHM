package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1018 {
	private static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bufferedReader.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		// W: true, B: false
		map = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String data = bufferedReader.readLine();
			for (int j = 0; j < m; j++) {
				if(data.charAt(j) == 'W'){
					map[i][j] = true;
				}
			}
		}

		int min = 100;

		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				min = Math.min(min, countStart(i,j));
				min = Math.min(min, countStart(i,j));
			}
		}

		System.out.println(min);
	}

	private static int countStart(int n, int m) {
		int countW = 0;
		int countB = 0;
		boolean[] white = new boolean[] {true, false, true, false, true, false, true, false};
		boolean[] black = new boolean[] {false, true, false, true, false, true, false, true};

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(i%2 == 0){
					if(map[i + n][j + m] != white[j]){
						countW++;
					}
					if(map[i + n][j + m] != black[j]){
						countB++;
					}
					continue;
				} else {
					if(map[i + n][j + m] != black[j]){
						countW++;
					}
					if(map[i + n][j + m] != white[j]){
						countB++;
					}
				}
			}
		}
		return Math.min(countW,countB);
	}
}
