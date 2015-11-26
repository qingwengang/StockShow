package Stock.Entity.Mongo;

import Stock.Entity.FiveDang;

import java.util.Date;

/**
 * Created by wgqing on 2015/11/26.
 */
public class FiveDangPriceM {
    private double currentPrice;
    private double highestPrice;
    private double lowestPrice;
    private Date priceTime;
    private double BuyPrice1;
    private long BuyCount1;
    private double BuyPrice2;
    private long BuyCount2;
    private double BuyPrice3;
    private long BuyCount3;
    private double BuyPrice4;
    private long BuyCount4;
    private double BuyPrice5;
    private long BuyCount5;
    private double SellPrice1;
    private long SellCount1;
    private double SellPrice2;
    private long SellCount2;
    private double SellPrice3;
    private long SellCount3;
    private double SellPrice4;
    private long SellCount4;
    private double SellPrice5;
    private long SellCount5;
    private double DealAmount;
    private long DealCount;
    private double DealAmountNew;
    private long DealCountNew;
    public FiveDangPriceM(){
    }
    public FiveDangPriceM(FiveDang dang){
        this.setPriceTime(dang.getPriceTime());
        setCurrentPrice(dang.getCurrentPrice());
        setHighestPrice(dang.getHighestPrice());
        setLowestPrice(dang.getLowestPrice());
        setBuyPrice1(dang.getBuyPrice1());
        setBuyCount1(dang.getBuyCount1());
        setBuyPrice2(dang.getBuyPrice2());
        setBuyCount2(dang.getBuyCount2());
        setBuyPrice3(dang.getBuyPrice3());
        setBuyCount3(dang.getBuyCount3());
        setBuyPrice4(dang.getBuyPrice4());
        setBuyCount4(dang.getBuyCount4());
        setBuyPrice5(dang.getBuyPrice5());
        setBuyCount5(dang.getBuyCount5());
        setSellPrice1(dang.getSellPrice1());
        setSellCount1(dang.getSellCount1());
        setSellPrice2(dang.getSellPrice2());
        setSellCount2(dang.getSellCount2());
        setSellPrice3(dang.getSellPrice3());
        setSellCount3(dang.getSellCount3());
        setSellPrice4(dang.getSellPrice4());
        setSellCount4(dang.getSellCount4());
        setSellPrice5(dang.getSellPrice5());
        setSellCount5(dang.getSellCount5());
        setDealAmount(dang.getDealAmount());
        setDealCount(dang.getDealCount());
    }
    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public Date getPriceTime() {
        return priceTime;
    }

    public void setPriceTime(Date priceTime) {
        this.priceTime = priceTime;
    }

    public double getBuyPrice1() {
        return BuyPrice1;
    }

    public void setBuyPrice1(double buyPrice1) {
        BuyPrice1 = buyPrice1;
    }

    public long getBuyCount1() {
        return BuyCount1;
    }

    public void setBuyCount1(long buyCount1) {
        BuyCount1 = buyCount1;
    }

    public double getBuyPrice2() {
        return BuyPrice2;
    }

    public void setBuyPrice2(double buyPrice2) {
        BuyPrice2 = buyPrice2;
    }

    public long getBuyCount2() {
        return BuyCount2;
    }

    public void setBuyCount2(long buyCount2) {
        BuyCount2 = buyCount2;
    }

    public double getBuyPrice3() {
        return BuyPrice3;
    }

    public void setBuyPrice3(double buyPrice3) {
        BuyPrice3 = buyPrice3;
    }

    public long getBuyCount3() {
        return BuyCount3;
    }

    public void setBuyCount3(long buyCount3) {
        BuyCount3 = buyCount3;
    }

    public double getBuyPrice4() {
        return BuyPrice4;
    }

    public void setBuyPrice4(double buyPrice4) {
        BuyPrice4 = buyPrice4;
    }

    public long getBuyCount4() {
        return BuyCount4;
    }

    public void setBuyCount4(long buyCount4) {
        BuyCount4 = buyCount4;
    }

    public double getBuyPrice5() {
        return BuyPrice5;
    }

    public void setBuyPrice5(double buyPrice5) {
        BuyPrice5 = buyPrice5;
    }

    public long getBuyCount5() {
        return BuyCount5;
    }

    public void setBuyCount5(long buyCount5) {
        BuyCount5 = buyCount5;
    }

    public double getSellPrice1() {
        return SellPrice1;
    }

    public void setSellPrice1(double sellPrice1) {
        SellPrice1 = sellPrice1;
    }

    public long getSellCount1() {
        return SellCount1;
    }

    public void setSellCount1(long sellCount1) {
        SellCount1 = sellCount1;
    }

    public double getSellPrice2() {
        return SellPrice2;
    }

    public void setSellPrice2(double sellPrice2) {
        SellPrice2 = sellPrice2;
    }

    public long getSellCount2() {
        return SellCount2;
    }

    public void setSellCount2(long sellCount2) {
        SellCount2 = sellCount2;
    }

    public double getSellPrice3() {
        return SellPrice3;
    }

    public void setSellPrice3(double sellPrice3) {
        SellPrice3 = sellPrice3;
    }

    public long getSellCount3() {
        return SellCount3;
    }

    public void setSellCount3(long sellCount3) {
        SellCount3 = sellCount3;
    }

    public double getSellPrice4() {
        return SellPrice4;
    }

    public void setSellPrice4(double sellPrice4) {
        SellPrice4 = sellPrice4;
    }

    public long getSellCount4() {
        return SellCount4;
    }

    public void setSellCount4(long sellCount4) {
        SellCount4 = sellCount4;
    }

    public double getSellPrice5() {
        return SellPrice5;
    }

    public void setSellPrice5(double sellPrice5) {
        SellPrice5 = sellPrice5;
    }

    public long getSellCount5() {
        return SellCount5;
    }

    public void setSellCount5(long sellCount5) {
        SellCount5 = sellCount5;
    }

    public double getDealAmount() {
        return DealAmount;
    }

    public void setDealAmount(double dealAmount) {
        DealAmount = dealAmount;
    }

    public long getDealCount() {
        return DealCount;
    }

    public void setDealCount(long dealCount) {
        DealCount = dealCount;
    }

    public double getDealAmountNew() {
        return DealAmountNew;
    }

    public void setDealAmountNew(double dealAmountNew) {
        DealAmountNew = dealAmountNew;
    }

    public long getDealCountNew() {
        return DealCountNew;
    }

    public void setDealCountNew(long dealCountNew) {
        DealCountNew = dealCountNew;
    }
}
