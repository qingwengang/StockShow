package Stock.Threads;

import Stock.Bll.Interface.IFiveDangHandler;
import Stock.Dao.Interface.IFiveDangDao;
import Stock.Entity.FiveDang;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.List;

/**
 * Created by wgqing on 2015/11/24.
 */
public class SaveFiveDangToTextThread implements Runnable {
    private static Logger logger = Logger.getLogger(SaveFiveDangToTextThread.class);
    private IFiveDangDao fiveDangDao;
    private IFiveDangHandler handler;
    @Override
    public void run() {
        Calendar calendar=Calendar.getInstance();
        FiveDang fiveDang=fiveDangDao.GetFirstFiveDang(calendar);
        while (fiveDang!=null){
            List<FiveDang> toSaveList=fiveDangDao.GetFiveDang(calendar,fiveDang.getSymbol());
            if(handler.SaveFiveDangFromMysql(calendar,toSaveList)){
                fiveDangDao.DeleteFiveDang(toSaveList);
            }else{
                logger.error("SaveFiveDangToTextThread ERROR:"+toSaveList.get(0).getSymbol());
            }
            fiveDang=fiveDangDao.GetFirstFiveDang(calendar);
        }
    }
}
