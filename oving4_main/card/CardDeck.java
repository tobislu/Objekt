package oving4.card;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private final List<Card> cards = new ArrayList<>();

    public CardDeck(int n){
        if (n < 0) {
            throw new IllegalArgumentException("n kan ikke være negativ");
        }


        char[] suits = {'S', 'H', 'D', 'C'};
        
        for (char suit : suits) {
            for (int face = 1; face <= n; face++) {
                cards.add(new Card(suit, face));
            }
        }
    }


    public int getCardCount() {
        return cards.size();
    }


    public Card getCard(int n) {
        if (n < 0 || n >= cards.size()) {
            throw new IllegalArgumentException("Ugyldig kortindeks: " + n);
        }
        return cards.get(n);
    }
    

    public void shufflePerfectly() {
        int size = cards.size();
        int half = size / 2;

        List<Card> shuffled = new ArrayList<>(size);

        for (int i = 0; i < half; i++) {
            shuffled.add(cards.get(i));        // fra toppdel
            shuffled.add(cards.get(i + half)); // fra bunndel
        }

        cards.clear();
        cards.addAll(shuffled);
    }

    public void deal(CardHand cardHand, int n) {  
        if (cardHand == null) {
            throw new IllegalArgumentException("cardHand kan ikke være null");
        }
        if (n < 0 || n > cards.size()) {
            throw new IllegalArgumentException("Ugyldig antall kort å dele ut: " + n);
        }

        for (int i = 0; i < n; i++) { 
            Card c = cards.remove(cards.size() - 1); // høyeste gyldige indeks
            cardHand.addCard(c); 
        }
    }
}
