package Frame;
import Frame.Annotation.Action;
import Util.CollectionUtil;
import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wgqing on 2016/1/15.
 */
public class ControllerHelper {
    private static final Map<Request,Handler> ACTION_MAP=new HashMap<Request,Handler>();
    static {
        Set<Class<?>> controllerClassSet=ClassHelper.getControllerClassSet();
        if(CollectionUtil.isNotEmpty(controllerClassSet)){
            for(Class<?> controllerClass : controllerClassSet){
                Method[] methods=controllerClass.getDeclaredMethods();
                if(CollectionUtil.isNotEmpty(methods)){
                    for(Method method : methods){
                        if(method.isAnnotationPresent(Action.class)){
                            Action action=method.getAnnotation(Action.class);
                            String mapping= action.value();
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] array=mapping.split(":");
                                if(ArrayUtils.isNotEmpty(array)&& array.length==2){
                                    String requestMethod=array[0];
                                    String requestPath=array[1];
                                    Request request=new Request(requestMethod,requestPath);
                                    Handler handler=new Handler(controllerClass,method);
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request=new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }
}
