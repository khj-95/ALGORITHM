package Programmers.springCodingTest;

import java.util.LinkedList;
import java.util.Queue;

public class Number2 {
	public static void main(String[] args) {
		System.out.println(solution(new String[]{".....####","..#...###",".#.##..##","..#..#...","..#...#..","...###..."}));
	}

	public static int solution(String[] grid) {
		int answer = 0;
		int[] dn = {1, 0, -1, 0};
		int[] dm = {0, 1, 0, -1};

		boolean[][] gridArray = new boolean[grid.length][grid[0].length()];
		boolean[][] visited = new boolean[grid.length][grid[0].length()];
		Queue<Point> queue = new LinkedList<>();

		for (int i = 0; i < grid.length; i++) {
			String str = grid[i];
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '#') {
					gridArray[i][j] = true;
					continue;
				}
				if(i == 0){
					queue.add(new Point(i,j));
					visited[i][j] = true;
				}
				if(i == grid.length - 1){
					queue.add(new Point(i, j));
					visited[i][j] = true;
				}
				if(j == 0){
					queue.add(new Point(i,j));
					visited[i][j] = true;
				}
				if(j == str.length() - 1){
					queue.add(new Point(i,j));
					visited[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int mn = now.n + dn[i];
				int mm = now.m + dm[i];
				if (0 > mn || mn >= gridArray.length || 0 > mm || mm >= gridArray[0].length) {
					continue;
				}
				if (!gridArray[mn][mm] && !visited[mn][mm]) {
					queue.add(new Point(mn, mm));
					visited[mn][mm] = true;
				}
			}
		}

		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				if (!visited[i][j]) {
					answer++;
				}
			}
		}

		return answer;
	}

	static class Point {
		int n;
		int m;

		public Point(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}
}
