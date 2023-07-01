package com.ecommerce.ecommerceSpringBootBase.controller;

import com.ecommerce.ecommerceSpringBootBase.model.Producto;
import com.ecommerce.ecommerceSpringBootBase.repository.UsuarioRepository;
import com.ecommerce.ecommerceSpringBootBase.service.ProductoService;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsuarioController {
    @Autowired
    private ProductoService productoService;

    private UsuarioRepository usuarioRepository;

    @GetMapping("")
    public String home(Model model) {
        List<Producto> products = productoService.findAll();
        products.sort(Comparator.comparing(Producto::getNombre));
        model.addAttribute("products", products);
        return "user/home";
    }

    @GetMapping("/signin")
    public String register() {
        return "pages/register";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/login";
    }

    @GetMapping("/purchases")
    public String shopping() {
        return "pages/shopping";
    }

    @GetMapping("/purchasedetail")
    public String shoppingdetail() {
        return "pages/shoppingdetail";
    }

    @GetMapping("/logout")
    public String closesession() {
        return "redirect:/";
    }

    @GetMapping("/mostrar")
    public String mostrarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "pages/users";
    }
}
