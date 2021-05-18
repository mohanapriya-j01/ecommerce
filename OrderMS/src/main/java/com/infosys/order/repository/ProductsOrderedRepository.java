package com.infosys.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.infosys.order.entity.ProductsOrdered;

@Repository
public interface ProductsOrderedRepository extends JpaRepository<ProductsOrdered, Integer> {

	public ProductsOrdered findByBuyerIdAndProdId(Integer buyerId, Integer prodId);
}
