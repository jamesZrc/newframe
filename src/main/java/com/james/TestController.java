package com.james;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by eronzen on 10/28/2016.
 */
@Controller
@RequestMapping("/base")
public class TestController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping(value="/test")
    public void test(){
        String test = "asfaf";
        int ss = 12313;
        Boolean bbb = false;
        char cc = 'V';
        System.out.print("=================================================");



        logger.error("this is a test for error");
        logger.warn("this is a test for warnning");
        logger.info("this is a test for info");
        logger.debug("this is a test for debug");


    }
}
