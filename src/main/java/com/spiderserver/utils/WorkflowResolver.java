package com.spiderserver.utils;

import com.spiderserver.po.Schema;
import com.spiderserver.po.SchemaInfo;
import com.spiderserver.po.Storage;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apoptoxin on 2014/11/27.
 */
public class WorkflowResolver {
    private static Logger logger = Logger.getLogger(WorkflowResolver.class);

    public static Schema constructSchema(SchemaInfo si) {
        if(si==null){
            System.out.println("null");
        }
        String schema = si.getStrategy();
        Map<Integer, Schema> map = new HashMap<Integer, Schema>();
        for (String sentence : schema.split(";")) {
            String t[] = sentence.split(":");
            int id = Integer.parseInt(t[0]);//id
            int way = Integer.parseInt(t[1]);//方式，抓取还是取值
            int source = Integer.parseInt(t[2]);//输入源序号，要比id小
            String mode = t[3];//解析方式
            String path = t[4];//解析路径
            if (source > id || (source == id && id > 1)) {
                logger.error("调度配置有误！！");
                return null;
            }
            Schema s = new Schema(id, way, mode, path);
            map.put(id, s);
            if (id != source) {
                map.get(source).getNext().add(s);
            }
        }
        return map.get(1);
    }

    public static Map<Integer, List<Storage>> constructStorage(SchemaInfo si){
        Map<Integer,List<Storage>> map = new HashMap<Integer, List<Storage>>();
        for(String stor:si.getStor().split(";")){
            String t[] = stor.split(":");
            Storage storage = new Storage(Integer.parseInt(t[0]),t[1],t[2],Integer.parseInt(t[3]),t[4],t[5]);
            if(!map.containsKey(storage.getInput())){
                map.put(storage.getInput(), new ArrayList<Storage>());
            }
            map.get(storage.getInput()).add(storage);
        }
        return map;
    }
}