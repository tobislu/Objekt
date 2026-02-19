package oving4.card;

public class Card {
    private final char suit; // Final har til hensikt å låse verdiene etter de genereres i konstruktøren
    private final int face;

    public Card(char suit, int face) {
        
        if (suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C'){
            throw new IllegalArgumentException("Ugyldig farge!");
        }

        if (face < 1 || face > 13){
            throw new IllegalArgumentException("Ugyldig verdi");
        }

        this.suit = suit;
        this.face = face;
    }


    public char getSuit() {
        
        return this.suit;
    }


    public int getFace() {
    
        return this.face;
    }

    /**
     * @return the value of the card of the form {@code <suit><face>}. For example,
     *         the ace of
     *         spades should return {@code "S1"}
     * 
     * @see CardTest#testToString()
     */
    @Override
    public String toString() {
        return "" + this.suit + this.face;
    }

    public static void main(String[] args) {
        Card c = new Card('S', 1);
        System.out.println(c);
    }
}
