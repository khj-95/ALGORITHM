package Programmers;

import java.util.Arrays;

public class NumberK {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{
                {2, 5, 3}, {4, 4, 1}, {1, 7, 3}
        };
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int n = 0; n < commands.length; n++) {
            int[] info = commands[n];
            int i = info[0] - 1;
            int j = info[1];
            int k = info[2] - 1;
            int size = j - i;

            int[] newArray = new int[size];

            for (int l = 0; l < size; l++) {
                newArray[l] = array[i + l];
            }

            Arrays.sort(newArray);

            answer[n] = newArray[k];
        }
        return answer;
    }
}
