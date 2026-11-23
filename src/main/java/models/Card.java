package models;

import java.util.Objects;

/**
 * Represents a playing card with a type and number.
 */
public final class Card {
    /** The card type. */
    private final CardType type;
    /** The card number. */
    private final CardNumber number;

    /**
     * Creates a card.
     *
     * @param cardType the card type
     * @param cardNumber the card number
     */
    public Card(final CardType cardType, final CardNumber cardNumber) {
        this.type = Objects.requireNonNull(cardType);
        this.number = Objects.requireNonNull(cardNumber);
    }

    /**
     * Returns the card type.
     *
     * @return the card type
     */
    public CardType getType() {
        return this.type;
    }

    /**
     * Returns the card number.
     *
     * @return the card number
     */
    public CardNumber getNumber() {
        return this.number;
    }

    /**
     * Returns a readable representation of this card.
     *
     * @return the card representation
     */
    @Override
    public String toString() {
        return ("Type: " + this.type + "\nNumber: " + this.number);
    }

    /**
     * Compares this card with another object.
     *
     * @param obj the object to compare
     * @return true when both cards have the same type and number
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Card card)) {
            return false;
        }

        return (Objects.equals(this.type, card.getType()))
                && (Objects.equals(this.number, card.getNumber()));
    }

    /**
     * Returns a hash code based on this card's type and number.
     *
     * @return the card hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.number);
    }
}
