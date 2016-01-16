package Frame;

import Util.ClassUtil;

/**
 * Created by wgqing on 2016/1/16.
 */
public class HelperLoader {
    public static void init(){
        Class<?>[] classList={ClassHelper.class,BeanHelper.class,IocHelper.class,ControllerHelper.class};
        for(Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName(),false);
        }
    }
}
