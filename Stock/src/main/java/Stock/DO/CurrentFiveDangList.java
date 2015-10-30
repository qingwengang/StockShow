package Stock.DO;

import Stock.Entity.FiveDang;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wgqing on 2015/10/28.
 */
    public class CurrentFiveDangList {
    private List<FiveDang> currentList = new LinkedList<FiveDang>();
    private HistoryFiveDangQueue history;

    public CurrentFiveDangList(HistoryFiveDangQueue history) {
        this.history = history;
    }

    public List<FiveDang> GetCurrentList() {
        return currentList;
    }

    public synchronized void Add(FiveDang fiveDang) {
        if (currentList.size() > 0) {
            boolean ifAdd = true;
            for (FiveDang dang : currentList) {
                if (dang.getSymbol().equals(fiveDang.getSymbol())) {
                    ifAdd = false;
                    if (!dang.getPriceTime().equals(fiveDang.getPriceTime())) {
                        currentList.remove(dang);
                        currentList.add(fiveDang);
                        history.Add(fiveDang);
                    }
                    break;
                }
            }
            if (ifAdd) {
                currentList.add(fiveDang);
                history.Add(fiveDang);
                System.out.print(fiveDang);
            }
        } else {
            currentList.add(fiveDang);
            history.Add(fiveDang);
            System.out.print(fiveDang);
        }
    }
}
