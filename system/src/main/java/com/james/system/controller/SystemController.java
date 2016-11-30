package com.james.system.controller;

import com.james.controller.base.controller.BaseController;
import com.james.system.model.UserModel;
import com.james.system.service.UserService;
import com.james.system.utils.Conf;
import com.james.system.utils.Context;
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

        modelAndView.addObject("currentUser", Context.getCurrentUser());

        return modelAndView;
    }

}
