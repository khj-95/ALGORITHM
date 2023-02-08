package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class FIleOrder {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
			solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
		System.out.println(Arrays.toString(
			solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
		System.out.println(Arrays.toString(
			solution(new String[] {"muzi1.txt", "MUZI1.txt", "muzi001.txt", "muzi1.TXT"})));

		System.out.println(Integer.parseInt("010"));
		System.out.println(Integer.parseInt("10"));
		System.out.println(Integer.parseInt("0"));
	}

	public static String[] solution(String[] files) {
		String[] answer = Arrays.stream(files).sorted(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String head1 = findHead(o1);
				String head2 = findHead(o2);
				if (head1.compareToIgnoreCase(head2) == 0) {
					Integer number1 = findNumber(o1);
					Integer number2 = findNumber(o2);
					if (number1 == number2) {
						return 1;
					}
					return number1 - number2;
				}

				return head1.compareToIgnoreCase(head2);
			}

			private String findHead(String str) {
				for (int i = 0; i < str.length(); i++) {
					if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
						return str.substring(0, i);
					}
				}
				return str;
			}

			private Integer findNumber(String str) {
				int start = -1;
				int last = str.length();
				for (int i = 0; i < str.length(); i++) {
					if (start == -1) {
						if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
							start = i;
						}
					} else {
						if ('0' > str.charAt(i) || str.charAt(i) > '9') {
							last = i;
							break;
						}
					}
				}
				return Integer.parseInt(str.substring(start, last));
			}
		}).toArray(String[]::new);

		return answer;
	}
}
