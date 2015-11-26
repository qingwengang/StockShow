package Stock.Bll;

import Stock.Bll.Interface.IFiveDangHandler;
import Stock.Entity.FiveDang;

import java.util.Calendar;
import java.util.List;

/**
 * Created by wgqing on 2015/11/24.
 */
public class FiveDangTextHandler implements IFiveDangHandler {
    @Override
    public boolean SaveFiveDangFromMysql(Calendar day, List<FiveDang> toSaveList) {
        boolean result=false;

        return result;
    }
}
