package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_2580 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] game = new int[9][9];
    static PriorityQueue<int[]> q;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < 9; i++) {
            String[] rows = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                game[i][j] = Integer.parseInt(rows[j]);
                if (game[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        dfs(q.poll());
    }

    static void dfs(int[] point) throws IOException {
        int r = point[0];
        int c = point[1];
        for (int i = 1; i < 10; i++) {
            if (isPossible(r, c, i)) {
                game[r][c] = i;

                if (q.isEmpty()) {
                    print();
                    System.exit(0);
                }

                int[] temp = q.poll();
                dfs(temp);

                game[r][c] = 0;
                q.add(temp);
            }
        }
    }

    private static void print() throws IOException {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(game[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    // 백트래킹을 위한 유망성 검사 메소드
    static boolean isPossible(int row, int col, int n) {
        for (int i = 0; i < 9; i++) {
            if (game[row][i] == n) {
                return false;
            }
            if (game[i][col] == n) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (game[i][j] == n)
                    return false;
            }
        }

        return true;
    }
}