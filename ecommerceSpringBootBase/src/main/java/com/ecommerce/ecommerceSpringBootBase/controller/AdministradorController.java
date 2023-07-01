package com.ecommerce.ecommerceSpringBootBase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.ecommerceSpringBootBase.model.Producto;
import com.ecommerce.ecommerceSpringBootBase.model.Usuario;
import com.ecommerce.ecommerceSpringBootBase.service.ProductoService;
import com.ecommerce.ecommerceSpringBootBase.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdministradorController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ProductoController productoController;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public String home(Model model) {
        List<Producto> products = productoService.findAll();
        products.sort(Comparator.comparing(Producto::getNombre));
        model.addAttribute("products", products);
        return "administrador/home";
    }

    @GetMapping("/products")
    public String itemdetail(Model model) {
        return productoController.read(model);
    }

    @GetMapping("/products/create")
    public String itemcreate() {
        return productoController.create();
    }

    @PostMapping("/products/create")
    public String itemsave(Producto producto, @RequestParam("img") MultipartFile file) {
        return productoController.save(producto, file);
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<Usuario> users = usuarioService.findAll();
        users.sort(Comparator.comparing(Usuario::getNombre));
        model.addAttribute("users", users);
        return "pages/users";
    }

    @GetMapping("/products/update/{id}")
    public String itemupdate(@PathVariable Integer id, Model model) {
        return productoController.update(id, model);
    }

    @PostMapping("/products/update/{id}")
    public String itemupdate(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        return productoController.update(producto, file);
    }

    @GetMapping("/products/delete/{id}")
    public String itemdelete(@PathVariable Integer id) {
        return productoController.delete(id);
    }

    @GetMapping("/orders")
    public String order() {
        return "pages/orders";
    }

    @GetMapping("/ordersdetail")
    public String orderdetail() {
        return "pages/ordersdetail";
    }
}
