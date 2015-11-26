package Stock.Threads;
import Stock.DO.CurrentFiveDangList;
import Stock.Entity.FiveDang;
import Stock.Entity.StockInfo;
import Util.DateFormatUtil;
import Util.FormatUtil;
import Util.JsoupUtil;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.Runnable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 获取五档信息
 */
public class GetFiveDangThread implements Runnable {
    private static Logger logger = Logger.getLogger(GetFiveDangThread.class);
    private CurrentFiveDangList currentFiveDangList;
    private List<String> symbols;

    public void Init(CurrentFiveDangList currentFiveDangList, List<String> symbols) {
        this.currentFiveDangList = currentFiveDangList;
        this.symbols = symbols;
    }

    private void GetFiveDang() {
        System.out.println("getfivedang--------");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
                FiveDang fiveDang = InitFiveDang(priceInfo,sdf1);
                if (fiveDang != null) {
                    currentFiveDangList.Add(fiveDang);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] arts){
//        GetFiveDangThread t=new GetFiveDangThread();
//        FiveDang dang = t.InitFiveDang("var hq_str_sz002579=\"中京电子,11.60,11.53,11.40,11.69,11.11,11.40,11.41,18013368,206308405.89,82500,11.40,4000,11.39,46800,11.38,53200,11.37,17300,11.36,38700,11.41,5400,11.42,900,11.43,25950,11.44,18000,11.45,2015-10-29,15:34:16,00\"");
//        System.out.print(dang.getSymbol());
//    }
    public FiveDang InitFiveDang(String fivedangString,SimpleDateFormat sdf1) {
        try{
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
                dang.setDealCount(Long.parseLong(prices[8]));
                dang.setDealAmount(Double.parseDouble(prices[9]));
                try {
                    String dateString=prices[30] + " " + prices[31];
                    dang.setPriceTime(sdf1.parse(dateString));
//                    dang.setPriceTime(DateFormatUtil.parse(dateString));
//                    dang.setPriceTime(FormatUtil.GetDateTimeByString(prices[30] + " " + prices[31]));
                } catch (Exception e) {
                    logger.error("GetFiveDangThread.InitFiveDang.Format:"+e+";fiveDang:"+fivedangString+";input:"+prices[30] + " " + prices[31]);
                }
                return dang;
            }
        }catch (Exception e){
            logger.error("GetFiveDangThread.InitFiveDang:"+e+";"+fivedangString);
        }
        return null;
    }

    @Override
    public void run() {
        System.out.println("===========getfivedang started================");
        while (true){
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            int currentTimeHour = calendar.get(Calendar.HOUR_OF_DAY);
            System.out.println("currenttimehour:"+currentTimeHour);
            int currentTimeMinute= calendar.get(Calendar.MINUTE);
            if(currentTimeHour>=9 && currentTimeHour<=15){
                GetFiveDang();
                try{
                    Thread.sleep(2000);}catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    Thread.sleep(60000);}catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}