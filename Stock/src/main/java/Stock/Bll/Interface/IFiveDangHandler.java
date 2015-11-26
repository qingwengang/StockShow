package Stock.Bll.Interface;

import Stock.Entity.FiveDang;

import java.util.Calendar;
import java.util.List;

/**
 * Created by wgqing on 2015/11/24.
 */
public interface IFiveDangHandler {
    boolean SaveFiveDangFromMysql(Calendar day,List<FiveDang> toSaveList);
}
