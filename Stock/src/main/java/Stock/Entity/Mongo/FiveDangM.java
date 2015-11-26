package Stock.Entity.Mongo;

import Stock.Entity.*;
import Stock.Entity.FiveDangPrice;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wgqing on 2015/11/25.
 */
@Entity
public class FiveDangM {
    public FiveDangM(){
    }
    @Id
    ObjectId id;
    private String symbol;
    private String stockName;
    private double openPrice;
    private Date priceDate;
    private double lastClosePrice;
    private List<FiveDangPriceM> prices;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(Date priceDate) {
        this.priceDate = priceDate;
    }

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

    public List<FiveDangPriceM> getPrices() {
        prices=new LinkedList<FiveDangPriceM>();
        return prices;
    }

    public void setPrices(List<FiveDangPriceM> prices) {
        this.prices = prices;
    }
}
