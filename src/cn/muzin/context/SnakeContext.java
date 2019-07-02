package cn.muzin.context;

import cn.muzin.entity.Snake;
import cn.muzin.entity.SnakeBody;

import java.util.HashMap;
import java.util.Map;

public class SnakeContext {

    private static SnakeContext _self = null;

    public Map<String, Object> maps = new HashMap<String, Object>();

    private SnakeContext(){ }

    public static SnakeContext getInstance(){
        if(_self == null){
            _self = new SnakeContext();
        }
        return _self;
    }

    public Object getContext(String name){
        return maps.get(name);
    }

    public SnakeContext setContext(String name, Object val){
        maps.put(name, val);
        return this;
    }

}
