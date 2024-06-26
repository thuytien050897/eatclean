package eatclean.project.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eatclean.project.demo.enity.Cart;
import eatclean.project.demo.enity.Products;
import eatclean.project.demo.enity.User;

@Repository
public interface CartReponsitory extends JpaRepository<Cart, Integer> {
    Optional <Cart> findById(int id);
    List<Cart> findByProducts(Products products);
    List <Cart> findByUser(User user);
} 
