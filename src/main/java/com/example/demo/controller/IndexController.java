package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gmg on on 2018-01-15 17:20.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
