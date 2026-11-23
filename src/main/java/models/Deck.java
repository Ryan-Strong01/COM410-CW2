package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Represents a standard deck of playing cards.
 */
public final class Deck {
    /** The cards currently remaining in the deck. */
    private final List<Card> cards;

    /**
     * Creates and initialises a standard deck.
     */
    public Deck() {
        cards = new ArrayList<>();
        initialiseDeck();
    }

    private void initialiseDeck() {
        for (CardType type : CardType.values()) {
            for (CardNumber number : CardNumber.values()) {
                cards.add(new Card(type, number));
            }
        }
    }

    /**
     * Shuffles the deck using a randomly generated source of randomness.
     */
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    /**
     * Shuffles the deck using the supplied source of randomness.
     *
     * @param seed the source of randomness
     */
    public void shuffleDeck(final Random seed) {
        Collections.shuffle(cards, seed);
    }

    /**
     * Draws and removes the top card from the deck.
     *
     * @return the drawn card
     * @throws NoSuchElementException when the deck is empty
     */
    public Card drawCard() throws NoSuchElementException {
        if (cards.isEmpty()) {
            throw new NoSuchElementException("deck is empty");
        }

        return cards.removeLast();
    }

    /**
     * Returns the number of cards remaining in the deck.
     *
     * @return the deck length
     */
    public int getLength() {
        return cards.size();
    }

    /**
     * Returns a snapshot of the cards remaining in the deck.
     *
     * @return the cards remaining in the deck
     */
    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    /**
     * Returns the number of cards in the deck.
     *
     * @return the deck representation
     */
    @Override
    public String toString() {
        return "Length: " + cards.size();
    }
}
