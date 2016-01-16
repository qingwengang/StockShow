package Stock.Start;

import Stock.Threads.GetHistoryThread;

/**
 * Created by wgqing on 2015/10/22.
 */
public class GetHistoryStart {
    public static void main(String[] args){
        GetHistoryThread th = new GetHistoryThread(2014,2015);
		for (int i = 0; i < 30; i++) {
			Thread t1 = new Thread(th);
			t1.start();
		}
    }
}
