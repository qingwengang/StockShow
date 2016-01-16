package Controller;

import Stock.Bll.Interface.IStockAnalysisBll;
import Stock.Bll.Interface.ITicaiBll;
import Stock.Bll.StockAnalysisBll;
import Stock.Bll.TicaiBll;
import Stock.DO.StockAnalysisDo;
import Stock.Entity.StockAnalysis;
import Stock.Entity.Ticai;
import Stock.Entity.TicaiStockRelation;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wgqing on 2015/12/23.
 */
public class TicaiController {
    private ITicaiBll ticaiBll=new TicaiBll();
    private IStockAnalysisBll analysisBll=new StockAnalysisBll();
    public String action(HttpServletRequest req, HttpServletResponse resp){
        return "hehehe";
    }
    public String action(){
        return "hehehe";
    }
    public String getTicai(HttpServletRequest req, HttpServletResponse resp){
        String ticaitype=req.getParameter("ticaitype")==null?"":req.getParameter("ticaitype");
        List<Ticai> tcs= ticaiBll.getTicaiList(ticaitype);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        JSONArray object=JSONArray.fromObject(tcs,jsonConfig);
        return object.toString();
    }
    public String addTicaiStock(HttpServletRequest req, HttpServletResponse resp){
        String message="success";
        try{
        TicaiStockRelation relation=new TicaiStockRelation();
        String id=req.getParameter("id")==null?"":req.getParameter("id");
        String code=req.getParameter("code")==null?"":req.getParameter("code");
        relation.setStockCode(code);
        relation.setTicaiId(Integer.parseInt(id));
        relation.setLevel(4);
        ticaiBll.addTicaiStockRelation(relation);}catch (Exception e){
            message=e.getMessage();
        }
        return message;
    }
    public String GetStockAnalysisByTicaiId(HttpServletRequest req, HttpServletResponse resp){
        String sId=req.getParameter("id")==null?"":req.getParameter("id");
        int id=Integer.parseInt(sId);
        List<StockAnalysisDo> dos=analysisBll.GetStockAnalysisByTicai(id);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        JSONArray object=JSONArray.fromObject(dos, jsonConfig);
        return object.toString();
    }
    public String ModifyRelationLevel(HttpServletRequest req, HttpServletResponse resp){
        String sId=req.getParameter("id")==null?"":req.getParameter("id");
        String sAddLevel=req.getParameter("addLevel")==null?"":req.getParameter("addLevel");
        int id=Integer.parseInt(sId);
        int addLevel=Integer.parseInt(sAddLevel);
        ticaiBll.modifyTicaiRelationLevel(id,addLevel);
        return "success";
    }
    public String GetStockAnalysisByRelationId(HttpServletRequest req, HttpServletResponse resp){
        String sId=req.getParameter("id")==null?"":req.getParameter("id");
        int id=Integer.parseInt(sId);
        StockAnalysisDo analysisDo=analysisBll.GetStockAnalysisByTicaiStockRelationID(id);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        JSONArray object=JSONArray.fromObject(analysisDo, jsonConfig);
        return object.toString();
    }
    public String EditStockAnalysis(HttpServletRequest req, HttpServletResponse resp){
        String message="success";
        try{
        String code=req.getParameter("code")==null?"":req.getParameter("code");
        String ssupportPrice=req.getParameter("supportPrice")==null?"":req.getParameter("supportPrice");
        double supportPrice=Double.parseDouble(ssupportPrice);
        String spressurePrice=req.getParameter("pressurePrice")==null?"":req.getParameter("pressurePrice");
        double pressurePrice=Double.parseDouble(spressurePrice);
        String splanBuyPrice=req.getParameter("planBuyPrice")==null?"":req.getParameter("planBuyPrice");
        double planBuyPrice=Double.parseDouble(splanBuyPrice);
        String splanSellPrice=req.getParameter("planSellPrice")==null?"":req.getParameter("planSellPrice");
        double planSellPrice=Double.parseDouble(splanSellPrice);
        String sbuyPrice=req.getParameter("buyPrice")==null?"":req.getParameter("buyPrice");
        double buyPrice=Double.parseDouble(sbuyPrice);
        StockAnalysis analysis=new StockAnalysis();
        analysis.setCode(code);
        analysis.setSupportPrice(supportPrice);
        analysis.setPressurePrice(pressurePrice);
        analysis.setPlanBuyPrice(planBuyPrice);
        analysis.setPlanSellPrice(planSellPrice);
        analysis.setBuyPrice(buyPrice);
        analysisBll.editStockAnalysis(analysis);}catch (Exception e){
            message=e.getMessage();
        }
        return message;
    }
}
