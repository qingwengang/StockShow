package Stock.Bll.Interface;

import Stock.DO.StockAnalysisDo;
import Stock.Entity.StockAnalysis;

import java.util.List;

/**
 * Created by wgqing on 2015/12/23.
 */
public interface IStockAnalysisBll {
    void addStockAnalysis(StockAnalysis analysis);
    void editStockAnalysis(StockAnalysis analysis);
    StockAnalysis GetStockAnalusisByCode(String code);
    List<StockAnalysisDo> GetStockAnalysisByTicai(int TicaiId);
    StockAnalysisDo GetStockAnalysisByTicaiStockRelationID(int TicaiStockRelationId);
}
