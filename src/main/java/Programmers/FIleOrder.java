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
		System.out.println(Arrays.toString(
			solution(new String[] {"MUZI01", "muzi1"})));
	}

	public static String[] solution(String[] files) {
		String[] answer = Arrays.stream(files).sorted(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String[] headNumberTail1 = findHeadNumberTail(o1);
				String[] headNumberTail2 = findHeadNumberTail(o2);
				if (headNumberTail1[0].compareToIgnoreCase(headNumberTail2[0]) == 0) {
					return Integer.parseInt(headNumberTail1[1]) - Integer.parseInt(headNumberTail2[1]);
				}

				return headNumberTail1[0].compareToIgnoreCase(headNumberTail2[0]);
			}

			private String[] findHeadNumberTail(String str) {
				String[] headNumberTail = new String[3];
				int start = 0;
				int last = str.length();
				for (int i = 0; i < str.length(); i++) {
					if (start == 0) {
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

				headNumberTail[0] = str.substring(0, start);
				headNumberTail[1] = str.substring(start,last);
				headNumberTail[2] = str.substring(last);

				return headNumberTail;
			}
		}).toArray(String[]::new);

		return answer;
	}
}
