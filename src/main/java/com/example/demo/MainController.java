package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private SchOOl_CRUD repo;

    @GetMapping(path="/add")
    public @ResponseBody String add(@RequestParam String name, @RequestParam Integer year) {
        SchOOl_ schOOl_ = new SchOOl_();
        schOOl_.setName(name);
        schOOl_.setOpenyear(year);
        repo.save(schOOl_);
        return "Saved!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<SchOOl_> getAllschOOls_() {
        return repo.findAll();
    }
}
