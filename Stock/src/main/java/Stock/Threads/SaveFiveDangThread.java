package Stock.Threads;

import Stock.DO.HistoryFiveDangQueue;
import Stock.Dao.FiveDangDao;
import Stock.Entity.FiveDang;

import java.util.List;

/**
 * 保存五档数据
 */
public class SaveFiveDangThread  implements Runnable {
    private HistoryFiveDangQueue history;

    public void SetHistoryFiveDangQueue(HistoryFiveDangQueue history) {
        this.history = history;
    }

    private void SaveFiveDang() {
        System.out.println("savefivedang+++++++++");
        List<FiveDang> fiveDangList = history.GetHistoryList(1000);
        while (fiveDangList!=null && fiveDangList.size()>0){
            FiveDangDao.AddFiveDang(fiveDangList);
            fiveDangList = history.GetHistoryList(1000);
        }
    }

    @Override
    public void run() {

        while (true) {
            System.out.print("save=====");
            SaveFiveDang();
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
