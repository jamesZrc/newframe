package com.james;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by eronzen on 10/28/2016.
 */
@Controller
@RequestMapping("/base")
public class TestController {
    static {
        System.out.print("testController start");
    }

    @RequestMapping(value="/test")
    public void test(){
        String test = "asfaf";
        int ss = 12313;
        Boolean bbb = false;
        char cc = 'V';
        System.out.print("=================================================");
    }
}
