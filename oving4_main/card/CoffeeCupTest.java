package oving4.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoffeeCupTest {

    private static final double EPS = 1e-9; // EPS brukes for å håndtere små avrundingsfeil når vi sammenligner double-verdier

    private static void assertState(CoffeeCup cup, double cap, double vol) { //hjelpe-metode for å gjøre testen mer lesbar og unngå repetisjon (slippe å skrive to assertEquals hver gang)
        assertEquals(cap, cup.getCapacity(), EPS);
        assertEquals(vol, cup.getCurrentVolume(), EPS);
    }

    //  Konstruktører / gettere 

    @Test
    public void testConstructors() { //tester at konstruktørene setter intern tilstand korrekt
        CoffeeCup empty = new CoffeeCup();
        assertState(empty, 0.0, 0.0);

        CoffeeCup cup = new CoffeeCup(10.0, 2.5);
        assertState(cup, 10.0, 2.5);
    }

    @Test
    public void testConstructorInvalidArgumentsThrow() { //feil input gir exception
        assertThrows(IllegalArgumentException.class, () -> new CoffeeCup(-1.0, 0.0));   // negativ kapasitet
        assertThrows(IllegalArgumentException.class, () -> new CoffeeCup(10.0, -0.1));  // negativt volum
        assertThrows(IllegalArgumentException.class, () -> new CoffeeCup(10.0, 10.1));  // volum > kapasitet
    }

    //  increaseCupSize 

    @Test
    public void testIncreaseCupSize() { //Positiv økning -> kapasitet øker, Negativ verdi -> ignoreres
        CoffeeCup cup = new CoffeeCup(10.0, 5.0);

        cup.increaseCupSize(2.0);
        assertState(cup, 12.0, 5.0); // kapasitet øker, volum uendret

        cup.increaseCupSize(-3.0);
        assertState(cup, 12.0, 5.0); // negative verdier ignoreres
    }

    //  fillCoffee 

    @Test
    public void testFillCoffee() { //Normal fylling -> volum øker, For mye fylling -> exception
        CoffeeCup cup = new CoffeeCup(10.0, 4.0);

        cup.fillCoffee(3.0);
        assertState(cup, 10.0, 7.0);

        assertThrows(IllegalArgumentException.class, () -> cup.fillCoffee(10.0)); // ville gått over kapasitet
        assertState(cup, 10.0, 7.0); // tilstand endres ikke ved exception (fint å vise)
    }

    //  drinkCoffee 

    @Test
    public void testDrinkCoffee() { //skal redusere volum, men aldri føre til negativt volum
        CoffeeCup cup = new CoffeeCup(10.0, 6.0);

        cup.drinkCoffee(2.5);
        assertState(cup, 10.0, 3.5);

        assertThrows(IllegalArgumentException.class, () -> cup.drinkCoffee(3.6)); // mer enn man har
        assertThrows(IllegalArgumentException.class, () -> cup.drinkCoffee(-1.0)); // negativ mengde
        assertState(cup, 10.0, 3.5); // fortsatt uendret etter exceptions
    }
}