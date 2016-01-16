package Frame;

import java.util.Map;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by wgqing on 2016/1/15.
 */
public class BeanHelper {
    private static final Map<Class<?>,Object> BEAN_MAP=new HashMap<Class<?>,Object>();
    static{
        Set<Class<?>> beanClassSet=ClassHelper.getBeanClassSet();
        for(Class<?> cls:beanClassSet){
            Object obj=ReflectionUtil.newInstance(cls);
            BEAN_MAP.put(cls,obj);
        }
    }
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cls){
        if(!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean by class:"+cls);
        }
        return (T)BEAN_MAP.get(cls);
    }

}
