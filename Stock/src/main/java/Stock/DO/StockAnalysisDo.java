package Stock.DO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by wgqing on 2015/12/23.
 */
@Entity
public class StockAnalysisDo {
    private String Code;
    private String Name;
    private double CurrentPrice;
    private double SupportPrice;
    private double PressurePrice;
    private double PlanBuyPrice;
    private double PlanSellPrice;
    private double BuyPrice;
    private int Level;
    private String Symbol;
    private long Id;

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getCurrentPrice() {
        return CurrentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        CurrentPrice = currentPrice;
    }

    public double getSupportPrice() {
        return SupportPrice;
    }

    public void setSupportPrice(double supportPrice) {
        SupportPrice = supportPrice;
    }

    public double getPressurePrice() {
        return PressurePrice;
    }

    public void setPressurePrice(double pressurePrice) {
        PressurePrice = pressurePrice;
    }

    public double getPlanBuyPrice() {
        return PlanBuyPrice;
    }

    public void setPlanBuyPrice(double planBuyPrice) {
        PlanBuyPrice = planBuyPrice;
    }

    public double getPlanSellPrice() {
        return PlanSellPrice;
    }

    public void setPlanSellPrice(double planSellPrice) {
        PlanSellPrice = planSellPrice;
    }

    public double getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        BuyPrice = buyPrice;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }
}
