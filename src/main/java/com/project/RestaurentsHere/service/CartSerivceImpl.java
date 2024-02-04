package com.project.RestaurentsHere.service;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.RestaurentsHere.model.AddtoCart;
import com.project.RestaurentsHere.model.CheckoutCart;
import com.project.RestaurentsHere.model.Food;
import com.project.RestaurentsHere.model.User;
import com.project.RestaurentsHere.repository.AddToCartRepo;
import com.project.RestaurentsHere.repository.CheckoutRepo;
import com.project.RestaurentsHere.repository.FoodRepository;
import com.project.RestaurentsHere.repository.UserRepository;





@Service
public class CartSerivceImpl implements CartService {

	@Autowired
	AddToCartRepo addCartRepo;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CheckoutRepo checkOutRepo;
	@Autowired
	FoodRepository foodRepo;
    private static final Logger logger = LoggerFactory.getLogger(CartSerivceImpl.class);

	@Override
	public Page<AddtoCart> addCartbyUserIdAndFoodId(int foodId, int userId,int qty,double price, Principal principal) throws Exception {
		try {
			if(addCartRepo.getCartByfoodIdAnduserId(userId, foodId).isPresent()){
				throw new Exception("food is already exist.");
			}
		
			String name=principal.getName();
			User user=userRepository.getUserByUsername(name);
			AddtoCart obj = new AddtoCart();
			obj.setQty(qty);
			obj.setUser(user);
			Food food = foodRepo.findById(foodId).get();
			obj.setFood(food); 
			//TODO price has to check with qty
			obj.setPrice(price);
			addCartRepo.save(obj);	
			Pageable pageable= PageRequest.of(1, 5);
			return this.getCartByUserId(userId, pageable);	
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public Page<AddtoCart> getCartByUserId(int userId,  Pageable perpage) {
		return addCartRepo.getCartByuserId(userId, perpage);
	}

	@Override
	public List<AddtoCart> removeCartByUserId(int cartId, int userId) {
		addCartRepo.deleteCartByIdAndUserId(userId, cartId);
		//Pageable pageable= PageRequest.of(1, 5);
		return this.getCartByUserId(userId);
	}

	

	@Override
	public void updateQtyByCartId(int cartId, int qty, double price) throws Exception {
		addCartRepo.updateQtyByCartId(cartId,price,qty);
	}

//	@Override
//	public Boolean checkTotalAmountAgainstCart(double totalAmount,int userId) {
//		double total_amount =addCartRepo.getTotalAmountByUserId(userId);
//		if(total_amount == totalAmount) {
//			return true;
//		}
//		System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
//		return false;
//	}

//	@Override
//	public List<CheckoutCart> getAllCheckoutByUserId(int userId) {
//		return checkOutRepo.getByuserId(userId);
//	}

//	@Override
//	public List<CheckoutCart> savefoodsForCheckout(List<CheckoutCart> tmp) throws Exception {
//		try {
//			int user_id = tmp.get(0).getUser_id();
//			if(tmp.size() >0) {
//				checkOutRepo.saveAll(tmp);
//				this.removeAllCartByUserId(user_id);
//				return this.getAllCheckoutByUserId(user_id);
//			}	
//			else {
//				throw  new Exception("Should not be empty");
//			}
//		}catch(Exception e) {
//			throw new Exception("Error while checkout "+e.getMessage());
//		}
//		
//	}

	@Override
	public List<AddtoCart> removeAllCartByUserId(int userId) {
		addCartRepo.deleteAllCartByUserId(userId);
		return null;
	}

	@Override
	public List<AddtoCart> getCartByUserId(int userId) {
		
		return addCartRepo.getCartByuserId(userId);
	}

	@Override
	public Boolean checkTotalAmountAgainstCart(double totalAmount,int userId) {
		double total_amount =addCartRepo.getTotalAmountByUserId(userId);
		if(total_amount == totalAmount) {
			return true;
		}
		System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
		return false;
	}
	
	@Override
	public List<CheckoutCart> getAllCheckoutByUserId(int userId) {
		return checkOutRepo.getByuserId(userId);
	}

	
	@Override
	public List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp) throws Exception {
		try {
			int user_id = tmp.get(0).getUser_id();
			if(tmp.size() >0) {
				checkOutRepo.saveAll(tmp);
				//this.removeAllCartByUserId(user_id);
				return this.getAllCheckoutByUserId(user_id);
			}	
			else {
				throw  new Exception("Should not be empty");
			}
		}catch(Exception e) {
			throw new Exception("Error while checkout "+e.getMessage());
		}
		
	}


}
