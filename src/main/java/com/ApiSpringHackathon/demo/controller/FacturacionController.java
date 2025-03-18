package com.ApiSpringHackathon.demo.controller;


import com.ApiSpringHackathon.demo.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class FacturacionController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


}
