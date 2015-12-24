package Stock.Bll;

import Stock.Bll.Interface.IStockAnalysisBll;
import Stock.Bll.Interface.ITicaiBll;
import Stock.Dao.Interface.ITicaiDao;
import Stock.Dao.Interface.ITicaiStockRelationDao;
import Stock.Dao.TicaiDao;
import Stock.Dao.TicaiStockRelationDao;
import Stock.Entity.StockAnalysis;
import Stock.Entity.Ticai;
import Stock.Entity.TicaiStockRelation;

import java.util.List;

/**
 * Created by wgqing on 2015/12/22.
 */
public class TicaiBll implements ITicaiBll {
    private static ITicaiDao ticaiDao=new TicaiDao();
    private static ITicaiStockRelationDao relationDao=new TicaiStockRelationDao();
    private static IStockAnalysisBll analysisBll=new StockAnalysisBll();

    @Override
    public void modifyTicaiRelationLevel(int id, int addLevel) {
        List<TicaiStockRelation> relations=relationDao.Query("select * from ticaistockrelation where id="+id);
        if(relations!=null && relations.size()>0){
            TicaiStockRelation relation=relations.get(0);
            if((addLevel<0 && relation.getLevel()>1)||(addLevel>0 && relation.getLevel()<4)){
                relation.setLevel(relation.getLevel()+addLevel);
            }
            relationDao.UpdateRelation(relation);
        }
    }

    @Override
    public void addTicaiStockRelation(TicaiStockRelation relation) {
        relationDao.AddTicaiStockRelation(relation);
        if(analysisBll.GetStockAnalusisByCode(relation.getStockCode())==null){
            StockAnalysis analysis=new StockAnalysis();
            analysis.setCode(relation.getStockCode());
            analysisBll.addStockAnalysis(analysis);
        }
    }

    @Override
    public List<Ticai> getTicaiList() {
        String sql="select * from ticai where status=1";
        List<Ticai> tcs= ticaiDao.Query("select * from ticai where status=1");
        return tcs;
    }
}
