package Programmers;

import java.util.Arrays;

public class NumberK_Quick {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{
                {2, 5, 3},{4, 4, 1},{1, 7, 3}
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

            if (size > 1) {
                sort(0, size - 1, newArray);
            }

            answer[n] = newArray[k];
        }
        return answer;
    }

    private static void sort(int start, int end, int[] array) {
        int left = start;
        int right = end;
        int pivot = array[start + start / end];

        while (left < right) {
            while (left <= end && array[left] < pivot) {
                left++;
            }

            while (right >= left && array[right] > pivot) {
                right--;
            }

            if (left == right) {
                left++;
                continue;
            }

            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }

        if (right - 1 > start) {
            sort(start, right - 1, array);
        }
        if (right + 1 < end) {
            sort(right + 1, end, array);
        }
    }

    void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
}
