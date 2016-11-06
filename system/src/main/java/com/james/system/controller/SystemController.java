package com.james.system.controller;

import com.james.controller.base.controller.BaseController;
import com.james.system.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by eronzen on 10/28/2016.
 */
@Controller
@RequestMapping("/sys")
public class SystemController extends BaseController {

    @RequestMapping("/test")
    @ResponseBody
    public UserModel test(){
         return new UserModel("James");
    }

    @RequestMapping ( "/index" )
    public ModelAndView showView() {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject( "user",new UserModel("James"));
        return modelAndView;
    }

}
