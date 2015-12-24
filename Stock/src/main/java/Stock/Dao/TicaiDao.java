package Stock.Dao;

import Stock.Dao.Interface.ITicaiDao;
import Stock.Entity.Ticai;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wgqing on 2015/12/22.
 */
public class TicaiDao implements ITicaiDao {
    @Override
    public void AddTicai(Ticai tc) {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.save(tc);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Ticai> Query(String sql) {
        List l;
        List<Ticai> result=new LinkedList<Ticai>();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        l=session.createSQLQuery(sql).addEntity(Ticai.class).list();
        for (Object o : l) {
            result.add((Ticai)o);
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
