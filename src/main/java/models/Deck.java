package models;
import java.util.*;

public class Deck {
    private final List<Card> cards;

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

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public void shuffleDeck(Random seed) {
        Collections.shuffle(cards, seed);
    }
    // make an overloaded approach to shuffling deck which I can pass the random seed for
    // this makes it easier for me to test since I can pre-determine the results

    public Card drawCard() throws NoSuchElementException {
        if (cards.isEmpty()) {
            throw new NoSuchElementException("deck is empty");
        }

        return cards.removeLast();
    }

    public int getLength() {
        return cards.size();
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    @Override
    public String toString() {
        return "Length: " + cards.size();
    }
}
