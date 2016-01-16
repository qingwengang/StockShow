package Frame;

import Frame.Annotation.Controller;
import Frame.Annotation.Service;
import Util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wgqing on 2016/1/15.
 */
public class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;
    static {
        String packageName="Stock";
        CLASS_SET= ClassUtil.getClassSet(packageName);
    }

    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET){
            if(cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        for(Class<?> cls : CLASS_SET){
            if(cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> classSet=new HashSet<Class<?>>();
        classSet.addAll(getControllerClassSet());
        classSet.addAll(getServiceClassSet());
        return classSet;
    }
}
