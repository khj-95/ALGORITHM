package Programmers;

import java.util.*;

public class MaxNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
    }

    public static String solution(int[] numbers) {
        List<String> numberList = new LinkedList<>();

        for (int n : numbers) {
            numberList.add(String.valueOf(n));
        }

        Collections.sort(numberList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return Integer.parseInt(o1) - Integer.parseInt(o2);
                }


                return 0;
            }
        });



        StringBuilder sb = new StringBuilder();
        for (String n : numberList) {
            sb.append(n);
        }

        return sb.toString();
    }
}
