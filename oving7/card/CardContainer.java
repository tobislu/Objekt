package oving7.card;

public interface CardContainer {

    /**
     * Returnerer antall kort i containeren
     */
    int getCardCount();

    /**
     * Returnerer kortet på indeks n
     * Kaster IllegalArgumentException hvis n er ugyldig
     */
    Card getCard(int n);
}