package eatclean.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eatclean.project.demo.enity.Login;
import eatclean.project.demo.enity.Order;
import eatclean.project.demo.enity.Products;
import eatclean.project.demo.enity.User;
import eatclean.project.demo.service.LoginService;
import eatclean.project.demo.service.OrderService;
import eatclean.project.demo.service.SearchProService;
import eatclean.project.demo.service.UserService;
// import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DathangController {

    @Autowired 
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired 
    private SearchProService searchProService;


    @Autowired
    private OrderService orderService;


    @GetMapping("/dathang/{loginID}/{productID}")
    public String dathang(@PathVariable int loginID, @PathVariable int productID, Model model){
        Login login = loginService.getById(loginID);
        User user = userService.getUserByLoginId(loginID);
        Products products = searchProService.getById(productID);

        model.addAttribute("login", login);
        model.addAttribute("user", user);
        model.addAttribute("products", products);

        return "dathang";
    }


    @PostMapping("/dathang/{loginID}/{productID}")
    public String Orders(Model model, @PathVariable int loginID, @PathVariable int productID, @RequestParam int quantity){
        Login login = loginService.getById(loginID);
        User user = userService.getUserByLoginId(loginID);
        Products products = searchProService.getById(productID);

        Order order = new Order();
        order.setUser(user);
        order.setProducts(products);
        order.setMoney(products.getPrice() * quantity); 

        orderService.saveOrder(order);

        model.addAttribute("message", "Dat hang thanh cong");

        return "dathang";
    }

}
