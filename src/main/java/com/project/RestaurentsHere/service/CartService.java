package com.project.RestaurentsHere.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.RestaurentsHere.model.AddtoCart;
import com.project.RestaurentsHere.model.CheckoutCart;


@Service
public interface CartService {
//	List<AddtoCart> addCartbyUserIdAndFoodId(int foodId,int userId,int qty,double price) throws Exception;
	void updateQtyByCartId(int cartId,int qty,double price) throws Exception;
	List<AddtoCart> getCartByUserId(int userId);
	List<AddtoCart> removeCartByUserId(int cartId,int userId);
	List<AddtoCart> removeAllCartByUserId(int userId);
//	Boolean checkTotalAmountAgainstCart(double totalAmount,int userId);
//	List<CheckoutCart> getAllCheckoutByUserId(int userId);
//	List<CheckoutCart> saveFoodsForCheckout(List<CheckoutCart> tmp)  throws Exception;
//	
	Page<AddtoCart> addCartbyUserIdAndFoodId(int foodId, int userId, int qty, double price, Principal principal)
			throws Exception;
	Page<AddtoCart> getCartByUserId(int userId, Pageable pageable);
	Boolean checkTotalAmountAgainstCart(double price, int user_Id);
	List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;
	List<CheckoutCart> getAllCheckoutByUserId(int userId);
	
	//CheckOutCart
}
