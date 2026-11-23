package models;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link Card}.
 */
public class CardTest {

    /** Tests that a card can be initialised. */
    @Test
    public void canInitialiseCard() {
        Card card = new Card(CardType.HEARTS, CardNumber.ACE);
        assertEquals("Type: HEARTS\nNumber: ACE", card.toString());
    }

    /** Tests that null card values are rejected. */
    @Test
    public void initialisingCardWithNullThrowsException() {
        assertThrows(NullPointerException.class, () ->
                new Card(null, CardNumber.ACE));

        assertThrows(NullPointerException.class, () ->
                new Card(CardType.HEARTS, null));

        assertThrows(NullPointerException.class, () ->
                new Card(null, null));
    }

    /** Tests that card accessors return their expected values. */
    @Test
    public void getMethodsShouldReturnExpectedOutput() {
        Card card = new Card(CardType.HEARTS, CardNumber.ACE);
        assertAll(
                () -> assertEquals(CardType.HEARTS, card.getType()),
                () -> assertEquals(CardNumber.ACE, card.getNumber())
        );
    }

    /** Tests that matching cards are equal and different cards are not. */
    @Test
    public void cardEqualsShouldReturnTrueIfCardsMatch() {
        Card c1 = new Card(CardType.HEARTS, CardNumber.ACE);
        Card c2 = new Card(CardType.HEARTS, CardNumber.ACE);
        Card c3 = new Card(CardType.CLUBS, CardNumber.ACE);
        assertAll(
                () -> assertTrue(c1.equals(c2)),
                () -> assertFalse(c1.equals(c3))
        );
    }
}
