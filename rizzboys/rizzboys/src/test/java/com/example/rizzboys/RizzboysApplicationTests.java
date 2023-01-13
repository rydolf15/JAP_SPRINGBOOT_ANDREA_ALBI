package com.example.rizzboys;

import com.example.rizzboys.dto.AddToCartDto;
import com.example.rizzboys.dto.CustomerIdDto;
import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.CartRepository;
import com.example.rizzboys.repos.CustomerRespository;
import com.example.rizzboys.repos.ProductRepository;
import com.example.rizzboys.service.CartService;
import com.example.rizzboys.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class RizzboysApplicationTests {

    @Autowired
    CustomerService customerService;

    @Autowired
    CartService cartService;

    @Autowired
    CustomerRespository customerRespository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;

    @Test
    void contextLoads() {
        productRepository.deleteAllInBatch();
        cartRepository.deleteAllInBatch();
        customerRespository.deleteAllInBatch();

        Customer cx = new Customer();
        cx.setUsername("ledio");
        cx.setPassword("psw");
        cx.setLastName("hoxha");
        cx.setFirstName("Ledio");
        customerService.saveCustomer(cx);
        cx = new Customer();
        cx.setUsername("ana");
        cx.setPassword("psw");
        cx.setLastName("ulli");
        cx.setFirstName("Ana");
        customerService.saveCustomer(cx);

        List<Customer> custs = customerRespository.findAll();
        Customer c1 = custs.get(0);
        Cart cart = new Cart();
        cart.setState("DRAFT");
        cart.setDate(LocalDate.now());
        cart.setCustomer(c1);
        cartRepository.save(cart);

        Product p;
        p = new Product();
        p.setCode("upg");
        p.setName("uje");
        p.setPrice(60.0);
        p.setDescription("uje pa gas");
        productRepository.save(p);
        p = new Product();
        p.setCode("umg");
        p.setName("ujeg");
        p.setPrice(70.0);
        p.setDescription("uje mea gas");
        productRepository.save(p);
        AddToCartDto addToCartDto = new AddToCartDto();
        addToCartDto.setIdProduct(p.getId());
        addToCartDto.setIdCustomer(cx.getId());
        addToCartDto.setQuantity(2);
        cartService.addToCart(addToCartDto);

        CustomerIdDto customerIdDto = new CustomerIdDto();
        customerIdDto.setCustomerId(cx.getId());
        cartService.displayCart(customerIdDto);

    }




    private void addCart() {
        List<Customer> custs = customerRespository.findAll();
        Customer c1 = custs.get(0);
        Cart cart = new Cart();
        cart.setState("DRAFT");
        cart.setDate(LocalDate.now());
        cart.setCustomer(c1);
        cartRepository.save(cart);
    }

    private void fillTables() {
        Customer cx = new Customer();
        cx.setUsername("ledio");
        cx.setPassword("psw");
        cx.setLastName("hoxha");
        cx.setFirstName("Ledio");
        customerService.saveCustomer(cx);
        cx = new Customer();
        cx.setUsername("ana");
        cx.setPassword("psw");
        cx.setLastName("ulli");
        cx.setFirstName("Ana");
        customerService.saveCustomer(cx);

    }

    private void emptyTables() {
        productRepository.deleteAllInBatch();
        cartRepository.deleteAllInBatch();
        customerRespository.deleteAllInBatch();
    }

}
