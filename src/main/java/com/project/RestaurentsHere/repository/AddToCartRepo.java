package com.project.RestaurentsHere.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.RestaurentsHere.model.AddtoCart;


@Repository
public interface AddToCartRepo extends JpaRepository<AddtoCart,Integer> {

	
	//remove cart by userid and cartId,
	//getCartByuserId
	
	@Query("Select sum(addCart.price) FROM AddtoCart addCart WHERE addCart.user.id=:user_id")
	double getTotalAmountByUserId(@Param("user_id")int user_id);
	@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.user.id=:user_id")
	Page<AddtoCart> getCartByuserId(@Param("user_id")int user_id, Pageable perpage);
	@Query("Select addCart  FROM AddtoCart addCart ")
	Optional<AddtoCart> getCartByuserIdtest();
	@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.food.id= :food_id and addCart.user.id=:user_id")
	Optional<AddtoCart> getCartByfoodIdAnduserId(@Param("user_id")int user_id,@Param("food_id")int food_id);
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE addCart.id =:cart_id   and addCart.user.id=:user_id")
	void deleteCartByIdAndUserId(@Param("user_id")int user_id,@Param("cart_id")int cart_id);
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE   addCart.user.id=:user_id")
	void deleteAllCartByUserId(@Param("user_id")int user_id);
	
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddtoCart addCart WHERE addCart.user.id=:user_id")
	void deleteAllCartUserId(@Param("user_id")int user_id);
	@Modifying
    @Transactional
	@Query("update AddtoCart addCart set addCart.qty=:qty,addCart.price=:price WHERE addCart.id=:cart_id")
	void updateQtyByCartId(@Param("cart_id")int cart_id,@Param("price")double price,@Param("qty")Integer qty);
	
	@Query("Select addCart  FROM AddtoCart addCart WHERE addCart.user.id=:user_id")
	List<AddtoCart> getCartByuserId(@Param("user_id")int user_id);

}
