package com.prabha.itechapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        map.put("College","Srm-Trp");
        map.put("Pincode","613004");
        return map;
    }

    // Content-type application/json
    @RequestMapping(value = "/testing-json")
    public Map testing(){
        Map<String,Object> map=new HashMap<>();
        map.put("Name","Prabhavathi");
        map.put("Place","Thanjavur");
        map.put("College","Srm-Trp");
        map.put("Age",20);
        map.put("Pincode",613004);
        return map;
    }

    // Content-Type application/json
    @RequestMapping(value = "/prabha")
    public Person getVicky() {
        Address address = new Address();
        address.city = "Thanjavur";
        address.state = "tamil nadu";
        address.pincode = 613004;

        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Tamil");
        languages.add("Hindi");

        Person person = new Person();
        person.id = 01;
        person.name = "Prabhavathi";
        person.address = address;
        person.languages = languages;

        return person;
    }
}
