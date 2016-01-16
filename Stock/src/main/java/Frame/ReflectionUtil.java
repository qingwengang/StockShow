package Frame;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wgqing on 2016/1/15.
 */
public class ReflectionUtil {
    public static Object newInstance(Class<?> cls){
        Object instance;
        try{
            instance=cls.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return instance;
    }
    public static Object invokeMethod(Object obj,Method method,Object... args){
        Object result;
        try {
            method.setAccessible(true);
            result=method.invoke(obj, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void setField(Object obj,Field field,Object value){
        field.setAccessible(true);
        try {
            field.set(obj,value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
