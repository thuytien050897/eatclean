package eatclean.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eatclean.project.demo.enity.Cart;
import eatclean.project.demo.enity.Login;
import eatclean.project.demo.enity.Products;
import eatclean.project.demo.enity.User;
import eatclean.project.demo.service.CartService;
import eatclean.project.demo.service.LoginService;
import eatclean.project.demo.service.ProductsFormService;
import eatclean.project.demo.service.SearchProService;
import eatclean.project.demo.service.UserService;

public class GioHangController {
    @Autowired
    private ProductsFormService productsFormService;

    @Autowired
    private LoginService loginService;

    @Autowired 
    private UserService userService;

    @Autowired
    private SearchProService searchProService;

    @Autowired
    private CartService cartService;

    // public GioHangController(ProductsFormService productsFormService) {
    //     // super();
    //     this.productsFormService = productsFormService;
    // }

    // @GetMapping("/products")
    // public String search_products(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
    //     List<Products> products = productsFormService.search_products(keyword);
    //     model.addAttribute("product", products);
    //     model.addAttribute("keyword", keyword != null ? keyword : "");
    //     return "gio_hang";
    // }

    // @GetMapping("/gio_hang")
    // public String listProducts(Model model) {
    // model.addAttribute("product", productsFormService.listAll());
    // return "gio_hang";
    // }

    // @PostMapping("/products")
    // public String saveProducts(@ModelAttribute("product") Products product) {
    //     productsFormService.saveProducts(product);
    //     return "redirect:/gio_hang";
    // }

    // update
    // @PostMapping("/products/{id}")
    // public String updateProducts(@PathVariable int id, @ModelAttribute("product") Products product, Model model) {
    //     // get products from database by id
    //     Products existingProducts = productsFormService.getProductsById(id);
    //     existingProducts.setId(id);
    //     existingProducts.setImage(product.getImage());
    //     existingProducts.setName(product.getName());
    //     existingProducts.setQuantity(product.getQuantity());
    //     existingProducts.setPrice(product.getPrice());

    //     // save updated products object
    //     productsFormService.updateProducts(existingProducts);
    //     return "redirect:/gio_hang";
    // }

    // delete
    // @GetMapping("/products/{id}")
    // public String deleteProducts(@PathVariable int id) {
    //     productsFormService.delete(id);
    //     return "redirect:/gio_hang";
    // }

    @GetMapping("/gio_hang/{id}")
    public String ShowGio_hang(@PathVariable int id, Model model) {
        

        Login login = loginService.getById(id);
        User user = userService.getUserByLoginId(id);
        List<Cart> carts = cartService.geCartsUser(user); // Sửa thành geCartsUser
        model.addAttribute("user", user);
        model.addAttribute("carts", carts);
        return "gio_hang";

    }


}
