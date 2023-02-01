package com.example.rizzboys.repos;

import com.example.rizzboys.model.Cart;
import com.example.rizzboys.model.CartQty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartQtyRepository extends JpaRepository<CartQty, Long> {

    @Query("delete from CartQty ca where ca.product.id = :productId")
    void deleteCarQtyByProductId(@Param("productId")Long productId);

    @Query("select ca from CartQty ca where ca.product.id = :productId")
    CartQty findCartQtiesByProductId(@Param("productId") Long productId);

    @Query("select ca from CartQty ca where ca.cart.id = :cartId")
    List<CartQty> findCartQtiesForCart(Long cartId);

    @Query("select ca from CartQty ca where ca.cartQty_id = :cartQtyId")
    CartQty findCartQtyById(Long cartQtyId);

}

