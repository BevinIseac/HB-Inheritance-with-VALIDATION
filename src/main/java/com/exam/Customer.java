package com.exam;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="id")),
	@AttributeOverride(name="name", column=@Column(name="name")),
	@AttributeOverride(name="address",column=@Column(name="address"))
})
public class Customer extends Person{
	@Email(message = "Invalid email address.please enter a proper email id.")
	@NotEmpty(message="Please enter your email ID.")
	private String email;
	@Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits.")
	@NotEmpty(message = "Please enter your mobile number.")
	private String mobile;
	@NotNull(message = "Please select a customer type.")
	@Pattern(regexp = "Regular|VIP|Guest", message = "Customer type must be 'Regular', 'VIP', or 'Guest'.")
	private String CustomerType;
	
	public Customer() {
		
	}

	
	public Customer(
			@Size(max = 20, min = 3, message = "Invalid name.Size should be between 3 and 20 ") @NotEmpty(message = "Please enter your name.") String name,
			@Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters.") @NotEmpty(message = "Please enter your address.") String address,
			@Email(message = "Invalid email address.please enter a proper email id.") @NotEmpty(message = "Please enter your email ID.") String email,
			@Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits.") @NotEmpty(message = "Please enter your mobile number.") String mobile,
			@NotNull(message = "Please select a customer type.") @Pattern(regexp = "Regular|VIP|Guest", message = "Customer type must be 'Regular', 'VIP', or 'Guest'.") String customerType) {
		super( name, address);
		this.email = email;
		this.mobile = mobile;
		CustomerType = customerType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCustomerType() {
		return CustomerType;
	}
	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}
	
	
}
