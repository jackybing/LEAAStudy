package com.leaa.model.cart;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.leaa.model.user.User;

@Entity
@Table(name="leaa_cart")
public class Cart implements Serializable {
	
	private Integer id;
	private String type;//购物车类型，有双轮和四轮区别
	
	private List<User> users;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",unique= true,nullable= false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length=50)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="cart_user",
		joinColumns=@JoinColumn(name="cart"),
		inverseJoinColumns=@JoinColumn(name="user")
	)
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
