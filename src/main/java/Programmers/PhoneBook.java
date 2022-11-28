package Programmers;

import java.util.*;

public class PhoneBook {
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
        for (String number : phone_book) {
            numbers[number.length()].add(number);
        }
        for (int i = 0; i < phone_book.length; i++) {
            String phoneNumber = phone_book[i];
            int size = Math.min(numbers.length, phoneNumber.length());
            for (int j = 1; j < size; j++) {
                String temp = phoneNumber.substring(0, j);
                if (numbers[j].contains(temp)) {
                    return false;
                }
            }
        }
        return answer;
    }
}
