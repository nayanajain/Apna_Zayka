package com.project.RestaurentsHere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.RestaurentsHere.model.CheckoutCart;




@Repository
public interface CheckoutRepo  extends JpaRepository<CheckoutCart, Integer> {
	@Query("Select checkCart  FROM CheckoutCart checkCart WHERE checkCart.user_id=:user_id")
	List<CheckoutCart> getByuserId(@Param("user_id")int user_id);
}
