package Stock.Dao.Interface;

import Stock.Entity.FiveDang;

import java.util.Calendar;
import java.util.List;

/**
 * Created by wgqing on 2015/11/24.
 */
public interface IFiveDangDao {
    List<FiveDang> GetFiveDang(Calendar day,String symbol);
    boolean DeleteFiveDang(List<FiveDang> fiveDangs);
    FiveDang GetFirstFiveDang(Calendar day);
}
