package Stock.Start;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Stock.Dao.StockInfoDao;
import Stock.Entity.StockInfo;
import Util.JsoupUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;


/**
 * Created by wgqing on 2015/10/22.
 */
public class GetStockInfoStart {
    public static void main(String[] args) {
        getStockInfoNew();
    }
    public static void getStockInfoNew(){
        System.out.println("getStockInfoNew start");
        String url = "http://guba.eastmoney.com/remenba.aspx?type=1";
        Document doc = JsoupUtil.GetDocument(url);
        Elements lis=doc.select(".gbboxb").get(1).select(".ngbglistdiv").get(0).getElementsByTag("li");
        Elements liss=doc.select(".gbboxb").get(1).select(".ngbglistdiv").get(2).getElementsByTag("li");
        for (Element li : lis) {
            String desc=li.text();
            String code=desc.substring(1, 7);
            String name=desc.substring(8, desc.length());
            StockInfo si = new StockInfo();
            si.setCode(code);
            si.setName(name);
            si.setNewPrice(0);
            si.setVolume(0);
            if(code.startsWith("6")){
                si.setSymbol("sh"+code);
            }else{
                si.setSymbol("sz"+code);
            }
            si.setIfGetHistory(0);
            si.setIfSetVolumeRate(0);
            StockInfoDao.AddStockInfo(si);
            System.out.println(code+" "+name);
        }
        for (Element li : liss) {
            String desc=li.text();
            String code=desc.substring(1, 7);
            String name=desc.substring(8, desc.length());
            StockInfo si = new StockInfo();
            si.setCode(code);
            si.setName(name);
            si.setNewPrice(0);
            si.setVolume(0);
            if(code.startsWith("6")){
                si.setSymbol("sh"+code);
            }else{
                si.setSymbol("sz"+code);
            }
            si.setIfGetHistory(0);
            si.setIfSetVolumeRate(0);
            StockInfoDao.AddStockInfo(si);
            System.out.println(code+" "+name);
        }
        System.out.println("getStockInfoNew end");
//		System.out.println(doc.select(".gbboxb").get(1).select(".ngbglistdiv").get(0).getElementsByTag("li"));

    }
}
