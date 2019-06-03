package com.study.jta.atomikos.controller;

import com.study.jta.atomikos.service.AtomikosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wujing
 * @since 2019/5/31 10:38
 */
@RestController
public class QueryController {

    @Autowired
    private AtomikosService atomikosService;


    @GetMapping("/save")
    public Map<String, Object> save(String name) {

        return atomikosService.save(name);
    }

}
