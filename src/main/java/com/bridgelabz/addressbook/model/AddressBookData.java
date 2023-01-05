package com.bridgelabz.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgelabz.addressbook.dto.AddressBookDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressBookData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fullName;
	private String address;
	private String phoneNumber;
	private String city;
	private String state;
	private int zipCode;
	private String email;
	
	 public AddressBookData(AddressBookDto addressBookDto) {
	        this.updateAddressBookData(addressBookDto);
	    }

	    public void updateAddressBookData(AddressBookDto addressBookDto) {
	        this.setFullName(addressBookDto.getFullName());
	        this.setAddress(addressBookDto.getAddress());
	        this.setPhoneNumber(addressBookDto.getPhoneNumber());
	        this.setCity(addressBookDto.getCity());
	        this.setState(addressBookDto.getState());
	        this.setZipCode(addressBookDto.getZipCode());
	        this.setEmail(addressBookDto.getEmail());
	    }
	

}
