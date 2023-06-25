package com.ecommerce.ecommerceSpringBootBase.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String home() {
    	return "home";
    }

    @GetMapping("producto")
    public String itemdetail() {
        return "pages/itemdetail";
    }

    @GetMapping("/carrito")
    public String getCart() {
        return "pages/cart";
    }

    @GetMapping("/orden")
    public String orderdetail() {
        return "pages/orderdetail";
    }

    @GetMapping("/guardarorden")
    public String saveOrder() {
        return "redirect:/";
    }
}
