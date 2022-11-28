package Programmers;

import java.util.*;

public class PhoneBook_ArraysSortString {
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

    private static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        //String 의 비교는 compareTo 를 사용합니다. 내부적으로 두 문자열 중 길이가 작은 문자열의 길이까지 for 문으로 char 비교를 수행합니다.
        //반복문 중 값이 다르면 char 로 비교되고, 해당 길이까지 동등하다면 두 길이를 비교하는 방법입니다.
        // char 의 값은 a, b, c, d 알파벳순으로 나열되어 있습니다. 이에 String 은 알파벳순 비교 후 길이로 비교되므로 사전순으로 반환됩니다.
        // 여기서 정렬에 사용된 Arrays.sort(Object[] o) 에서도 compareTo 를 사용하도록 명시되어 Arrays.sort(String[] s) 는 사전순으로 정렬됩니다.
        // 즉 "12", "1223", "123", "13", "139", "140" 과 같은 순서이기에 직전의 값이 다음 값에 포함되지 않으면 그 다음값은 당연히 연속된 문자가 아닙니다.

        for(int i=0; i<phoneBook.length-1;i++)
        {
            if(phoneBook[i+1].startsWith(phoneBook[i])) {return false;}
        }
        return true;
    }
}
