package Util;

import org.apache.commons.lang.ArrayUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by wgqing on 2016/1/15.
 */
public class CollectionUtil {
    public static boolean isNotEmpty(Collection col){
        return col!=null && (!col.isEmpty());
    }
    public static boolean isNotEmpty(Map map){
        return !map.isEmpty();
    }
    public static boolean isNotEmpty(Object[] os){
        return ArrayUtils.isNotEmpty(os);
    }
}
