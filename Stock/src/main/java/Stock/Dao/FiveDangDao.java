package Stock.Dao;

import Stock.Entity.FiveDang;
import Stock.Entity.StockInfo;
import Util.HibernateUtil;
import com.mongodb.DB;
import com.mongodb.Mongo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by wgqing on 2015/10/26.
 */
public class FiveDangDao {
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
}
