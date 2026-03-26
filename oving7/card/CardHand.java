package oving7.card;

public class CardHand extends CardContainerImpl {

    public CardHand(int maxCardCount) {
        super(maxCardCount);
    }

    public void addCard(Card card) {
        super.addCard(card);
    }

    public Card play(int n) {
        return super.removeCard(n);
    }
}