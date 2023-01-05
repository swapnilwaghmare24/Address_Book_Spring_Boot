package com.bridgelabz.addressbook.service;

import java.util.List;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.model.AddressBookData;

public interface IAddressBookService {
	
	public AddressBookData postData(AddressBookDto addressBookDto);
	public AddressBookData getDataById(String token);
	public List<AddressBookData> getAllData();
	public AddressBookData updateData(int id, AddressBookDto addressBookDto);
	public void deleteAData(int id);

}
