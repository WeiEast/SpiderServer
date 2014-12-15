package com.spiderserver.controller;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by apoptoxin on 2014/12/15.
 */
public class ShowEditController implements Controller {
    public final Logger logger = Logger.getLogger(this.getClass());
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("/edit");
    }
}
