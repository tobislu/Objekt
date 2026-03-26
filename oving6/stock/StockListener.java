package oving6.stock;

public interface StockListener {
    void stockPriceChanged(Stock stock, double oldValue, double newValue);
}