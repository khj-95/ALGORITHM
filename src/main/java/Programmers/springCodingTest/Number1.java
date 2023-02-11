package Programmers.springCodingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Number1 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{100, 100, 500}, {1000, 100, 100}}));
		System.out.println(solution(new int[][] {{10, 19, 800}, {20, 39, 200}, {100, 199, 500}}));
		System.out.println(solution(new int[][] {{50, 1, 50}, {100, 199, 100}, {1, 1, 500}}));
	}

	public static int solution(int[][] lotteries) {

		List<Lottery> lotteryList = new ArrayList<>();

		for (int i = 0; i < lotteries.length; i++) {
			lotteryList.add(new Lottery(lotteries[i][0], lotteries[i][1], lotteries[i][2], i + 1));
		}

		Collections.sort(lotteryList, new Comparator<Lottery>() {
			@Override
			public int compare(Lottery o1, Lottery o2) {
				float o1OddsOfWinning = o1.calcOddsOfWinning();
				float o2OddsOfWinning = o2.calcOddsOfWinning();
				if (o1OddsOfWinning == o2OddsOfWinning) {
					return o2.prize - o1.prize;
				}
				if (o1OddsOfWinning - o2OddsOfWinning < 0) {
					return 1;
				}
				return -1;
			}
		});

		return lotteryList.get(0).idx;
	}

	static class Lottery {
		int idx;
		float winCount;
		float count;
		int prize;

		public Lottery(float winCount, float count, int prize, int idx) {
			this.winCount = winCount;
			this.count = count;
			this.prize = prize;
			this.idx = idx;
		}

		public float calcOddsOfWinning() {
			if (count + 1 <= winCount) {
				return 1;
			}
			return winCount / (count + 1);
		}
	}
}
