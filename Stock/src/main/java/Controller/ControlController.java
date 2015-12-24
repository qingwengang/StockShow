package Controller;

import Start.GetStockInfoStart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wgqing on 2015/12/24.
 */
public class ControlController {
    public String getStockInfoNew(HttpServletRequest req, HttpServletResponse resp){
        GetStockInfoStart.getStockInfoNew();
        return "success";
    }
}
