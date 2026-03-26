package oving6.stock;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private final String ticker;
    private double price;

    private final List<StockListener> listeners = new ArrayList<>();

    public Stock(String ticker, double price) {
        if (ticker == null) {
            throw new IllegalArgumentException("ticker kan ikke være null");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("price må være > 0");
        }
        this.ticker = ticker;
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("price må være > 0");
        }
        double old = this.price;
        if (Double.compare(old, price) == 0) {
            return; // ingen endring -> ingen varsling
        }
        this.price = price;

        // Varsle alle
        for (StockListener l : List.copyOf(listeners)) {
            l.stockPriceChanged(this, old, price);
        }
    }

    public void addStockListener(StockListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener kan ikke være null");
        }
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public void removeStockListener(StockListener listener) {
        listeners.remove(listener);
    }
}