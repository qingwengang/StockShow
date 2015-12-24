package MVC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by wgqing on 2015/12/22.
 */

public class HandlerServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getRequestURI();
        String controllerName=path.substring(path.lastIndexOf('/') + 1);
        String controllerClassName;
        String controllerFunName;
        String message="error";
        if(controllerName.indexOf('.')>0){
            controllerClassName=controllerName.substring(0,controllerName.indexOf('.'));
            controllerFunName=controllerName.substring(controllerName.indexOf('.')+1);
        }else{
            controllerClassName=controllerName;
            controllerFunName="action";
        }
        try {
            Class c=Class.forName("Controller." + controllerClassName);
            Object obj1=c.newInstance();
            Class[] param=new Class[2];
            param[0]=HttpServletRequest.class;
            param[1]=HttpServletResponse.class;
            Method m=c.getMethod(controllerFunName,param);
            message=(String)m.invoke(obj1,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.write(message);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
