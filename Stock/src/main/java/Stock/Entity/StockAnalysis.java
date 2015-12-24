package Stock.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by wgqing on 2015/12/23.
 */
@Entity
public class StockAnalysis {
    private long Id;
    private String Code;
    private double SupportPrice;
    private double PressurePrice;
    private double PlanBuyPrice;
    private double PlanSellPrice;
    private double BuyPrice;
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
}
