package com.kitchen.Sonal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

		private long id;
		private String name;
		private double price;
		private String discription;
		
		@ManyToOne
		private Category category;
		@ManyToMany(mappedBy = "menu")
		private List<Customer> customer;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDiscription() {
			return discription;
		}
		public void setDiscription(String discription) {
			this.discription = discription;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		@Override
		public String toString() {
			return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", discription=" + discription
					+ ", category=" + category + "]";
		}
		
		

}
