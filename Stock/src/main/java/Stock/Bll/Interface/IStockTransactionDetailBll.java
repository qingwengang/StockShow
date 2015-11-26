package Stock.Bll.Interface;

import Stock.Entity.StockTransactionDetail;

import java.util.List;

/**
 * Created by wgqing on 2015/11/4.
 */
public interface IStockTransactionDetailBll {
    List<StockTransactionDetail> GetTransactionDetailBySymbol(String symbol);
}
