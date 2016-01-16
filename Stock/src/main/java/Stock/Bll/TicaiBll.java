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

    public void addTicai(Ticai ticai){
        String sql=String.format("select * from ticai where url='%s'",ticai.getUrl());
        List<Ticai> ticais=ticaiDao.Query(sql);
        if(ticais==null ||ticais.size()==0){
            ticaiDao.AddTicai(ticai);
        }
    }

    @Override
    public void addTicaiStockRelation(TicaiStockRelation relation) {
        String sql = String.format("SELECT * from ticaistockrelation where TicaiId=%s and StockCode='%s'", relation.getTicaiId(), relation.getStockCode());
        List<TicaiStockRelation> rels = relationDao.Query(sql);
        if (rels == null || rels.size() == 0) {
            relationDao.AddTicaiStockRelation(relation);
            if (analysisBll.GetStockAnalusisByCode(relation.getStockCode()) == null) {
                StockAnalysis analysis = new StockAnalysis();
                analysis.setCode(relation.getStockCode());
                analysisBll.addStockAnalysis(analysis);
            }
        }
    }

    @Override
    public List<Ticai> getTicaiList(String ticaitype) {
        String sql="select * from ticai where status=1 and ticaitype="+ticaitype;
        List<Ticai> tcs= ticaiDao.Query(sql);
        return tcs;
    }
}
