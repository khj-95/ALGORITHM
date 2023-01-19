package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FollowUP {
	public static void main(String[] args) {
		System.out.println(
			Arrays.toString(solution(3,
				new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));

		System.out.println(Arrays.toString(solution(5,
			new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
				"establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));

		System.out.println(
			Arrays.toString(solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"})));

	}

	public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int count = 0;
		Character lastWord = null;
		Map<Character, List<String>> hashWords = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			String now = words[i];
			char first = now.charAt(0);
			count++;
			if (Objects.nonNull(lastWord) && lastWord != first) {
				return answer(n, answer, count);
			}
			if (!hashWords.containsKey(first)) {
				List<String> list = new ArrayList<>();
				list.add(words[i]);
				hashWords.put(first, list);
				lastWord = now.charAt(now.length() - 1);
				continue;
			}

			if (hashWords.get(first).contains(now)) {
				return answer(n, answer, count);
			}

			hashWords.get(first).add(now);
			lastWord = words[i].charAt(now.length() - 1);
		}

		return new int[] {0, 0};
	}

	private static int[] answer(int n, int[] answer, int count) {
		answer[0] = count % n == 0 ? n : count % n;
		answer[1] = (int)Math.ceil(count / (float)n);
		return answer;
	}
}
