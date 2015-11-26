package Stock.Bll;

import java.util.List;

import Stock.Bll.Interface.IStockTransactionDetailBll;
import Stock.Dao.StockTransactionDetailDao;
import Stock.Entity.StockTransactionDetail;
import Util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class StockTransactionDetailBll implements IStockTransactionDetailBll {

	public static List<StockTransactionDetail> GetUnGetIntradayDataDetails(int num){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.getTransaction().begin();
		Criteria c=session.createCriteria(StockTransactionDetail.class);
		c.add(Restrictions.eq("ifGetIntradayData", 0));
		c.setFirstResult(0);
		c.setMaxResults(num);
		List<StockTransactionDetail> sss = c.list();
		for (StockTransactionDetail stockTransactionDetail : sss) {
			stockTransactionDetail.setIfGetIntradayData(2);
			StockTransactionDetailDao.UpdateCategory(stockTransactionDetail);
		}
		session.getTransaction().commit();
		session.close();
		return sss;
	}
	public static List<StockTransactionDetail> GetUnAnalyIntradayDataDetails(int num){
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		session.getTransaction().begin();
		Criteria c=session.createCriteria(StockTransactionDetail.class);
		c.add(Restrictions.eq("ifAnalyIntradayData", 0));
		c.setFirstResult(0);
		c.setMaxResults(num);
		List<StockTransactionDetail> sss = c.list();
		for (StockTransactionDetail stockTransactionDetail : sss) {
			stockTransactionDetail.setIfGetIntradayData(2);
			StockTransactionDetailDao.UpdateCategory(stockTransactionDetail);
		}
		session.getTransaction().commit();
		session.close();
		return sss;
	}

	@Override
	public List<StockTransactionDetail> GetTransactionDetailBySymbol(String symbol) {
		return null;
	}
}
