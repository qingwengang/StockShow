package Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wgqing on 2015/10/30.
 */
public class DateFormatUtil {
    private static final String date_format="yyyy-MM-dd HH:mm:ss";

    @SuppressWarnings("rawtypes")
    private static ThreadLocal threadLocal=new ThreadLocal(){
        protected synchronized Object initialvalue(){
            return new SimpleDateFormat(date_format);
        }
    };
    public static DateFormat getDateformat(){
        return (DateFormat)threadLocal.get();
    }
    public static Date parse(String textdate) throws ParseException{
        return getDateformat().parse(textdate);
    }
}
