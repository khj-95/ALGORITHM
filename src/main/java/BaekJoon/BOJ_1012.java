package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1012 {
	private static boolean[][] lettuces;
	private static boolean[][] visited;
	private static int[] dn = {-1, 0, 1, 0};
	private static int[] dm = {0, -1, 0, 1};
	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < t; i++) {
			String[] mnk = bufferedReader.readLine().split(" ");
			M = Integer.parseInt(mnk[0]);
			N = Integer.parseInt(mnk[1]);
			int k = Integer.parseInt(mnk[2]);

			lettuces = new boolean[N][M];
			visited = new boolean[N][M];
			for (int j = 0; j < k; j++) {
				String[] xy = bufferedReader.readLine().split(" ");
				int x = Integer.parseInt(xy[0]);
				int y = Integer.parseInt(xy[1]);
				lettuces[y][x] = true;
			}

			int count = 0;
			for (int j = 0; j < N; j++) {
				for (int l = 0; l < M; l++) {
					if (visited[j][l] || !lettuces[j][l]) {
						continue;
					}
					dfs(j, l);
					count++;
				}
			}
			bufferedWriter.write(count + "\n");
		}
		bufferedWriter.flush();
	}

	private static void dfs(int n, int m) {
		visited[n][m] = true;
		for (int k = 0; k < 4; k++) {
			int nextN = n + dn[k];
			int nextM = m + dm[k];
			if (isValid(nextN, nextM) && !visited[nextN][nextM] && lettuces[nextN][nextM]) {
				dfs(nextN, nextM);
			}
		}
	}

	private static boolean isValid(int n, int m) {
		return 0 <= n && n < N && 0 <= m && m < M;
	}
}
