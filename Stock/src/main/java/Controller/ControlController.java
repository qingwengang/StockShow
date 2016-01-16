package Controller;

import Stock.Start.GetStockInfoStart;
import Stock.Start.GetTicaiFromSinaStart;

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
    public String getTicai(HttpServletRequest req, HttpServletResponse resp){
        GetTicaiFromSinaStart.GetTicai();
        return "success";
    }
    public String getTicaiStockRelation(HttpServletRequest req, HttpServletResponse resp){
        GetTicaiFromSinaStart.GetTicaiRelation();
        return "success";
    }
}
