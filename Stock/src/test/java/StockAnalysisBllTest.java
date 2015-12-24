import Stock.Bll.StockAnalysisBll;
import Stock.DO.StockAnalysisDo;

import java.util.List;

/**
 * Created by wgqing on 2015/12/23.
 */
public class StockAnalysisBllTest {
    public static void main(String[] args){
//        StockAnalysisBll bll=new StockAnalysisBll();
//        List<StockAnalysisDo> dos= bll.GetStockAnalysisByTicai(3);
//        System.out.println(dos);
//        System.out.println(dos.get(0).getBuyPrice());
//        System.out.print(dos.get(0).getPlanBuyPrice());
        new StockAnalysisBll().GetStockAnalusisByCode("600031");
    }
}
