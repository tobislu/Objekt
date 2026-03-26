package oving7.card;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CardDeck extends CardContainerImpl {

    public CardDeck(int n) {
        super(52);

        if (n < 0) {
            throw new IllegalArgumentException("n kan ikke være negativ");
        }

        char[] suits = { 'S', 'H', 'D', 'C' };

        for (char suit : suits) {
            for (int face = 1; face <= n; face++) {
                addCard(new Card(suit, face));
            }
        }
    }

    public void shufflePerfectly() {
        int size = cards.size();
        int half = size / 2;

        List<Card> shuffled = new ArrayList<>(size);

        for (int i = 0; i < half; i++) {
            shuffled.add(cards.get(i));
            shuffled.add(cards.get(i + half));
        }

        cards.clear();
        cards.addAll(shuffled);
    }

    public void deal(CardHand cardHand, int n) {
        if (cardHand == null) {
            throw new IllegalArgumentException("CardHand kan ikke være null");
        }

        if (n < 0 || n > getCardCount()) {
            throw new IllegalArgumentException("Ugyldig antall kort: " + n);
        }

        for (int i = 0; i < n; i++) {
            Card card = removeCard(getCardCount() - 1);
            cardHand.addCard(card);
        }
    }

    // Fra øving 5 - kan beholdes hvis du vil ha med funksjonaliteten videre
    public List<Card> getCards(Predicate<Card> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("predicate kan ikke være null");
        }

        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (predicate.test(card)) {
                result.add(card);
            }
        }
        return result;
    }

    public int getCardCount(Predicate<Card> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("predicate kan ikke være null");
        }

        int count = 0;
        for (Card card : cards) {
            if (predicate.test(card)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasCard(Predicate<Card> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("predicate kan ikke være null");
        }

        for (Card card : cards) {
            if (predicate.test(card)) {
                return true;
            }
        }
        return false;
    }
}