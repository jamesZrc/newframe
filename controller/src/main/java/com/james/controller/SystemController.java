package com.james.controller;


import com.james.common.utils.Conf;
import com.james.common.utils.Context;
import com.james.model.UserModel;
import com.james.security.utils.SecurityUtils;
import com.james.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by eronzen on 10/28/2016.
 */
@Controller
@RequestMapping("/sys")
public class SystemController extends BaseController {


    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/test")
    @ResponseBody
    public List<UserModel> test(){
         return userService.getUsers();
    }

    @RequestMapping ( "/index" )
    public ModelAndView showView() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<UserModel> users = userService.getUsers();

        modelAndView.addObject( "users", users);

        String defaultRole = Conf.get("user.default.role");

        modelAndView.addObject("currentUser", SecurityUtils.getCurrentUser());

        modelAndView.addObject("accessIp", Context.getAccessIp());


        return modelAndView;
    }

}
