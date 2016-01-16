package Stock.Start;

import Stock.Bll.Interface.ITicaiBll;
import Stock.Bll.TicaiBll;
import Stock.Dao.Interface.ITicaiDao;
import Stock.Dao.Interface.ITicaiStockRelationDao;
import Stock.Dao.TicaiDao;
import Stock.Dao.TicaiStockRelationDao;
import Stock.Entity.Ticai;
import Stock.Entity.TicaiStockRelation;
import Util.JsoupUtil;
import org.jsoup.nodes.Document;

import java.util.List;

/**
 * Created by wgqing on 2015/12/25.
 */
public class GetTicaiFromSinaStart {
    private static ITicaiBll ticaiBll=new TicaiBll();
    private static ITicaiDao ticaiDao=new TicaiDao();
    public static void getTicai(int type){
        String url="";
        String typeName="";
        if(type==1){
            url="http://money.finance.sina.com.cn/q/view/newFLJK.php?param=industry";
            typeName="hangye";
        }else if(type==2){
            url="http://money.finance.sina.com.cn/q/view/newFLJK.php?param=class";
            typeName="gn";
        }
        Document doc=JsoupUtil.GetDocument(url, "gbk");
        String content=doc.body().text();
        String[] contents=content.split(":");
        for(String con : contents){
            System.out.println(con);
            System.out.println(con.indexOf(','));
            if(con.indexOf(',')>0){
                String[] cons=con.replace("\"","").split(",");
                if(cons.length>0){
                    String ticaiurl=cons[0];
                    String name=cons[1];
                    if(name!=null && name.length()>0){
                    Ticai tc=new Ticai();
                    tc.setName(name);
                    tc.setStatus(1);
                    tc.setTicaiType(type);
                    tc.setUrl(ticaiurl);
                    tc.setOrderType(0);
                    tc.setTypeName(typeName);
                    ticaiBll.addTicai(tc);}
                }
            }
        }
    }
    public static void getTicaiRelation(Ticai ticai){
        String url=String.format("http://vip.stock.finance.sina.com.cn/quotes_service/api/json_v2.php/Market_Center.getHQNodeData?page=1&num=800&sort=symbol&asc=1&node=%s&symbol=&_s_r_a=page",ticai.getUrl());
        Document doc=JsoupUtil.GetDocument(url, "gbk");
        String content=doc.body().text();
        String[] cons=content.split(",");
        System.out.println(content);
        for (String con : cons){
            if(con.indexOf("code")==0){
                TicaiStockRelation relation=new TicaiStockRelation();
                relation.setTicaiId(ticai.getId());
                relation.setStockCode(con.substring(con.indexOf("\"") + 1, con.lastIndexOf("\"")));
                relation.setStatus(0);
                relation.setLevel(4);
                ticaiBll.addTicaiStockRelation(relation);
            }
        }
    }
    public static void GetTicaiRelation(){
        String sql="SELECT * from ticai";
        List<Ticai> tcs=ticaiDao.Query(sql);
        for(Ticai tc : tcs){
            getTicaiRelation(tc);
        }
    }
    public static void GetTicai(){
        getTicai(1);
        getTicai(2);
    }
    public static void main(String[] ar){
//        getTicai(2);
        GetTicaiRelation();
    }
}
