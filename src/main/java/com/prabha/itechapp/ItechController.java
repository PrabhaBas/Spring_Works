package com.prabha.itechapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ItechController {

    // Content-type text/plain
    @RequestMapping(value = "/test")
    public String test()
    {
        return "Hello World";
    }

    // Content-type application/json
    @RequestMapping(value = "/test-json")
    public Map testJson(){
        Map<String ,String> map=new HashMap<>();
        map.put("Name","Prabhavathi");
        map.put("Place","Thanjavur");
        map.put("college","Srm-Trp");
        return map;
    }
}
