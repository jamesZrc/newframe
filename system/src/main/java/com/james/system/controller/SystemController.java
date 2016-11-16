package com.james.system.controller;

import com.james.controller.base.controller.BaseController;
import com.james.system.model.UserModel;
import com.james.system.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by eronzen on 10/28/2016.
 */
@Controller
@RequestMapping("/sys")
public class SystemController extends BaseController {

    @Autowired
    private UserModel userModel;

    public UserModel getUserModel() {
        return userModel;
    }

    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
         return SecurityUtil.getCurrentUser();
    }

    @RequestMapping ( "/index" )
    public ModelAndView showView() {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject( "user",new UserModel("Jamessssssssss"));


        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        modelAndView.addObject("userModel", userModel);


        return modelAndView;
    }

}
