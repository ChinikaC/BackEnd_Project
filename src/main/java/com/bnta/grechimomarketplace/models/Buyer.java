package com.bnta.grechimomarketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String password;
    
    @Transient
    private List<Product> cart;

    @OneToOne
    private BankCard card;

    @OneToMany(mappedBy = "buyer")
    @JsonIgnoreProperties({"buyer"})
    private List<Order> orders;

    public Buyer(String name, String email, String address, String password, BankCard card) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.cart = new ArrayList<>();
        this.card = card;
        this.orders = new ArrayList<>();
    }

    public Buyer(){
        
    }

    public long getCartTotalValue() {
        long totalValue = 0;
        for (Product product : cart) {
            totalValue += product.getPrice();
        }
        return totalValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public BankCard getCard() {
        return card;
    }

    public void setCard(BankCard card) {
        this.card = card;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
}
