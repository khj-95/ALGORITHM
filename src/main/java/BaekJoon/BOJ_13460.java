package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460 {
	static int n, m;
	static char[][] board;
	static int[][][][] count;
	static int[] dn = {1, -1, 0, 0};
	static int[] dm = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		count = new int[n][m][n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < m; l++) {
						count[i][j][k][l] = 100;
					}
				}
			}
		}

		int rn = 0, rm = 0;
		int bn = 0, bm = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				char ch = str.charAt(j);
				if (ch == 'R') {
					ch = '.';
					rn = i;
					rm = j;
				}
				if (ch == 'B') {
					ch = '.';
					bn = i;
					bm = j;
				}
				board[i][j] = ch;
			}
		}

		System.out.println(bfs(rn, rm, bn, bm));
	}

	static int bfs(int rn, int rm, int bn, int bm) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {rn, rm, bn, bm});
		count[rn][rm][bn][bm] = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (count[now[0]][now[1]][now[2]][now[3]] >= 10) {
				return -1;
			}

			for (int i = 0; i < 4; i++) {
				int nowRn = now[0];
				int nowRm = now[1];
				int nowBn = now[2];
				int nowBm = now[3];

				// 빨간 구슬 이동
				while (board[nowRn + dn[i]][nowRm + dm[i]] != '#') {
					nowRn += dn[i];
					nowRm += dm[i];
					if (board[nowRn][nowRm] == 'O') {
						break;
					}
				}

				// 파란 구슬 이동
				while (board[nowBn + dn[i]][nowBm + dm[i]] != '#') {
					nowBn += dn[i];
					nowBm += dm[i];
					if (board[nowBn][nowBm] == 'O') {
						break;
					}
				}

				// 파란 구슬이 구멍에 들어갔을 때
				if (board[nowBn][nowBm] == 'O') {
					continue;
				}

				if (board[nowRn][nowRm] == 'O') {
					return count[now[0]][now[1]][now[2]][now[3]] + 1;
				}

				// 빨간 파랑 서로 만났을 때
				if (nowRn == nowBn && nowRm == nowBm && board[nowRn][nowRm] != 'O') {
					int redMove = Math.abs(nowRn - now[0]) + Math.abs(nowRm - now[1]);
					int blueMove = Math.abs(nowBn - now[2]) + Math.abs(nowBm - now[3]);

					// 파란 공이 더 빨리 도착한 경우
					if (redMove > blueMove) {
						nowRn -= dn[i];
						nowRm -= dm[i];
					} else { // 빨간 공이 더 빨리 도착한 경우
						nowBn -= dn[i];
						nowBm -= dm[i];
					}
				}

				if (count[now[0]][now[1]][now[2]][now[3]] + 1 < count[nowRn][nowRm][nowBn][nowBm]) {
					count[nowRn][nowRm][nowBn][nowBm] = count[now[0]][now[1]][now[2]][now[3]] + 1;
					q.add(new int[] {nowRn, nowRm, nowBn, nowBm});
				}
			}
		}
		return -1;
	}
}
