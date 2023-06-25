package com.ecommerce.ecommerceSpringBootBase.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping("")
    public String home() {
    	return "usuario/home";
    }

    @GetMapping("/registro")
    public String register() {
        return "pages/register";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

    @GetMapping("/compras")
    public String shopping() {
        return "pages/shopping";
    }

    @GetMapping("/detallecompra")
    public String shoppingdetail() {
        return "pages/shoppingdetail";
    }

    @GetMapping("/cerrar")
    public String closesession() {
        return "redirect:/";
    }
}

