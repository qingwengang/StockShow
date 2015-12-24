package Stock.Dao;

import Stock.Dao.Interface.IStockAnalysisDao;
import Stock.Entity.StockAnalysis;
import Stock.Entity.StockInfo;
import Stock.Entity.Ticai;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wgqing on 2015/12/23.
 */
public class StockAnalysisDao implements IStockAnalysisDao {
    @Override
    public void AddStockAnalysis(StockAnalysis analysis) {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.save(analysis);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<StockAnalysis> Query(String sql) {
        List l;
        List<StockAnalysis> result=new LinkedList<StockAnalysis>();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        l=session.createSQLQuery(sql).addEntity(StockAnalysis.class).list();
        for (Object o : l) {
            result.add((StockAnalysis)o);
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }
    @Override
    public void Update(StockAnalysis info){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.update(info);
        session.getTransaction().commit();
        session.close();
    }
}
