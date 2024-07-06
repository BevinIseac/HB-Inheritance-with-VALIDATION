package com.exam;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Employe10110")
@AttributeOverrides({
	@AttributeOverride(name="salary", column=@Column(name="salary")),
	@AttributeOverride(name="destination", column=@Column(name="destination")),
	@AttributeOverride(name="dtofjoining", column=@Column(name="dtofjoining"))
})

public class Employee extends Person{

	@Positive(message="Invalid Salary.Value should be positive")
	private float salary;
	@Size (max = 20,min = 3,message = "Invalid destination.Size should be between 3 and 20 ")
	@NotEmpty (message = "Please enter your Destination.")
	private String Destination;
	@Future(message="Invalid date.It should be provided as a future date.")
	private Date dtofjoining;
	
	public Employee() {
		
	}

	public Employee(
			@Size(max = 20, min = 3, message = "Invalid name.Size should be between 3 and 20 ") @NotEmpty(message = "Please enter your name.") String name,
			@Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters.") @NotEmpty(message = "Please enter your address.") String address,
			@Positive(message = "Invalid Salary.Value should be positive") float salary,
			@Size(max = 20, min = 3, message = "Invalid destination.Size should be between 3 and 20 ") @NotEmpty(message = "Please enter your Destination.") String destination,
			@Future(message = "Invalid date.It should be provided as a future date.") Date date) {
		super( name, address);
		this.salary = salary;
		this.Destination = destination;
		this.dtofjoining = date;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public Date getDtofjoining() {
		return dtofjoining;
	}
	public void setDtofjoining(Date dtofjoining) {
		this.dtofjoining = dtofjoining;
	}
	
	

}
