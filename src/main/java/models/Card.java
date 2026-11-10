package models;

import java.util.Objects;

public class Card {
    final private CardType Type;
    final private CardNumber Number;

    public Card(CardType type, CardNumber number) {
        this.Type = Objects.requireNonNull(type);
        this.Number = Objects.requireNonNull(number);
    }

    public CardType getType() {
        return this.Type;
    }

    public CardNumber getNumber() {
        return this.Number;
    }

    @Override
    public String toString() {
        return ("Type: " + this.Type + "\nNumber: " + this.Number);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card card)) {
            return false;
        }

        return (Objects.equals(this.Type, card.getType())) &&
                    (Objects.equals(this.Number, card.getNumber()));
    }
}
