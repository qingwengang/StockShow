package Frame;
import Util.CastUtil;

import java.util.*;
/**
 * Created by wgqing on 2016/1/16.
 */
public class Param {
    private Map<String,Object> paramMap;
    public Param(Map<String,Object> paramMap){
        this.paramMap=paramMap;
    }
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }
    public Map<String,Object> getMap(){
        return paramMap;
    }
}
