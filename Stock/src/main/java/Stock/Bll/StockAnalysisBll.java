package Stock.Bll;

import Stock.Bll.Interface.IStockAnalysisBll;
import Stock.DO.StockAnalysisDo;
import Stock.Dao.Interface.IStockAnalysisDao;
import Stock.Dao.StockAnalysisDao;
import Stock.Entity.StockAnalysis;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by wgqing on 2015/12/23.
 */
public class StockAnalysisBll implements IStockAnalysisBll {
    private static IStockAnalysisDao dao=new StockAnalysisDao();
    @Override
    public void addStockAnalysis(StockAnalysis analysis) {
        dao.AddStockAnalysis(analysis);
    }

    @Override
    public void editStockAnalysis(StockAnalysis analysis) {
        StockAnalysis analysis1=GetStockAnalusisByCode(analysis.getCode());
        analysis1.setSupportPrice(analysis.getSupportPrice());
        analysis1.setPressurePrice(analysis.getPressurePrice());
        analysis1.setPlanBuyPrice(analysis.getPlanBuyPrice());
        analysis1.setPlanSellPrice(analysis.getPlanSellPrice());
        analysis1.setBuyPrice(analysis.getBuyPrice());
        dao.Update(analysis1);
    }

    @Override
    public StockAnalysis GetStockAnalusisByCode(String code) {
        String sql=String.format("select * from stockanalysis where code='%s'",code);
        List<StockAnalysis> analysisList = dao.Query(sql);
        if(analysisList.size()>0){
            return analysisList.get(0);
        }
        return  null;
    }

    @Override
    public List<StockAnalysisDo> GetStockAnalysisByTicai(int TicaiId) {
        String sql="select ticaistockrelation.Id,stockanalysis.code,stockinfo.Name,0 as CurrentPrice,stockanalysis.PlanBuyPrice,stockanalysis.PlanSellPrice,stockanalysis.BuyPrice,stockanalysis.PressurePrice,stockanalysis.SupportPrice,ticaistockrelation.Level,stockinfo.Symbol \n" +
                "from stockanalysis inner join stockinfo\n" +
                "on stockinfo.code=stockanalysis.code \n" +
                "inner join ticaistockrelation on ticaistockrelation.stockcode=stockinfo.code\n" +
                "inner join ticai on ticai.Id=ticaistockrelation.TicaiId\n" +
                "where ticai.id="+TicaiId;
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        List<StockAnalysisDo> dos=session.createSQLQuery(sql).addEntity(StockAnalysisDo.class).list();
        return dos;
    }

    @Override
    public StockAnalysisDo GetStockAnalysisByTicaiStockRelationID(int TicaiStockRelationId) {
        String sql="select ticaistockrelation.Id,stockanalysis.code,stockinfo.Name,0 as CurrentPrice,stockanalysis.PlanBuyPrice,stockanalysis.PlanSellPrice,stockanalysis.BuyPrice,stockanalysis.PressurePrice,stockanalysis.SupportPrice,ticaistockrelation.Level,stockinfo.Symbol \n" +
                "from stockanalysis inner join stockinfo\n" +
                "on stockinfo.code=stockanalysis.code \n" +
                "inner join ticaistockrelation on ticaistockrelation.stockcode=stockinfo.code\n" +
                "inner join ticai on ticai.Id=ticaistockrelation.TicaiId\n" +
                "where ticaistockrelation.id="+TicaiStockRelationId;
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        List<StockAnalysisDo> dos=session.createSQLQuery(sql).addEntity(StockAnalysisDo.class).list();
        return dos.size()>0?dos.get(0):null;
    }
}
