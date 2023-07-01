package com.ecommerce.ecommerceSpringBootBase.controller;

import com.ecommerce.ecommerceSpringBootBase.model.DetalleOrden;
import com.ecommerce.ecommerceSpringBootBase.model.Orden;
import com.ecommerce.ecommerceSpringBootBase.model.Producto;
import com.ecommerce.ecommerceSpringBootBase.model.Usuario;
import com.ecommerce.ecommerceSpringBootBase.service.ProductoService;
import com.ecommerce.ecommerceSpringBootBase.service.UploadFileService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/products")
public class ProductoController {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
    @Autowired
    private ProductoService productoService;
    @Autowired
    private UploadFileService uploadFileService;
    List<DetalleOrden> detalles = new ArrayList<>();
    Orden orden = new Orden();

    public String read(Model model) {
        List<Producto> products = productoService.findAll();
        products.sort(Comparator.comparing(Producto::getNombre));
        model.addAttribute("products", products);
        return "pages/itemread";
    }

    public String create() {
        return "pages/itemcreate";
    }

    //////////////////////////////////////////////////////////////// POSTMAPPING////////////////////////////////
    public String update(Producto producto, MultipartFile file) throws IOException {
        Producto productoConImage = new Producto();
        productoConImage = productoService.get(producto.getId()).get();
        if (file.isEmpty()) {
            producto.setImagen(productoConImage.getImagen());
        } else {
            if (!productoConImage.getImagen().equals("default.png")) {
                uploadFileService.deleteImage(productoConImage.getImagen());
            }
            String imagename = uploadFileService.saveImage(file);
            producto.setImagen(imagename);
        }
        LOGGER.info("Producto: {}", producto);
        productoService.update(producto);
        return "redirect:/admin/products";
    }

    //////////////////////////////////////////////////////////////// GETMAPPINGS////////////////////////////////
    public String update(Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        LOGGER.info("Producto: {}", producto);
        model.addAttribute("producto", producto);
        return "pages/itemupdate";
    }

    public String delete(Integer id) {
        Producto producto = new Producto();
        producto = productoService.get(id).get();
        if (!producto.getImagen().equals("default.png")) {
            uploadFileService.deleteImage(producto.getImagen());
        }
        productoService.delete(id);
        return "redirect:/admin/products";
    }

    public String save(Producto producto, MultipartFile file) {
        LOGGER.info("producto: {}" + producto);
        Usuario usuario = new Usuario(10005, "fede", "fede", "federico@hotmail.com", "123123", "11333555",
                "A", "123456");
        producto.setUsuario(usuario);
        if (producto.getId() == null) {
            String imagename = uploadFileService.saveImage(file);
            producto.setImagen(imagename);
        }
        productoService.create(producto);
        return "redirect:/admin/products";
    }
}
