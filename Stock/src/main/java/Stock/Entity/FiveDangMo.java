package Stock.Entity;

import java.util.List;

/**
 * Created by wgqing on 2015/11/3.
 */
public class FiveDangMo {
    private String symbol;
    private String stockName;
    private double openPrice;
    private double lastClosePrice;
    private List<FiveDangPrice> prices;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getLastClosePrice() {
        return lastClosePrice;
    }

    public void setLastClosePrice(double lastClosePrice) {
        this.lastClosePrice = lastClosePrice;
    }
}
