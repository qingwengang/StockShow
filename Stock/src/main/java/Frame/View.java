package Frame;
import java.util.*;
/**
 * Created by wgqing on 2016/1/16.
 */
public class View {
    private String path;
    private Map<String,Object> model;
    public View(String path){
        this.path=path;
        model=new HashMap<String,Object>();
    }
    public View addModel(String key,Object value){
        model.put(key,value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
