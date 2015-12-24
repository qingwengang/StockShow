package Stock.Dao;

import Stock.Dao.Interface.ITicaiStockRelationDao;
import Stock.Entity.Ticai;
import Stock.Entity.TicaiStockRelation;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wgqing on 2015/12/22.
 */
public class TicaiStockRelationDao implements ITicaiStockRelationDao {
    @Override
    public void AddTicaiStockRelation(TicaiStockRelation deal) {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.save(deal);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<TicaiStockRelation> Query(String sql) {
        List l;
        List<TicaiStockRelation> result=new LinkedList<TicaiStockRelation>();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        l=session.createSQLQuery(sql).addEntity(TicaiStockRelation.class).list();
        for (Object o : l) {
            result.add((TicaiStockRelation)o);
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public void UpdateRelation(TicaiStockRelation relation) {
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.update(relation);
        session.getTransaction().commit();
        session.close();
    }
}
