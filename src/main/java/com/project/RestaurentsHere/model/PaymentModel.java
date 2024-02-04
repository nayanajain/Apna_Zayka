package com.project.RestaurentsHere.model;

public class PaymentModel {

	private String product;
	private float subtotal;
	private float shipping;
	private float tax;
	private float total;
	
	public PaymentModel(String product, String subtotal, String shipping, String tax, String total) {
		super();
		this.product = product;
		this.subtotal = Float.parseFloat(subtotal);
		this.shipping = Float.parseFloat(shipping);
		this.tax = Float.parseFloat(tax);
		this.total = Float.parseFloat(total);
	}
	public PaymentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getSubtotal() {
		return String.format("%.2f", subtotal);
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public String getShipping() {
		return String.format("%.2f", shipping); 
	}
	public void setShipping(float shipping) {
		this.shipping = shipping;
	}
	public String getTax() {
		return String.format("%.2f", tax);
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public String getTotal() {
		return String.format("%.2f", total); 
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
}
