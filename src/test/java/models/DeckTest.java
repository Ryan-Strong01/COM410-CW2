package models;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void canInitialiseDeck() {
        Deck deck = new Deck();
        assertEquals("Length: 52", deck.toString());
    }

    @Test
    public void deckHasFiftyTwoCards() {
        Deck deck = new Deck();
        assertEquals(52, deck.getLength());
    }

    @Test
    public void canDrawOnlyFiftyTwoCards() {
        Deck deck = new Deck();
        for (int i = 1; i <= 53; i++) {
            if (i <= 52) {
                assertInstanceOf(Card.class, deck.drawCard());
            } else {
                assertThrows(NoSuchElementException.class, deck::drawCard);
            }
        }
    }

    @Test
    public void shuffleShouldChangeDeckOrder() {
        Deck deck = new Deck();
        List<Card> unshuffledDeck = deck.getCards();
        deck.shuffleDeck();
        assertNotEquals(unshuffledDeck,deck.getCards());
    }

    /*
    Using a seed is necessary because randomly shuffling can theoritically make the same deck
    This would make the test flaky since if it ever comes out the same way it will fail
    By using seeds, we can guarantee the shuffle is working while not just always making the same deck
    This is good because it maintains testability for everything
    */
    @Test
    public void shuffleShouldRandomlySortDecks() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        assertEquals(deck1.getCards(), deck2.getCards());

        Random rand1 = new Random(32);
        deck1.shuffleDeck(rand1);

        Random rand2 = new Random(45);
        deck2.shuffleDeck(rand2);

        assertNotEquals(deck1.getCards(), deck2.getCards());
    }
}
