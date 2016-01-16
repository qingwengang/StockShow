package Stock.Start;

import Stock.DO.CurrentFiveDangList;
import Stock.DO.HistoryFiveDangQueue;
import Stock.Dao.StockInfoDao;
import Stock.Entity.StockInfo;
import Stock.Threads.GetFiveDangThread;
import Stock.Threads.SaveFiveDangThread;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wgqing on 2015/10/28.
 */
public class GetFiveDangStart {
    public  static  void main(String[] args){
        GetFiveDang();
    }
    public  static void GetFiveDang(){
        List<StockInfo> infoList= StockInfoDao.Query("select * from stockinfo");
        int getThreadCount=(infoList.size()+699)/700;

        for(int i=0;i<getThreadCount;i++){
            HistoryFiveDangQueue historyFiveDangQueue=new HistoryFiveDangQueue();
            CurrentFiveDangList currentFiveDangList= new CurrentFiveDangList(historyFiveDangQueue);
            GetFiveDangThread getFiveDangThread=new GetFiveDangThread();
            List<String> symbols=new LinkedList<>();
            for(StockInfo info : infoList.subList(i*700,(i+1)*700>infoList.size()?infoList.size():(i+1)*700)){
                symbols.add(info.getSymbol());
            }
            getFiveDangThread.Init(currentFiveDangList, symbols);
            Thread th=new Thread(getFiveDangThread);
            th.start();
            SaveFiveDangThread saveFiveDangThread=new SaveFiveDangThread();
            saveFiveDangThread.SetHistoryFiveDangQueue(historyFiveDangQueue);
            Thread ts=new Thread(saveFiveDangThread);
            ts.start();
        }
    }
}
