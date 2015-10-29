package Stock.Threads;
import Stock.DO.CurrentFiveDangList;
import Stock.Entity.FiveDang;
import Stock.Entity.StockInfo;
import Util.FormatUtil;
import Util.JsoupUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.Runnable;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * 获取五档信息
 */
public class GetFiveDangThread implements Runnable {
    private CurrentFiveDangList currentFiveDangList;
    private List<String> symbols;

    public void Init(CurrentFiveDangList currentFiveDangList, List<String> symbols) {
        this.currentFiveDangList = currentFiveDangList;
        this.symbols = symbols;
    }

    private void GetFiveDang() {
        System.out.println("getfivedang--------");
        try {
            StringBuffer strSymboles = new StringBuffer();
            for (String symbol : symbols) {
                strSymboles.append(symbol + ",");
            }
            String url = "http://hq.sinajs.cn/?_=0.20674839243292809&list=" + strSymboles.toString();
            Document pod = Jsoup.connect(url).ignoreContentType(true).get();
            String body = pod.body().text().toString();
            String[] priceInfos = body.split(";");
            for (String priceInfo : priceInfos) {
                FiveDang fiveDang = InitFiveDang(priceInfo);
                if (fiveDang != null) {
                    currentFiveDangList.Add(fiveDang);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FiveDang InitFiveDang(String fivedangString) {
        String symbole = fivedangString.substring(fivedangString.lastIndexOf("_") + 1, fivedangString.indexOf("="));
        String content = fivedangString.substring(fivedangString.indexOf("\"") + 1, fivedangString.lastIndexOf("\""));
        if (!content.trim().equals("")) {
            String[] prices = content.split(",");
            FiveDang dang = new FiveDang();
            dang.setSymbol(symbole);
            dang.setStockName(prices[0]);
            dang.setOpenPrice(Double.parseDouble(prices[1]));
            dang.setLastClosePrice(Double.parseDouble(prices[2]));
            dang.setCurrentPrice(Double.parseDouble(prices[3]));
            dang.setHighestPrice(Double.parseDouble(prices[4]));
            dang.setLowestPrice(Double.parseDouble(prices[5]));
            dang.setBuyPrice1(Double.parseDouble(prices[11]));
            dang.setBuyPrice2(Double.parseDouble(prices[13]));
            dang.setBuyPrice3(Double.parseDouble(prices[15]));
            dang.setBuyPrice4(Double.parseDouble(prices[17]));
            dang.setBuyPrice5(Double.parseDouble(prices[19]));
            dang.setBuyCount1(Long.parseLong(prices[10]));
            dang.setBuyCount2(Long.parseLong(prices[12]));
            dang.setBuyCount3(Long.parseLong(prices[14]));
            dang.setBuyCount4(Long.parseLong(prices[16]));
            dang.setBuyCount5(Long.parseLong(prices[18]));
            dang.setSellPrice1(Double.parseDouble(prices[21]));
            dang.setSellPrice2(Double.parseDouble(prices[23]));
            dang.setSellPrice3(Double.parseDouble(prices[25]));
            dang.setSellPrice4(Double.parseDouble(prices[27]));
            dang.setSellPrice5(Double.parseDouble(prices[29]));
            dang.setSellCount1(Long.parseLong(prices[20]));
            dang.setSellCount2(Long.parseLong(prices[22]));
            dang.setSellCount3(Long.parseLong(prices[24]));
            dang.setSellCount4(Long.parseLong(prices[26]));
            dang.setSellCount5(Long.parseLong(prices[28]));
            try {
                dang.setPriceTime(FormatUtil.GetDateTimeByString(prices[30] + " " + prices[31]));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dang;
        }
        return null;
    }

    @Override
    public void run() {
        while (true){
            GetFiveDang();
            try{
            Thread.sleep(2000);}catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}