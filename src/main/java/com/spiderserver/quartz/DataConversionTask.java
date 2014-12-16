package com.spiderserver.quartz;

import com.spiderserver.dao.SchemaInfoMapper;
import com.spiderserver.parser.Parser;
import com.spiderserver.po.Schema;
import com.spiderserver.po.SchemaInfo;
import com.spiderserver.po.Storage;
import com.spiderserver.utils.WorkflowResolver;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apoptoxin on 2014/12/15.
 */
public class DataConversionTask {
    //使用Autowired注解的变量若要使用，其所在的类也要是一个bean,这里使用手动装配吧，但是XmlBeanFactory方法是失效方法，需要寻找替代
    private SchemaInfoMapper schemaInfoMapper = (SchemaInfoMapper) new ClassPathXmlApplicationContext("ApplicationContext.xml").getBean("schemaInfoMapper");

    private static final Logger LOG = Logger.getLogger(DataConversionTask.class);
    private static int counter = 0;
    /*
    调度策略：每个小时起一次调度，然后构造抓取流程，并判断该抓取是否应该起调度且上一次的抓取已完成，
    若该抓取正在进行，则跳过本次调度
     */
    public void run() {
        Schema schema = WorkflowResolver.constructSchema(schemaInfoMapper.getSchemaInfoById(6));
        System.out.println(schema.getId());
    }
    public void construct(){
        for(SchemaInfo si: schemaInfoMapper.getAllSchema()){
            //起线程调度？？？
            if(si.getStat()==0) {//0表示waiting，1表示running
                Schema schema = WorkflowResolver.constructSchema(si);
                Map<Integer,List<Storage>> storage = WorkflowResolver.constructStorage(si);
                startSchedular(schema,storage);
            }
        }
    }

    private void startSchedular(Schema schema, Map<Integer, List<Storage>> storage) {
        Map<String,String> content = new HashMap<String, String>();
        //修改数据库，设该抓取计划状态为running
        fetch(schema,storage,content);
        //修改数据库，设该抓取计划状态为waiting
    }

    private synchronized void fetch(Schema schema, Map<Integer, List<Storage>> storage, Map<String, String> content) {
        assert (schema!=null);

        Object result = null;
        /*
        *方式与解析方式相配合，抓取只支持xpath，取值支持全部
        *str表示单纯的字符串，不做任何处理，用于抓取特定url
        *xpath解析页面内容，用于抓取过程中，下一步的url是从当前抓取页面中解析出来的
        *regex为正则表达式，用于下一步url从当前页面中解析，弥补xpath解析的不足
        ****************************************************************************************
        *可以理解为，抓取之后Object的结果是一个HtmlUnit，取值之后，结果是一个String，尽量是，一个抓取之后跟一个取值
        *表示抓取出一个HmtlUnit，在HtmlUnit中取出下一步抓取所需的url的String
        */
        switch (schema.getWay()) {/*1表示抓取，2表示取值*/
            case 1://抓取，结果赋值给result;只支持xpath
                break;
            case 2://取值，结果赋值给result；支持xpath,regex和str，str其实就是啥也不做，o(╯□╰)o
                result = parse(result,schema.getMode(),schema.getSource());
                break;
            default:
                break;
        }
        if(storage.containsKey(schema.getId())){
            for(Storage s:storage.get(schema.getId())){
                content.put(s.getName(),parse(result,s.getMode(),s.getSource()));
            }
        }
        if(schema.getNext()==null||schema.getNext().isEmpty()){
//            store(content);//存储
        }
        for(Schema next:schema.getNext()){
            fetch(next,storage,content);
        }
    }

    private String parse(Object result, String mode, String source){
        //switch表达式不能为String类型
        String className = "com.spiderserver.parser.impl"+mode.substring(0,1).toUpperCase()+mode.substring(1).toLowerCase()+"Parser";
        Parser parser = null;
        try {
            parser = (Parser) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return parser.parser(result,source).toString();
    }
}
