package com.spiderserver.controller;

import com.spiderserver.dao.SchemaInfoMapper;
import com.spiderserver.po.SchemaInfo;
import com.spiderserver.utils.MysqlConnector;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by apoptoxin on 2014/12/13.
 */
public class AddSchedularController implements Controller{
    public final Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private SchemaInfoMapper schemaInfoMapper;
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String id[] = request.getParameterValues("id");
        String source[] = request.getParameterValues("source");
        String type[] = request.getParameterValues("type");
        String mode[] = request.getParameterValues("mode");
        String template[] = request.getParameterValues("template");
        String schedular = "";
        String storage = "";
        for(int i=0;i<minLength(id,source,type,mode,template);i++){
            schedular += ""+id[i]+":"+mode[i]+":"+source[i]+":"+type[i]+":"+template[i]+"\n";
        }
        SchemaInfo si = new SchemaInfo(name,schedular);
        schemaInfoMapper.addSchema(si);
        ModelMap map = new ModelMap();
        return new ModelAndView("/show");
    }
    private int minLength(String[] a, String[] b, String[] c,String[] d,String[] e){
        return Math.min(a.length,Math.min(b.length,Math.min(c.length,Math.min(d.length,e.length))));
    }
}
