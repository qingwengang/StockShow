import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wgqing on 2015/11/3.
 */
public class SimpleFormatUtil {
    public static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Date GetDateTimeByString(String date) throws ParseException {
        return sdf1.parse(date);
    }
}
