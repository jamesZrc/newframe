package com.james.system.controller;

import com.james.controller.base.controller.BaseController;
import com.james.system.dto.UserDto;
import com.james.system.model.UserModel;
import com.james.system.service.UserService;
import com.james.system.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by eronzen on 10/28/2016.
 */
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {


    @Autowired
    private UserService userService;

    @RequestMapping ( "/index" )
    public ModelAndView showView() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user", new UserDto());
        return modelAndView;
    }

    @RequestMapping ( "/add" )
    @ResponseBody
    public UserDto addUser(UserDto userDto) {



      return userDto;
    }

}
