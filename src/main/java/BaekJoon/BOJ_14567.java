package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_14567 {
    private static int[] inDegree;
    private static Set<Integer>[] nextSubjects;
    private static int[] minimumSemester;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        inDegree = new int[n + 1];
        nextSubjects = new HashSet[n + 1];
        minimumSemester = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nextSubjects[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int advanced = Integer.parseInt(st.nextToken());
            int later = Integer.parseInt(st.nextToken());
            nextSubjects[advanced].add(later);
            inDegree[later] += 1;
        }

        topologicalSort();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < minimumSemester.length; i++) {
            bw.write(minimumSemester[i] + " ");
        }
        bw.flush();
    }

    private static void topologicalSort() {
        Queue<Integer[]> q = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(new Integer[]{i, 1});
            }
        }

        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            int subject = now[0];
            int semester = now[1];
            minimumSemester[subject] = semester;
            if (nextSubjects[subject].size() == 0) {
                continue;
            }
            for (Integer next : nextSubjects[subject]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(new Integer[]{next, semester + 1});
                }
            }
        }
    }
}
