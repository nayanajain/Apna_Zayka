package com.project.RestaurentsHere.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Foodie")
public class Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id=0;
	private String name;
	private double price;
	private String catagory;
	public String type;
	private byte[] image;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	
	
	

	

}
