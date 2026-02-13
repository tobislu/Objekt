package oving3.card;

/**
 * The {@code Card} class is a so-called value-based class, which is coded in
 * such a way that its
 * objects cannot be modified after they are created. A {@code Card} object has
 * a suit and a face.
 */
/* 
suit må være én av 'S','H','D','C'

face må være mellom 1 og 13 (inkludert)

hvis noe er ulovlig → IllegalArgumentException

objektet skal ikke kunne endres etterpå → ingen setters, og feltene bør være private final
*/
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
