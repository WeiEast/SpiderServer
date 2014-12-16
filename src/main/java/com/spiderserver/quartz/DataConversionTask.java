package com.spiderserver.quartz;

import com.spiderserver.dao.SchemaInfoMapper;
import com.spiderserver.po.Schema;
import com.spiderserver.utils.WorkflowResolver;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by apoptoxin on 2014/12/15.
 */
public class DataConversionTask {
    //使用Autowired注解的变量若要使用，其所在的类也要是一个bean,这里使用手动装配吧，但是XmlBeanFactory方法是失效方法，需要寻找替代
    private SchemaInfoMapper schemaInfoMapper = (SchemaInfoMapper) new ClassPathXmlApplicationContext("ApplicationContext.xml").getBean("schemaInfoMapper");

    private static final Logger LOG = Logger.getLogger(DataConversionTask.class);
    private static int counter = 0;

    public void run() {
        WorkflowResolver wr = new WorkflowResolver();
        System.out.println(counter);
        Schema schema = wr.constructSchema(schemaInfoMapper.getSchemaInfoById(6));
        System.out.println(schema.getId());
    }
}
