package Stock.Bll.Interface;

import Stock.Entity.Ticai;
import Stock.Entity.TicaiStockRelation;

import java.util.List;

/**
 * Created by wgqing on 2015/12/22.
 */
public interface ITicaiBll {
    List<Ticai> getTicaiList(String ticaitype);
    void addTicaiStockRelation(TicaiStockRelation relation);
    void modifyTicaiRelationLevel(int id,int addLevel);
    void addTicai(Ticai ticai);
}
