package Programmers;

import java.util.*;

public class PhoneBook_Sort {
    public static void main(String[] args) {
        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
        phone_book = new String[]{"123", "456", "789"};
        System.out.println(solution(phone_book));
        phone_book = new String[]{"12", "123", "1235", "567", "88"};
        System.out.println(solution(phone_book));
        phone_book = new String[]{"1195524421", "97674223", "119"};
        System.out.println(solution(phone_book));
    }

    private static boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String>[] numbers = new HashSet[21];
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = new HashSet<>();
        }
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < phone_book.length; i++) {
            String phoneNumber = phone_book[i];
            for (int j = 1; j < phoneNumber.length(); j++) {
                String temp = phoneNumber.substring(0, j);
                if (numbers[j].contains(temp)) {
                    return false;
                }
            }
            numbers[phoneNumber.length()].add(phoneNumber);
        }
        return answer;
    }
}
