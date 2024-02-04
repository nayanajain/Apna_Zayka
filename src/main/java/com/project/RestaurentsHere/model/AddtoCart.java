package com.project.RestaurentsHere.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "add_to_cart")
public class AddtoCart {
	@Id
	int id;
	@JsonIgnore
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
	Food food;
	//Long product_id;
	int qty;
	double price;
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
	User user;
	@Column(updatable=false, insertable=false)
	String added_date;
	
	
	
	}
