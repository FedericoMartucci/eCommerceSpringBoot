package com.ecommerce.ecommerceSpringBootBase.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @GetMapping("")
    public String home() {
    	return "administrador/home";
    }

    @GetMapping("producto")
    public String itemdetail() {
        return "pages/itemdetail";
    }

    @GetMapping("/usuarios")
    public String users() {
    	return "pages/users";
    }

    @GetMapping("/ordenes")
    public String order() {
        return "pages/order";
    }

    @GetMapping("/detalleorden")
    public String orderdetail() {
        return "pages/orderdetail";
    }
}
