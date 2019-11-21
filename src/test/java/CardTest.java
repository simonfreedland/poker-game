import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void constructCardWithStrings() {
        Card card = new Card("9C");
        assertEquals(Card.CardType.NINE, card.getType());
        assertEquals(Card.Suit.CLUBS, card.getSuit());
        assertTrue(card.isValidCard());

        card = new Card("10D");
        assertEquals(Card.CardType.TEN, card.getType());
        assertEquals(Card.Suit.DIAMONDS, card.getSuit());
        assertTrue(card.isValidCard());

        card = new Card("15D");
        assertFalse(card.isValidCard());

        card = new Card("9F");
        assertFalse(card.isValidCard());

        card = new Card("asdsadsa");
        assertFalse(card.isValidCard());
    }

    @Test
    public void getValue() {
        Card card = new Card(Card.Suit.CLUBS, Card.CardType.ACE);
        assertEquals(card.getValue(), 14);
        card = new Card(Card.Suit.CLUBS, Card.CardType.KING);
        assertEquals(card.getValue(), 13);
        card = new Card(Card.Suit.CLUBS, Card.CardType.QUEEN);
        assertEquals(card.getValue(), 12);
        card = new Card(Card.Suit.CLUBS, Card.CardType.JACK);
        assertEquals(card.getValue(), 11);
        card = new Card(Card.Suit.CLUBS, Card.CardType.TEN);
        assertEquals(card.getValue(), 10);
        card = new Card(Card.Suit.CLUBS, Card.CardType.NINE);
        assertEquals(card.getValue(), 9);
        card = new Card(Card.Suit.CLUBS, Card.CardType.EIGHT);
        assertEquals(card.getValue(), 8);
        card = new Card(Card.Suit.CLUBS, Card.CardType.SEVEN);
        assertEquals(card.getValue(), 7);
        card = new Card(Card.Suit.CLUBS, Card.CardType.SIX);
        assertEquals(card.getValue(), 6);
        card = new Card(Card.Suit.CLUBS, Card.CardType.FIVE);
        assertEquals(card.getValue(), 5);
        card = new Card(Card.Suit.CLUBS, Card.CardType.FOUR);
        assertEquals(card.getValue(), 4);
        card = new Card(Card.Suit.CLUBS, Card.CardType.THREE);
        assertEquals(card.getValue(), 3);
        card = new Card(Card.Suit.CLUBS, Card.CardType.TWO);
        assertEquals(card.getValue(), 2);
    }

    @Test
    public void getCardTypeValue() {
        Card card = new Card(Card.Suit.CLUBS, Card.CardType.ACE);
        assertEquals(card.getType().getValue(), 14);
        card = new Card(Card.Suit.CLUBS, Card.CardType.KING);
        assertEquals(card.getType().getValue(), 13);
        card = new Card(Card.Suit.CLUBS, Card.CardType.QUEEN);
        assertEquals(card.getType().getValue(), 12);
        card = new Card(Card.Suit.CLUBS, Card.CardType.JACK);
        assertEquals(card.getType().getValue(), 11);
        card = new Card(Card.Suit.CLUBS, Card.CardType.TEN);
        assertEquals(card.getType().getValue(), 10);
        card = new Card(Card.Suit.CLUBS, Card.CardType.NINE);
        assertEquals(card.getType().getValue(), 9);
        card = new Card(Card.Suit.CLUBS, Card.CardType.EIGHT);
        assertEquals(card.getType().getValue(), 8);
        card = new Card(Card.Suit.CLUBS, Card.CardType.SEVEN);
        assertEquals(card.getType().getValue(), 7);
        card = new Card(Card.Suit.CLUBS, Card.CardType.SIX);
        assertEquals(card.getType().getValue(), 6);
        card = new Card(Card.Suit.CLUBS, Card.CardType.FIVE);
        assertEquals(card.getType().getValue(), 5);
        card = new Card(Card.Suit.CLUBS, Card.CardType.FOUR);
        assertEquals(card.getType().getValue(), 4);
        card = new Card(Card.Suit.CLUBS, Card.CardType.THREE);
        assertEquals(card.getType().getValue(), 3);
        card = new Card(Card.Suit.CLUBS, Card.CardType.TWO);
        assertEquals(card.getType().getValue(), 2);
    }

}