package ru.geekbrains.spring.market.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.market.exceptions.ProductNotFoundException;
import ru.geekbrains.spring.market.models.Product;
import ru.geekbrains.spring.market.services.CategoryService;
import ru.geekbrains.spring.market.services.ProductService;
import ru.geekbrains.spring.market.utils.ProductFilter;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;


    @GetMapping
    public String showProducts(Principal principal,
                               Model model,
                               @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize,
                               @RequestParam(required = false) Map<String, String> params
                               ){
        if(pageNum < 0) pageNum = 1;
        if(pageSize < 1) pageSize = 5;

        ProductFilter pf = new ProductFilter(params);

        String clientName = null;
        if(principal != null) clientName = principal.getName();

        model.addAttribute("clientName", clientName);
        model.addAttribute("products", productService.getProducts(pf.getSpec(), pageNum - 1, pageSize));
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("productFilter", pf.getFilter());
        model.addAttribute("productCategoryFilter", pf.getCategoryFilter());

        return "products";
    }

    @GetMapping("/add")
    public String showAddProductForm(){
        return "add_product.html";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute() Product product){
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/upd")
    public String showUpdProductForm(Model model,
                                     @RequestParam(required = false) Long id){
        if(id == null) return "redirect:/products";
        try {
            model.addAttribute("updProduct", productService.getProductById(id));
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            return "redirect:/products";
        }
        return "upd_product";
    }

    @PostMapping("/upd/{id}")
    public String updProduct(@PathVariable() Long id,
                             @RequestParam(required = false) String title,
                             @RequestParam(required = false) Integer price){
        try {
            productService.updProduct(id, title, price);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/products";
    }


}
