package com.project.RestaurentsHere.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.paytm.pg.merchant.CheckSumServiceHelper;
import com.project.RestaurentsHere.model.AddtoCart;
import com.project.RestaurentsHere.model.CheckoutCart;
import com.project.RestaurentsHere.model.Food;
import com.project.RestaurentsHere.model.User;
import com.project.RestaurentsHere.repository.AddToCartRepo;
import com.project.RestaurentsHere.service.CartService;
import com.project.RestaurentsHere.service.FoodService;
import com.project.RestaurentsHere.service.UserService;
import com.project.RestaurentsHere.util.PaytmDetails;




@Controller
@RequestMapping("user/api/addtocart")
public class AddtoCartController {
	
	@Autowired
	private AddToCartRepo addToCartRepo;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	FoodService foodService;
	
    @Autowired
	UserService userService;
	
	
	@Autowired
	private PaytmDetails paytmDetails;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("addfood")
  	public String addCartwithfood(@RequestParam("id") int fid, Model model, Principal principal) {
		try {
			Food food=foodService.findById(fid);
//			String keys[] = {"foodId","userId","qty","price"};
//			if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {
//				
//			}
			String username=principal.getName();
			User user=userService.getUserByUsername(username);
			int userId=user.getId();
			Integer foodId = food.getId(); 
			
//			food.getUser().setId(u3.getId());
//			Integer userId =  food.getUser().getId(); 
//			System.out.println("user id associated with food is"+userId);
			int qty =  3; 
			double price = food.getPrice();
			//int count=87;
			Page<AddtoCart> obj = cartService.addCartbyUserIdAndFoodId(foodId,userId,qty,price, principal);
			//System.out.println(count);
			model.addAttribute("info", "successfully added to cart");
			return "showdetails";
		} catch (Exception e) {
			//e.printStackTrace();
			model.addAttribute("info", "Item already present");
			return "redirect:/user/api/addtocart/viewCart/0";
		}
		
   }
	
	
	@RequestMapping("/viewCart/{page}")	
	private String viewCart(@PathVariable("page") Integer page,Model model , Principal principal)
	{
		String name=principal.getName();
		User user=userService.getUserByUsername(name);
		int userId=user.getId();
		System.out.println("userid is"+userId);
		System.out.println("get api here");
		Pageable pageable= PageRequest.of(page, 5);
		 Page<AddtoCart> obj = cartService.getCartByUserId(userId, pageable);
		 model.addAttribute("cart", obj.getContent());		
		 model.addAttribute("currentpage", page);
		 model.addAttribute("totalpages", obj.getTotalPages());
		return "cartdetails";
		
	}
	
//	@RequestMapping("updateQtyForCart")
//  	public String updateQtyForCart(@RequestParam("id") int cartid, @RequestParam("qty") int qty, Model model) {
//		try {
//			
//			AddtoCart addtoCart=addToCartRepo.findById(cartid).get();
////			int qty=addtoCart2.getQty();
//			int cartId=addtoCart.getId();
//			double price=addtoCart.getPrice();
//			int userId=addtoCart.getUser().getId();
//			cartService.updateQtyByCartId(cartId, qty, price);
//			 System.out.println("updated qty is"+qty);
//			 List<AddtoCart> obj = cartService.getCartByUserId(userId);
//			 model.addAttribute("cart", obj);
//			// model.addAttribute("info", "Updated the Quantity" );
//			
//			
//			} catch (Exception e) {
//			 model.addAttribute("info", "Failed to update the Quantity" );
//				
//		}
//		
//		return "cartdetails";
//		
//		
//   }
//	
	
	@RequestMapping("removefoodFromCart/{id}")
  	public String removeCartwithfoodId(@PathVariable("id") int cartid, Model model, Principal principal) {
		try {
//			String keys[] = {"userId","cartId"};
//			if(ShoppingConfiguration.validationWithHashMap(keys, removeCartRequest)) {
//				
//			}
			String username=principal.getName();
			User user=userService.getUserByUsername(username);
			System.out.println("remove cart id..."+cartid);
			List<AddtoCart> obj = cartService.removeCartByUserId(cartid, user.getId());
			model.addAttribute("info", "item removed");
			return "redirect:/user/api/addtocart/viewCart/0";
		}catch(Exception e) {
			return "redirect:/user/api/addtocart/viewCart/0";
		}		
   }

	

	@RequestMapping("checkout")
  	public String checkout_order( Model model, Principal principal) {
		try {
			String username=principal.getName();
			User user=userService.getUserByUsername(username);
			int user_Id=user.getId();
			model.addAttribute("cA", addToCartRepo.getTotalAmountByUserId(user_Id));
			
//			
////			AddtoCart addtoCart=addToCartRepo.findById(cartid).get();		
////			double price=addtoCart.getPrice();
////			if(cartService.checkTotalAmountAgainstCart(price,user_Id)) {
//       			System.out.println("i am here........");
//			     	String orderId = ""+getOrderId();
					CheckoutCart cart = new CheckoutCart();
//					//cart.setPayment_type(addCartRequest.get("pay_type"));
////					cart.setPrice(price);
					cart.setUser_id(user_Id);
//					cart.setOrder_id(orderId);
////					cart.setFood(addtoCart.getFood());
					model.addAttribute("cart", cart);
//					return "checkout";
//				
		}catch(Exception e) {
			System.out.println("catch here....");
			e.printStackTrace();
			return "cartdetails";
		}
		
		return "checkout";
	}	
	
	
	
	@PostMapping("proceed")
  	public ModelAndView checkout_order(@Valid @ModelAttribute("cart") CheckoutCart cart, BindingResult result, Model model, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetails.getPaytmUrl());
		
		String paymenttype = cart.getPayment_type();
		String orderId=cart.getOrder_id();
//		if(result.hasErrors())
//		{
//			return "error hai yeee";
//		}
		try {
//			String keys[] = {"userId","total_price","pay_type","deliveryAddress"};
//			if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {
//				
//				
//			}
			int user_Id=cart.getUser_id();
//			String name=principal.getName();
//			User user=userRepository.getUserByUsername(name);
//			
//			System.out.println("user is"+user.getName());
//			int user_Id=user.getId();
			double total_amt = cart.getPrice();
			if(cartService.checkTotalAmountAgainstCart(total_amt,user_Id)) {
				List<AddtoCart> cartItems = cartService.getCartByUserId(user_Id);
				List<CheckoutCart> tmp = new ArrayList<CheckoutCart>();
				for(AddtoCart addCart : cartItems) {
					orderId = ""+getOrderId();
					CheckoutCart newcart = new CheckoutCart();
					newcart.setPayment_type(cart.getPayment_type());
					paymenttype= cart.getPayment_type();

					newcart.setPrice(total_amt);
					newcart.setUser_id(user_Id);
					newcart.setOrder_id(orderId);
					newcart.setFood(addCart.getFood());
					//cart.setQty(addCart.getQty());
					newcart.setDelivery_address(cart.getDelivery_address());
					tmp.add(newcart);
					System.out.println("payment type is..."+paymenttype);
					cartService.saveProductsForCheckout(tmp);
					model.addAttribute("message", "Order placed successfully");
					
			} 
				
				if(paymenttype.equals("paytm"))
				{
					 TreeMap<String, String> parameters = new TreeMap<>();
				        paytmDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
				        parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
				        parameters.put("EMAIL", env.getProperty("paytm.email"));
				        parameters.put("ORDER_ID", orderId);
				        
				        System.out.println(orderId+"is the order id");
				        System.out.println(total_amt+"is the order id");
				        System.out.println(user_Id+"is the order id");
				        parameters.put("TXN_AMOUNT", total_amt+" ");
				        parameters.put("CUST_ID", user_Id+" ");
				        String checkSum = getCheckSum(parameters);
				        parameters.put("CHECKSUMHASH", checkSum);
				        modelAndView.addAllObjects(parameters);
					    return modelAndView;
					
				}
				

				
			//	return "checkout";
			}else {
				throw new Exception("Total amount is mismatch");
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Something went wrong!! Check the entered details again");
		//	return "checkout";
		}
		 return modelAndView;
	}
	
	public int getOrderId() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}

	

	
	@RequestMapping("getCartsByUserId")
  	public String getCartsByUserId(Model model, Principal principal) {
		try {
//			String keys[] = {"userId"};
//			if(ShoppingConfiguration.validationWithHashMap(keys, getCartRequest)) {
//			}
			System.out.println("inside history");
			String name=principal.getName();
			User user=userService.getUserByUsername(name);
			List<AddtoCart> totalorders = cartService.getCartByUserId(user.getId());
			
		
			model.addAttribute("totalorders", totalorders);
			return "history";
		}catch(Exception e) {
				return null;
		}	
   }
	
	
	
	 @PostMapping(value = "/receipt")
	    public String getResponseRedirect(HttpServletRequest request, Model model) {

	        Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        mapData.forEach((key, val) -> parameters.put(key, val[0]));
	        String paytmChecksum = "";
	        if (mapData.containsKey("CHECKSUMHASH")) {
	            paytmChecksum = mapData.get("CHECKSUMHASH")[0];
	        }
	        String result;

	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        try {
	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
	            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                    result = "Payment Successful";
	            
	                } else {
	                    result = "Payment Failed";
	                }
	            } else {
	                result = "Checksum mismatched";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	        model.addAttribute("result",result);
	        parameters.remove("CHECKSUMHASH");
	        model.addAttribute("parameters",parameters);
	        return "receipt";
	    }

	 
	 
	   private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
	        return CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(paytmDetails.getMerchantKey(),
	                parameters, paytmChecksum);
	    }


	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(paytmDetails.getMerchantKey(), parameters);
	}
	
	 
}
