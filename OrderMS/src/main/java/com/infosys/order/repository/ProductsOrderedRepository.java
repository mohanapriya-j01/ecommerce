package com.infosys.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.infosys.order.entity.ProductsOrdered;
import com.infosys.order.entity.ProductsOrderedId;

@Repository(value="productsOrderedRepository")
public interface ProductsOrderedRepository extends JpaRepository<ProductsOrdered, ProductsOrderedId> {

	public ProductsOrdered findByBuyerIdAndProdId(Integer buyerId, Integer prodId);
}
