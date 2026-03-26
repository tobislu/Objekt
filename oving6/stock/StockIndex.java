package oving6.stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockIndex implements StockListener {

    private final String name;
    private final List<Stock> stocks = new ArrayList<>();
    private double index = 0.0;

    public StockIndex(String name, Stock... stocks) {
        if (name == null) {
            throw new IllegalArgumentException("name kan ikke være null");
        }
        this.name = name;

        if (stocks == null) {
            throw new IllegalArgumentException("stocks kan ikke være null");
        }
        for (Stock s : stocks) {
            if (s == null) {
                throw new IllegalArgumentException("stocks kan ikke inneholde null");
            }
        }

        // Registrer og bygg index fra start
        Arrays.stream(stocks).forEach(this::addStock);
    }

    public void addStock(Stock stock) {
        if (stock == null) {
            throw new IllegalArgumentException("stock kan ikke være null");
        }
        if (stocks.contains(stock)) {
            return;
        }
        stocks.add(stock);
        index += stock.getPrice();
        stock.addStockListener(this);
    }

    public void removeStock(Stock stock) {
        if (stocks.remove(stock)) {
            // fjern bidrag og lytting
            index -= stock.getPrice();
            stock.removeStockListener(this);
        }
    }

    public double getIndex() {
        return index;
    }

    @Override
    public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
        // Bare juster hvis stock faktisk er i indeksen
        if (stocks.contains(stock)) {
            index += (newValue - oldValue);
        }
    }

    @Override
    public String toString() {
        return name + ": " + index;
    }
}