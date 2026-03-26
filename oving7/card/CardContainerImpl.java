package oving7.card;

import java.util.ArrayList;
import java.util.List;

public abstract class CardContainerImpl implements CardContainer, Iterable<Card> {

    protected final List<Card> cards = new ArrayList<>();
    private final int maxCardCount;

    public CardContainerImpl(int maxCardCount) {
        if (maxCardCount < 0) {
            throw new IllegalArgumentException("Max card count kan ikke være negativ");
        }
        this.maxCardCount = maxCardCount;
    }

    public int getMaxCardCount() {
        return maxCardCount;
    }

    @Override
    public int getCardCount() {
        return cards.size();
    }

    @Override
    public java.util.Iterator<Card> iterator() {
        return cards.iterator();
    }

    @Override
    public Card getCard(int n) {
        if (n < 0 || n >= cards.size()) {
            throw new IllegalArgumentException("Ugyldig kortindeks: " + n);
        }
        return cards.get(n);
    }

    protected void addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Kort kan ikke være null");
        }
        if (cards.size() >= maxCardCount) {
            throw new IllegalStateException("Kan ikke legge til flere kort");
        }
        cards.add(card);
    }

    protected Card removeCard(int n) {
        if (n < 0 || n >= cards.size()) {
            throw new IllegalArgumentException("Ugyldig kortindeks: " + n);
        }
        return cards.remove(n);
    }
}