package eatclean.project.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eatclean.project.demo.enity.Cart;
import eatclean.project.demo.enity.Products;
import eatclean.project.demo.enity.User;
import eatclean.project.demo.repository.CartReponsitory;

@Service
public class CartService {
    @Autowired
    private CartReponsitory cartReponsitory;

    public void saveCart(Cart cart){
        cartReponsitory.save(cart);
    }

    public List <Cart> geCartsUser(User user){
        return cartReponsitory.findByUser(user);
    }

    public List<Cart> geCartsProduct(Products products){
        return cartReponsitory.findByProducts(products);
    }
}
