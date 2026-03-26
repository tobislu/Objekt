package oving6.stock;

import java.util.HashMap;
import java.util.Map;

public class SmartStock extends Stock {

    // Interval listeners: listener -> [min, max]
    private final Map<StockListener, double[]> intervalListeners = new HashMap<>();

    // Difference listeners: listener -> (difference, lastReportedPrice)
    private final Map<StockListener, DiffState> differenceListeners = new HashMap<>();

    private static class DiffState {
        final double difference;
        double lastReportedPrice;

        DiffState(double difference, double lastReportedPrice) {
            this.difference = difference;
            this.lastReportedPrice = lastReportedPrice;
        }
    }

    public SmartStock(String ticker, double price) {
        super(ticker, price);
    }

    // Prisintervall
    public void addStockListener(StockListener listener, double min, double max) {
        if (listener == null) {
            throw new IllegalArgumentException("listener kan ikke være null");
        }
        if (min > max) {
            throw new IllegalArgumentException("min kan ikke være større enn max");
        }
        intervalListeners.put(listener, new double[] { min, max });
    }

    // Prisdifferanse
    public void addStockListener(StockListener listener, double difference) {
        if (listener == null) {
            throw new IllegalArgumentException("listener kan ikke være null");
        }
        if (difference <= 0) {
            throw new IllegalArgumentException("difference må være > 0");
        }
        // lastReportedPrice starter på gjeldende pris (slik testen beskriver)
        differenceListeners.put(listener, new DiffState(difference, getPrice()));
    }

    @Override
    public void setPrice(double price) {
        double old = getPrice();

        // Stock skal selv kaste feil om price <= 0, men vi unngår ekstra arbeid ved lik pris
        if (Double.compare(old, price) == 0) {
            return;
        }

        // Oppdater pris og varsle "vanlige" listeners via Stock
        super.setPrice(price);

        // Etter super.setPrice er prisen oppdatert
        double newPrice = getPrice();

        // 1) Interval listeners: varsle bare hvis ny pris er utenfor [min, max]
        for (Map.Entry<StockListener, double[]> entry : intervalListeners.entrySet()) {
            StockListener listener = entry.getKey();
            double[] interval = entry.getValue();
            double min = interval[0];
            double max = interval[1];

            if (newPrice < min || newPrice > max) {
                listener.stockPriceChanged(this, old, newPrice);
            }
        }

        // 2) Difference listeners: varsle hvis |new - lastReported| >= difference
        for (Map.Entry<StockListener, DiffState> entry : differenceListeners.entrySet()) {
            StockListener listener = entry.getKey();
            DiffState state = entry.getValue();

            if (Math.abs(newPrice - state.lastReportedPrice) >= state.difference) {
                double reportedOld = state.lastReportedPrice;
                state.lastReportedPrice = newPrice; // oppdater "forrige rapporterte" verdi
                listener.stockPriceChanged(this, reportedOld, newPrice);
            }
        }
    }
}