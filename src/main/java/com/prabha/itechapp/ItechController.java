package com.prabha.itechapp;

import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value = "/testing")
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
    @RequestMapping(value = "/get")
    public Map getPrabha()
    {
        Address address=new Address();
        address.city = "Thanjavur";
        address.state = "tamil nadu";
        address.pincode = 613004;
        Map<String ,Object> map=new HashMap<>();
        map.put("Id",01);
        map.put("Name","Prabhavathi");
        map.put("Age",20);
        map.put("Address",address);
        return map;
    }

    // Just try
    @RequestMapping(value = "/try")
    public Hello hello()
    {
        /** Hello h=new Hello("Prabha");
        return h; **/
    return new Hello("Prabhavathi");
    }

    // Content-Type application/json
    @RequestMapping(value = "/detail")
    public Person getPerson() {
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

    // path variable
    @RequestMapping(value = "/path/{name}")
    public String path(@PathVariable String name)
    {
        return name;
    }


}
