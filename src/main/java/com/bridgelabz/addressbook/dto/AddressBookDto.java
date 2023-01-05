package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("unused")
@Data
@NoArgsConstructor
public class AddressBookDto {
	//@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "Please enter valid name")
	private String fullName;
	//@NotBlank
	private String address;
	@Pattern(regexp = "^[0-9]{3,10}$",message = "Please enter valid phone number")
	private String phoneNumber;
	//@NotBlank
	private String city;
	//@NotBlank
	private String state;
	//@NotNull
	private int zipCode;
	//@Email
	private String email;

}
