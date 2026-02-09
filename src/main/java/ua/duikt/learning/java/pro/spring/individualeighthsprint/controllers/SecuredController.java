package ua.duikt.learning.java.pro.spring.individualeighthsprint.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
@RestController
public class SecuredController {

    @GetMapping("/secured/info")
    public String getSecuredInfo() {
        return "Secret Info";
    }
}
