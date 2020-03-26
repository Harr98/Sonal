package com.kitchen.Sonal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	private String name;
	private String address;
	
	@ManyToMany
	@JoinTable(name="customer_menu", joinColumns =@JoinColumn(name="customer_id"), inverseJoinColumns = @JoinColumn(name="menu_id"))
	private List<Menu> menu;


	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
