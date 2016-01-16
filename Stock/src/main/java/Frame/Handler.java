package Frame;

import java.lang.reflect.Method;

/**
 * Created by wgqing on 2016/1/15.
 */
public class Handler {
    private Class<?> controllerClass;
    private Method actionMethod;
    public Handler(Class<?> controllerClass,Method actionMethod){
        this.controllerClass=controllerClass;
        this.actionMethod=actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
