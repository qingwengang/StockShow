package Stock.DO;

import Stock.Entity.FiveDang;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wgqing on 2015/10/28.
 */
public class HistoryFiveDangQueue {
    private Queue<FiveDang> fiveDangs= new LinkedList<FiveDang>();
    public synchronized  List<FiveDang> GetHistoryList(int count){
        List<FiveDang> historyList=new LinkedList<FiveDang>();
        while(fiveDangs.size()>0 && count>0){
            historyList.add(fiveDangs.poll());
            count--;
        }
        return historyList;
    }
    public synchronized void Add(FiveDang fiveDang){
        fiveDangs.add(fiveDang);
    }
    public synchronized void Add(List<FiveDang> fiveDangList){
        fiveDangs.addAll(fiveDangList);
    }
}
