import java.util.Date;

/**
 * Created by wgqing on 2015/11/3.
 */
public class SimpleFormatThread implements Runnable {
    @Override
    public void run() {

        while (true) {
            try {
                Date da = SimpleFormatUtil.GetDateTimeByString("2015-12-12 12:12:12");
//                System.out.println(da);
            } catch (Exception e) {
                System.out.println("============================SimpleFormat Test Exception:" + e);
            }
        }

    }
}
