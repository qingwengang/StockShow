package Stock.Dao.Interface;

import Stock.Entity.Ticai;
import Stock.Entity.TicaiStockRelation;

import java.util.List;

/**
 * Created by wgqing on 2015/12/22.
 */
public interface ITicaiStockRelationDao {
    void AddTicaiStockRelation(TicaiStockRelation deal);
    List<TicaiStockRelation> Query(String sql);
    void UpdateRelation(TicaiStockRelation relation);
}
