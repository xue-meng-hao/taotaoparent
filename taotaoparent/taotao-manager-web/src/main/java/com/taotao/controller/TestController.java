//package com.taotao.controller;
//
//import com.taotao.service.TestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class TestController {
//    @Autowired
//    private TestService testService;
//
//    @ResponseBody
//    @RequestMapping("/test/querynow")
//    public String queryNow() {
//        System.out.println("调用了querynow");
//        return testService.queryNow();
//    }
//}
