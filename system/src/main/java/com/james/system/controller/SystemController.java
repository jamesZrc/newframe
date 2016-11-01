package com.james.system.controller;

import com.james.controller.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by eronzen on 10/28/2016.
 */
@Controller
@RequestMapping("/sys")
public class SystemController extends BaseController {

    static{

        System.out.print("--------------------");
    }

    @RequestMapping("/test")
    public void test(){
        logger.error("this is a test for error");
        logger.warn("this is a test for warnning");
        logger.info("this is a test for info");
        logger.debug("this is a test for debug");
    }

}
