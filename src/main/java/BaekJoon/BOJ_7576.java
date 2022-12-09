package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_7576 {
    private static int[][] box;
    private static int[][] visited;
    private static int[] dm = new int[]{1, 0, -1, 0};
    private static int[] dn = new int[]{0, 1, 0, -1};
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        box = new int[M][N];
        visited = new int[M][N];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(data[j]);
                if (box[i][j] == 1) {
                    visited[i][j] = 1;
                    q.add(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs(q));
    }

    private static int bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int m = now[0];
            int n = now[1];
            for (int i = 0; i < 4; i++) {
                int nm = m + dm[i];
                int nn = n + dn[i];
                if (isValidMN(nm, nn) && box[nm][nn] == 0) {
                    visited[nm][nn] = visited[m][n] + 1;
                    box[nm][nn] = 1;
                    q.add(new int[]{nm, nn});
                }
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
                if (count < visited[i][j]) {
                    count = visited[i][j];
                }
            }
        }
        return count - 1;
    }

    private static boolean isValidMN(int nm, int nn) {
        return nm >= 0 && nm < M && nn >= 0 && nn < N;
    }
}
