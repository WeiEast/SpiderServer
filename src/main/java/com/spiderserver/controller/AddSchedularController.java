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
        //name
        String name = request.getParameter("name");
        //cycle
        long cycle = Long.parseLong(request.getParameter("day"))*24+Long.parseLong(request.getParameter("hour"));
        //schedular
        String schedularId[] = request.getParameterValues("schedularId");
        String fetchsource[] = request.getParameterValues("fetchsource");
        String fetchtype[] = request.getParameterValues("fetchtype");
        String fetchmode[] = request.getParameterValues("fetchmode");
        String fetchtemplate[] = request.getParameterValues("fetchtemplate");
        //storage
        String storageId[] = request.getParameterValues("storageId");
        String storagesource[] = request.getParameterValues("storagesource");
        String storagetype[] = request.getParameterValues("storagetype");
        String storagemode[] = request.getParameterValues("storagemode");
        String storagetemplate[] = request.getParameterValues("storagetemplate");

        String schedular = "";
        String storage = "";
        for(int i=0;i<minLength(schedularId,fetchsource,fetchtype,fetchmode,fetchtemplate);i++){
            schedular += ""+schedularId[i]+":"+fetchmode[i]+":"+fetchsource[i]+":"+fetchtype[i]+":"+fetchtemplate[i]+";";
        }
        for(int i=0;i<minLength(storageId,storagesource,storagetype,storagemode,storagetemplate);i++){
            storage += ""+storageId[i]+":"+storagemode[i]+":"+storagesource[i]+":"+storagetype[i]+":"+storagetemplate[i]+";";
        }
        SchemaInfo si = new SchemaInfo(name,schedular,storage,cycle,0);
        schemaInfoMapper.addSchema(si);
        ModelMap map = new ModelMap();
        return new ModelAndView("/show");
    }
    private int minLength(String[] a, String[] b, String[] c,String[] d,String[] e){
        return Math.min(a.length,Math.min(b.length,Math.min(c.length,Math.min(d.length,e.length))));
    }
}
