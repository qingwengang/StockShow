//import com.ctrip.framework.clogging.agent.MessageManager;
//import com.ctrip.framework.clogging.agent.config.LogConfig;
//import com.ctrip.framework.clogging.agent.log.ILog;
//import com.ctrip.framework.clogging.agent.log.LogManager;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by wgqing on 2015/10/29.
 */
public class LogTest {
//    private static final ILog logger = LogManager.getLogger(LogTest.class);
//
//    static {
//        //set appId and collector server address
//        LogConfig.setAppID("100000742");
//        LogConfig.setLoggingServerIP("http://soa.fws.qa.nt.ctripcorp.com/SOA.ESB/Ctrip.SOA.ESB.asmx");
//        LogConfig.setLoggingServerPort("63100");
//    }
//
//    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
//        // log a English debug message
//        logger.debug("This is a debug log");
//
//        //log a Chinese debug message
//        logger.debug("这是一个测试日志!!!!!!副书记坷");
//
//
//        //log a info level log message with title
//        logger.info("hello", "hello world");
//
//        //log a warn level log message with title
//        logger.warn("warn", "something bad will happen");
//
//        // misc log
//        logger.info("test xml", "<a>this is a test xml<b>hello world</b></a>");
//
//        try {
//            doSomething();
//        } catch (Exception e) {
//            //throw an exception
//            logger.error("error", e);
//        }
//        //log a fatal log message
//        logger.fatal("this is the end of the world!");
//        Map<String, String> attributes = new HashMap<String, String>();
//        attributes.put("searchengine.resultcount", "131");
//        attributes.put("searchengine.searchword", "没想到呀");
//        attributes.put("searchengine.usedtime", "13");
//        logger.info("test message", attributes);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            //do nothing
//        }
//        MessageManager.getInstance().shutdown();
//        System.out.println("Logging demo finished ...");
////        System.exit(0);
//    }
//
//    //mock a exception
//    private static void doSomething() throws Exception {
//        throw new Exception("just throw this exception");
//    }
}
