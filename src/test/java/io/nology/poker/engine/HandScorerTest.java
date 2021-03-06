package io.nology.poker.engine;

import io.nology.poker.engine.Hand;
import io.nology.poker.engine.HandScorer;
import org.junit.Test;
import static io.nology.poker.engine.HandScorer.HandType.*;

import static org.junit.Assert.*;

public class HandScorerTest {

    @Test
    public void scoreHand() {
        int twoPair = HandScorer.scoreHand("AD KS 3D 3D AD");
        int royalFlush = HandScorer.scoreHand("10D AD KD JD QD");
        int worseTwoPair = HandScorer.scoreHand("7D KS 3D 3D 7D");
        int straightFlush = HandScorer.scoreHand("10D 9D KD JD QD");
        int fourOfAKind = HandScorer.scoreHand("10S AD 10C 10H 10D");
        int fullHouse = HandScorer.scoreHand("10S 7D 10C 10H 7C");
        int flush = HandScorer.scoreHand("2D AD KD JD QD");
        int straight = HandScorer.scoreHand("2S 5D 4D 3D 6D");
        int threeOfAKind = HandScorer.scoreHand("10C 10D KD 10D QD");
        int pair = HandScorer.scoreHand("10C 10D KD JD QD");
        int highCard = HandScorer.scoreHand("10D 2C KD 5D QD");
        int slightlyBetterHighCard = HandScorer.scoreHand("10D 3C KD 5D QD");

        assertTrue(royalFlush > straightFlush);
        assertTrue(straightFlush > fourOfAKind);
        assertTrue(fourOfAKind > fullHouse);
        assertTrue(fullHouse > flush);
        assertTrue(flush > straight);
        assertTrue(straight > threeOfAKind);
        assertTrue(threeOfAKind > twoPair);
        assertTrue(twoPair > pair);
        assertTrue(pair > highCard);

        assertTrue(twoPair > worseTwoPair);
        assertTrue(slightlyBetterHighCard > highCard);
    }

    @Test
    public void getHandType() {
        assertEquals(TWO_PAIR, HandScorer.getHandType(new Hand("AD KS 3D 3D AD")));
        assertEquals(ROYAL_FLUSH, HandScorer.getHandType(new Hand("10D AD KD JD QD")));
        assertEquals(STRAIGHT_FLUSH, HandScorer.getHandType(new Hand("10D 9D KD JD QD")));
        assertEquals(FOUR_OF_A_KIND, HandScorer.getHandType(new Hand("10S AD 10C 10H 10D")));
        assertEquals(FULL_HOUSE, HandScorer.getHandType(new Hand("10S 7D 10C 10H 7C")));
        assertEquals(FLUSH, HandScorer.getHandType(new Hand("2D AD KD JD QD")));
        assertEquals(STRAIGHT, HandScorer.getHandType(new Hand("2S 5D 4D 3D 6D")));
        assertEquals(THREE_OF_A_KIND, HandScorer.getHandType(new Hand("10C 10D KD 10D QD")));
        assertEquals(TWO_PAIR, HandScorer.getHandType(new Hand("10D AC KD 10S KC")));
        assertEquals(PAIR, HandScorer.getHandType(new Hand("10C 10D KD JD QD")));
        assertEquals(HIGH_CARD, HandScorer.getHandType(new Hand("10D 2C KD 5D QD")));
    }

    @Test
    public void getScoreNegativeTest() {
        assertEquals(0, HandScorer.scoreHand("hgjhdgsagdhsa"));
        assertEquals(0, HandScorer.scoreHand("10D 2C KD 5D"));
        assertEquals(0, HandScorer.scoreHand("10D 2C KD 5D 3C 5C"));
    }
}