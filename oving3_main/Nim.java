package oving3;

public class Nim {

    private final int[] piles = new int[3];

    public Nim() {
        this(10);
    }

    public Nim(int pileSize) {
        if (pileSize < 0) {
            throw new IllegalArgumentException("pileSize kan ikke være negativ");
        }
        for (int i = 0; i < piles.length; i++) {
            piles[i] = pileSize;
        }
    }

    public boolean isGameOver() {
        return piles[0] == 0 || piles[1] == 0 || piles[2] == 0;
    }

    public int getPile(int targetPile) {
        if (targetPile < 0 || targetPile > 2) {
            throw new IllegalArgumentException("Ugyldig haug: " + targetPile);
        }
        return piles[targetPile];
    }

    public boolean isValidMove(int number, int targetPile) {
        if (isGameOver()) return false;
        if (targetPile < 0 || targetPile > 2) return false;
        if (number < 1) return false;
        return number <= piles[targetPile];
    }

    public void removePieces(int number, int targetPile) {
        if (isGameOver()) {
            throw new IllegalStateException("Spillet er over");
        }
        if (!isValidMove(number, targetPile)) {
            throw new IllegalArgumentException("Ugyldig trekk");
        }
        piles[targetPile] -= number;
    }

    @Override
    public String toString() {
        return "Piles: " + piles[0] + ", " + piles[1] + ", " + piles[2];
    }
}