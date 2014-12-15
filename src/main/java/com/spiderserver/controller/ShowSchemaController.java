package com.spiderserver.controller;

import com.spiderserver.dao.SchemaInfoMapper;
import com.spiderserver.po.Schema;
import com.spiderserver.po.SchemaInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apoptoxin on 2014/12/5.
 */
public class ShowSchemaController implements Controller{
    public final Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private SchemaInfoMapper schemaInfoMapper;
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("test ok");
        ModelAndView mv = new ModelAndView("/show");
        List<SchemaInfo> list = schemaInfoMapper.getAllSchema();
        mv.addObject("articles",list);
        return mv;
    }
}
