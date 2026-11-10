package models;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void canInitialiseCard() {
        Card card = new Card(CardType.HEARTS, CardNumber.ACE);
        assertEquals("Type: HEARTS\nNumber: ACE", card.toString());
    }

    @Test
    public void initialisingCardWithNullThrowsException() {
        assertThrows(NullPointerException.class, () ->
                new Card(null, CardNumber.ACE));

        assertThrows(NullPointerException.class, () ->
                new Card(CardType.HEARTS, null));

        assertThrows(NullPointerException.class, () ->
                new Card(null, null));
    }

    @Test
    public void getMethodsShouldReturnExpectedOutput() {
        Card card = new Card(CardType.HEARTS, CardNumber.ACE);
        assertAll(
                () -> {assertEquals(CardType.HEARTS, card.getType());},
                () -> {assertEquals(CardNumber.ACE, card.getNumber());}
        );
    }

    @Test
    public void cardEqualsShouldReturnTrueIfCardsMatch() {
        Card c1 = new Card(CardType.HEARTS, CardNumber.ACE);
        Card c2 = new Card(CardType.HEARTS, CardNumber.ACE);
        Card c3 = new Card(CardType.CLUBS, CardNumber.ACE);

        assertAll(
                () -> {assertTrue(c1.equals(c2));},
                () -> {assertFalse(c1.equals(c3));}
        );

    }
}
