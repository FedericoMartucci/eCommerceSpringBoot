package com.ecommerce.ecommerceSpringBootBase.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @GetMapping("")
    public String read() {
        return "pages/itemread";
    }

    @GetMapping("/create")
    public String create() {
        return "pages/itemcreate";
    }

    @GetMapping("/update")
    public String update() {
        return "pages/itemupdate";
    }

    @GetMapping("/delete")
    public String delete() {
        return "redirect:/";
    }
}

