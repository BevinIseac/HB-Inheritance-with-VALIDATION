package com.exam;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
@Table(name="Person")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Size (max = 20,min = 3,message = "Invalid name.Size should be between 3 and 20 ")
	@NotEmpty (message = "Please enter your name.")
	private String name;
	@Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters.")
	@NotEmpty(message = "Please enter your address.")
	private String address;
	public Person() {
		
	}

	public Person(
			@Size(max = 20, min = 3, message = "Invalid name.Size should be between 3 and 20 ") @NotEmpty(message = "Please enter your name.") String name,
			@Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters.") @NotEmpty(message = "Please enter your address.") String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
