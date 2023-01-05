package com.bridgelabz.addressbook.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.dto.LoginDto;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import com.bridgelabz.addressbook.util.EmailSenderService;
import com.bridgelabz.addressbook.util.TokenUtil;


@Service
public class AddressBookService implements IAddressBookService {
	@Autowired
	AddressBookRepository repo;
	@Autowired
	TokenUtil tokenUtil;
	
	@Autowired
	EmailSenderService sender;
	
	

	public AddressBookData postData(AddressBookDto addressBookDto) {
		AddressBookData addressBookData=new AddressBookData(addressBookDto);
		List<AddressBookData> dataList=repo.findAll();
		for(AddressBookData addData:dataList)
		{
			if(addressBookDto.getFullName().equals(addData.getFullName())||addressBookDto.getPhoneNumber().equals(addData.getPhoneNumber())||addressBookDto.getAddress().equals(addData.getAddress()))
			{
			if(addressBookDto.getAddress().equals(addData.getAddress())||addressBookDto.getPhoneNumber().equals(addData.getPhoneNumber()))
			{
				
					return null;
			}
				
			}
		}
		
		
		
		return repo.save(addressBookData);
		//String token=tokenUtil.createToken(addressBookData.getId());
		//sender.sendEmail(addressBookData.getEmail(),"test mail", "Hello....."+addressBookData.getFullName()+" http://localhost:8080/get/"+token);
		
	}
	
	//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxMX0.CkKve3gaXDyfiOhBdnlU1StmHPPZGZsR4pn3Aa_SGKk

	public AddressBookData getDataById(String token) {
		int id=tokenUtil.decodeToken(token);
		return repo.findById(id)
                .orElseThrow(() -> new AddressBookException("Invalid ID"));
	}

	public List<AddressBookData> getAllData() {
		return repo.findAll();
		
	}

	public AddressBookData updateData(int id, AddressBookDto addressBookDto) {
		AddressBookData data=repo.findById(id).get();
		data.updateAddressBookData(addressBookDto);
		return repo.save(data);
		
	}

	public void deleteAData(int id) {
		repo.deleteById(id);
		
	}

	public AddressBookData getDataByEmail(String email) {
		return repo.findDataByEmail(email);
	}

	public AddressBookData getById(int id) {
		return repo.findById(id).get();
	}

	public AddressBookData login(String email,String password) {
		List<AddressBookData> data=repo.findAll();
		for(AddressBookData um:data)
		{
			if(email.equals(um.getEmail()))
			{
				return repo.findDataByEmail(email);
			}
		}
		return null;
	}

	public List<AddressBookData> sortAsc() {
		
		return repo.addressInAsc();
	}

	public List<AddressBookData> sortDsc() {
		
		return repo.addressInDsc();
	}

	public List<AddressBookData> getDataSearch(String searchString) {
		
		return repo.findContactsBySearchString(searchString);

}

	public List<AddressBookData> sortAscState() {
		
		return repo.stateInAsc();
	}

	public List<AddressBookData> sortDscState() {
		return repo.stateInDsc();
	}
	
}
	
	


