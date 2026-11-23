package models;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for {@link Deck}.
 */
public class DeckTest {
    /** The number of cards in a standard deck. */
    private static final int DECK_SIZE = 52;
    /** One more draw attempt than a standard deck contains. */
    private static final int DRAW_ATTEMPTS = DECK_SIZE + 1;
    /** Seed used for the first deterministic shuffle. */
    private static final int FIRST_RANDOM_SEED = 32;
    /** Seed used for the second deterministic shuffle. */
    private static final int SECOND_RANDOM_SEED = 45;

    /** Tests that a deck can be initialised. */
    @Test
    public void canInitialiseDeck() {
        Deck deck = new Deck();
        assertEquals("Length: " + DECK_SIZE, deck.toString());
    }

    /** Tests that a new deck contains fifty-two cards. */
    @Test
    public void deckHasFiftyTwoCards() {
        Deck deck = new Deck();
        assertEquals(DECK_SIZE, deck.getLength());
    }

    /** Tests that drawing more cards than available fails. */
    @Test
    public void canDrawOnlyFiftyTwoCards() {
        Deck deck = new Deck();
        for (int i = 1; i <= DRAW_ATTEMPTS; i++) {
            if (i <= DECK_SIZE) {
                assertInstanceOf(Card.class, deck.drawCard());
            } else {
                assertThrows(NoSuchElementException.class, deck::drawCard);
            }
        }
    }

    /** Tests that an unseeded shuffle changes the deck order. */
    @Test
    public void shuffleShouldChangeDeckOrder() {
        Deck deck = new Deck();
        List<Card> unshuffledDeck = deck.getCards();
        deck.shuffleDeck();
        assertNotEquals(unshuffledDeck, deck.getCards());
    }

    /** Tests that different random seeds produce different deck orders. */
    @Test
    public void shuffleShouldRandomlySortDecks() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        assertEquals(deck1.getCards(), deck2.getCards());

        Random rand1 = new Random(FIRST_RANDOM_SEED);
        deck1.shuffleDeck(rand1);

        Random rand2 = new Random(SECOND_RANDOM_SEED);
        deck2.shuffleDeck(rand2);

        assertNotEquals(deck1.getCards(), deck2.getCards());
    }
}
