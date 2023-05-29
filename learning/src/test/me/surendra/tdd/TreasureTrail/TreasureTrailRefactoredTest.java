package me.surendra.tdd.TreasureTrail;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class TreasureTrailRefactoredTest {
	static final int BLACK_PRICE = 1;
	static final int WHITE_PRICE = 2;

	public static class PossibleFinalAmountsTest {
		TreasureTrail trail = null;

		@Before
		public void setup() {
			this.trail = new TreasureTrail(BLACK_PRICE, WHITE_PRICE);
		}

		@Test
		public void possibleWorthShouldBeZeroIfNoStoneCollected() {
			assertEquals(setOf(0), trail.possibleWorth(0));
		}

		@Test
		public void possibleWorthShouldBePriceOfStonesIfOnlyOneStoneCollected() {
			assertEquals(setOf(BLACK_PRICE, WHITE_PRICE), trail.possibleWorth(1));
		}

		@Test
		public void maxStones(){
			assertEquals(
					setOf(15, 19, 23, 27, 31, 35, 39, 43, 47, 51, 55, 59, 63, 67, 71, 75),
					new TreasureTrail(1,5).possibleWorth(15)
			);
		}
		@Test
		public void possibleWorthIfTwoStonesCollected() {
			Set<Integer> expectedResult = setOf(
					2 * BLACK_PRICE,
					BLACK_PRICE + WHITE_PRICE,
					2 * WHITE_PRICE
			);
			assertEquals(expectedResult, trail.possibleWorth(2));
		}

		private static Set<Integer> setOf(Integer... arr) {
			return new TreeSet<>(Arrays.asList(arr));
		}
	}

	public static class StoneBagTest {

		StoneBag bag = null;

		@Before
		public void setup() {
			this.bag = new StoneBag(BLACK_PRICE, WHITE_PRICE);
		}

		@Test
		public void amountForNoStoneShouldBeZero() {
			assertEquals(0, bag.worthOfStones());
		}

		@Test
		public void amountForASingleStoneShouldBeEqualToThePriceOfThatStone() {
			assertEquals(BLACK_PRICE, bag.collectBlack(1).worthOfStones());
			assertEquals(WHITE_PRICE, bag.collectWhite(1).worthOfStones());
		}


		@Test
		public void amountForOneWhiteAndOneBlackStoneShouldBeEqualToTheSum() {
			assertEquals(BLACK_PRICE + WHITE_PRICE, bag.collectBlack(1).collectWhite(1).worthOfStones());
		}

	}

	static class StoneBag {
		private final int priceOfBlack;
		private final int priceOfWhite;

		private int blackStoneCount;
		private int whiteStoneCount;

		public StoneBag(int priceOfBlack, int priceOfWhite) {
			this.priceOfBlack = priceOfBlack;
			this.priceOfWhite = priceOfWhite;
		}

		public StoneBag collectBlack(int blackStoneCount) {
			this.blackStoneCount = blackStoneCount;
			return this;
		}

		public StoneBag collectWhite(int whiteStoneCount) {
			this.whiteStoneCount = whiteStoneCount;
			return this;
		}

		public int worthOfStones() {
			// return 0;
			// return priceOfBlack;
			// return priceOfBlack + priceOfWhite;
			return blackStoneCount * priceOfBlack + whiteStoneCount * priceOfWhite;
		}
	}

	static class TreasureTrail {

		private final StoneBag bag;

		public TreasureTrail(int priceOfBlack, int priceOfWhite) {
			this.bag = new StoneBag(priceOfBlack, priceOfWhite);
		}
//		// Solution using Java8 Streams ...
//		private Set<Integer> possibleWorth(int totalStones) {
//			return IntStream.rangeClosed(0, totalStones).boxed()
//					.map(i -> bag.collectBlack(i).collectWhite(totalStones - i).worthOfStones())
//					.collect(Collectors.toSet());
//		}

		private Set<Integer> possibleWorth(int totalStones) {
			// return 0;
			// return (totalStones == 0) ? setOf(0) : setOf(priceOfBlack, priceOfWhite);
			ArrayList<Integer> possibleAmounts = new ArrayList<>();
			for (int i = 0; i <= totalStones; i++) {
				possibleAmounts.add(bag.collectBlack(i).collectWhite(totalStones - i).worthOfStones());
			}
			return new TreeSet<>(possibleAmounts);
		}

	}
}
