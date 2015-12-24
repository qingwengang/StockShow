package Stock.Dao;

import Stock.Dao.Interface.IFiveDangDao;
import Stock.Entity.FiveDang;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wgqing on 2015/10/26.
 */
public class FiveDangDao implements IFiveDangDao {
    @Override
    public FiveDang GetFirstFiveDang(Calendar day) {
        String sql="select * from fivedang where priceTime<'2015-11-10' LIMIT 0,1";
        return null;
    }

    public static void AddFiveDang(FiveDang dang){
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        session.save(dang);
        session.getTransaction().commit();
        session.close();
    }
    public static void AddFiveDang(List<FiveDang> dangList){
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        int i=0;
        for(FiveDang dang : dangList){
            session.save(dang);
            if(i%100==0){
                session.flush();
                session.clear();
            }
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<FiveDang> GetFiveDang(Calendar day, String symbol) {
        List<FiveDang> fiveDangs=new LinkedList<FiveDang>();
        return fiveDangs;
    }
    @Override
    public boolean DeleteFiveDang(List<FiveDang> fiveDangs) {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session session=sf.openSession();
        for(FiveDang dang : fiveDangs){
            session.delete(dang);
        }
        session.close();
        return true;
    }
}
