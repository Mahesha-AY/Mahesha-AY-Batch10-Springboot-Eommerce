package com.te.ecommerce.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="itemtable")
public class Item implements Serializable{

	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int quantity;
	@Column
	private double price;
}
