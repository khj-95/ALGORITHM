package Programmers;

import java.util.*;

public class SameNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[]{4, 4, 4, 3, 3})));
    }

    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int n : arr) {
            if (!stack.isEmpty() && stack.peek() == n) {
                continue;
            }
            stack.push(n);
        }

        int[] answer = new int[stack.size()];
        for (int i = answer.length-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
