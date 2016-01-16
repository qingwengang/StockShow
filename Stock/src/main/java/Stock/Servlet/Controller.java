package Stock.Servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wgqing on 2015/12/22.
 */
public class Controller {
    public String test(HttpServletRequest request, HttpServletResponse response){
        String path=request.getRequestURI();
        return path;
    }
}
