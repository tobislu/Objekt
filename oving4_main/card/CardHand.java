package oving4.card;

import java.util.ArrayList;
import java.util.List;

public class CardHand {
    private final List<Card> cards = new ArrayList<>();

    public int getCardCount() {
        return cards.size();
    }

    public Card getCard(int n) {
        if (n < 0 || n >= cards.size()) {
            throw new IllegalArgumentException("Ugyldig kortindeks: " + n);
        }
        return cards.get(n);
    }

    public void addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Kort kan ikke være null");
        }
        cards.add(card);
    }

    public Card play(int n) {
        if (n < 0 || n >= cards.size()) {
            throw new IllegalArgumentException("Ugyldig kortindeks: " + n);
        }
        return cards.remove(n);
    }
}

