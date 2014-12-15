package com.spiderserver.controller;

import com.spiderserver.dao.SchemaInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by apoptoxin on 2014/12/15.
 */
public class DeleteSchemaController implements Controller {
    @Autowired
    private SchemaInfoMapper schemaInfoMapper;
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        schemaInfoMapper.deleteSchema(id);
        return new ModelAndView("redirect:/showAllSchema.do");
    }
}
