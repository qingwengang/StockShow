package Stock.Dao.Interface;

import Stock.Entity.StockAnalysis;

import java.util.List;

/**
 * Created by wgqing on 2015/12/23.
 */
public interface IStockAnalysisDao {
    void AddStockAnalysis(StockAnalysis analysis);
    List<StockAnalysis> Query(String sql);
    void Update(StockAnalysis info);
}
