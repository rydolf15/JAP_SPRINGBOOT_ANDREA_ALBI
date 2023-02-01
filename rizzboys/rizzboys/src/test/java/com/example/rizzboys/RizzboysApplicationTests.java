package com.example.rizzboys;

import com.example.rizzboys.dto.AddToCartDto;
import com.example.rizzboys.dto.CustomerIdDto;
import com.example.rizzboys.dto.ProductDto;
import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.Customer;
import com.example.rizzboys.model.Product;
import com.example.rizzboys.repos.CartRepository;
import com.example.rizzboys.repos.CustomerRespository;
import com.example.rizzboys.repos.ProductRepository;
import com.example.rizzboys.service.CartService;
import com.example.rizzboys.service.CustomerService;
import com.example.rizzboys.service.ProductService;
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
    ProductService productService;

    @Autowired
    CustomerRespository customerRespository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;

    @Test
    void contextLoads() {
        emptyTables();

        Customer cx = new Customer();
        cx.setUsername("ledio");
        cx.setPassword("psw");
        cx.setLastName("hoxha");
        cx.setFirstName("Ledio");
        customerService.addCustomer(cx);
        cx = new Customer();
        cx.setUsername("ana");
        cx.setPassword("psw");
        cx.setLastName("ulli");
        cx.setFirstName("Ana");
        customerService.addCustomer(cx);

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
        ProductDto productDto = new ProductDto();
        productDto.setCode(p.getCode());
        productDto.setName(p.getName());
        productDto.setPrice(p.getPrice());
        productDto.setDescription(p.getDescription());
        productService.addProduct(productDto);
        p = new Product();
        p.setCode("umg");
        p.setName("ujeg");
        p.setPrice(70.0);
        p.setDescription("uje mea gas");
        productDto.setCode(p.getCode());
        productDto.setName(p.getName());
        productDto.setPrice(p.getPrice());
        productDto.setDescription(p.getDescription());
        productService.addProduct(productDto);
        AddToCartDto addToCartDto = new AddToCartDto();
        addToCartDto.setIdProduct(productDto.getId());
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
        customerService.addCustomer(cx);
        cx = new Customer();
        cx.setUsername("ana");
        cx.setPassword("psw");
        cx.setLastName("ulli");
        cx.setFirstName("Ana");
        customerService.addCustomer(cx);

    }

    private void addProduct(){

    }


    private void emptyTables() {
        productRepository.deleteAllInBatch();
        cartRepository.deleteAllInBatch();
        customerRespository.deleteAllInBatch();
    }

}
