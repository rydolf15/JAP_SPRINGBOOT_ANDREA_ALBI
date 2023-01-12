package com.example.rizzboys.dto;

import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.CartQty;
import lombok.Data;

@Data
public class CartEntryDto {
    Long idProduct;
    Long idCartQty;
    String code;
    String name;
    Double price;
    Double qty;
    Double total;

    public CartEntryDto(){}

    public CartEntryDto(CartQty cartQty) {
        this.setIdCartQty(cartQty.getCartQty_id());
        this.setIdProduct(cartQty.getProduct().getId());
        this.setCode(cartQty.getProduct().getCode());
        this.setName(cartQty.getProduct().getName());
        this.setPrice(cartQty.getProduct().getPrice());
        this.setQty(cartQty.getQuantity().doubleValue());
    }

    @Override
    public String toString() {
        return "CartEntryDto{" +
                "idProduct=" + idProduct +
                ", idCartQty=" + idCartQty +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", total=" + total +
                '}';
    }
}
