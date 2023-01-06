package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_11437 {
	private static List<Integer>[] connections;
	private static Node[] pd;
	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		connections = new ArrayList[N + 1];
		pd = new Node[N + 1];

		for (int i = 1; i <= N; i++) {
			connections[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			connections[a].add(b);
			connections[b].add(a);
		}

		setParentAndDepth();

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int lca = findLCA(a, b);
			bw.write(lca + "\n");
		}
		bw.flush();
	}

	private static int findLCA(int a, int b) {
		if (pd[a].depth > pd[b].depth) {
			while (pd[a].depth != pd[b].depth) {
				a = pd[a].parent;
			}
		} else {
			while (pd[a].depth != pd[b].depth) {
				b = pd[b].parent;
			}
		}

		while (a != b) {
			a = pd[a].parent;
			b = pd[b].parent;
		}

		return a;
	}

	private static void setParentAndDepth() {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);

		pd[1] = new Node(0, 1);
		visited[0] = true;
		visited[1] = true;

		while (!q.isEmpty()) {
			int now = q.poll();
			List<Integer> conn = connections[now];
			if (conn.size() == 0) {
				continue;
			}
			for (Integer next : conn) {
				if (visited[next]) {
					continue;
				}
				visited[next] = true;
				pd[next] = new Node(now, pd[now].depth + 1);
				q.add(next);
			}
		}
	}

	private static class Node {
		private int parent;
		private int depth;

		public Node(int parent, int depth) {
			this.parent = parent;
			this.depth = depth;
		}
	}
}
