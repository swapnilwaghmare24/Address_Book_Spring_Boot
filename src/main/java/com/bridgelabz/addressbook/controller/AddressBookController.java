package com.bridgelabz.addressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.dto.LoginDto;
import com.bridgelabz.addressbook.dto.ResponseDto;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.service.AddressBookService;


@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/addressbookservice")
@RestController
public class AddressBookController {
	
	@Autowired
	AddressBookService service;
	
	 @PostMapping("/postdata")
	    public ResponseEntity<ResponseDto> postData(@Valid @RequestBody AddressBookDto addressBookDto) {
		 	
	        AddressBookData addressBookData=service.postData(addressBookDto);
	        ResponseDto responseDto=new ResponseDto("data added :",addressBookData);
	        //ResponseDto responseDto = new ResponseDto("Data sent to mail .... ",addressBookData);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }
	 
	 @GetMapping("/get/{token}")
	    public ResponseEntity<ResponseDto> getDataById(@PathVariable String token) {
	        AddressBookData addressBookData= service.getDataById(token);
	        ResponseDto responseDto = new ResponseDto("Data retrived by id ",addressBookData);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }
	 
	 @GetMapping("/getbyid/{id}")
	    public ResponseEntity<ResponseDto> getById(@PathVariable int id) {
	        AddressBookData addressBookData= service.getById(id);
	        ResponseDto responseDto = new ResponseDto("Data retrived by id ",addressBookData);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }
	 
	 @GetMapping("/getall")
	    public ResponseEntity<ResponseDto> getAllData() {
	        List<AddressBookData> addressBookList = service.getAllData();
	        ResponseDto responseDto = new ResponseDto("All data retrived",addressBookList);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }
	 
	 
	 @PutMapping("/update/{id}")
	    public ResponseEntity<ResponseDto> updateData(@PathVariable int id,
	                                                           @Valid @RequestBody AddressBookDto addressBookDto) {
	        AddressBookData addressBookData=service.updateData(id,addressBookDto);
	        ResponseDto responseDto = new ResponseDto("Data updated ",addressBookData);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<ResponseDto> deleteData(@PathVariable int id) {
	        service.deleteAData(id);
	        ResponseDto responseDto = new ResponseDto("Data Deleted ",
	                id);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }
	 
	 @GetMapping("/email/{email}")
	    public ResponseEntity<ResponseDto> getDataByEmail(@PathVariable String email){
	        AddressBookData addressBookData = service.getDataByEmail(email);
	        ResponseDto responseDTO = new ResponseDto("Data retrived by email",addressBookData);
	        return new ResponseEntity<ResponseDto>(responseDTO,HttpStatus.OK);
	    }
	 
	 @GetMapping("/login/{email}/{password}")
		ResponseEntity<ResponseDto> login(@PathVariable String email,@PathVariable String password)
		{
			AddressBookData userModel = service.login(email,password);
			ResponseDto responseDto=new ResponseDto("Login done sucessfully ", userModel);
			return new ResponseEntity<>(responseDto,HttpStatus.OK);
			
		}
	 
	 @GetMapping("/sortAsc")
	    public ResponseEntity<ResponseDto> sortAsc() {
	        List<AddressBookData> addressBookList = service.sortAsc();
	        ResponseDto responseDto = new ResponseDto("All data retrived",addressBookList);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }

	 @GetMapping("/sortDsc")
	    public ResponseEntity<ResponseDto> sortDsc() {
	        List<AddressBookData> addressBookList = service.sortDsc();
	        ResponseDto responseDto = new ResponseDto("All data retrived",addressBookList);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }
	 
	 @GetMapping("/sortAscState")
	    public ResponseEntity<ResponseDto> sortAscState() {
	        List<AddressBookData> addressBookList = service.sortAscState();
	        ResponseDto responseDto = new ResponseDto("All data retrived",addressBookList);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }

	 @GetMapping("/sortDscState")
	    public ResponseEntity<ResponseDto> sortDscState() {
	        List<AddressBookData> addressBookList = service.sortDscState();
	        ResponseDto responseDto = new ResponseDto("All data retrived",addressBookList);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }
	 @GetMapping("/searchData/{searchString}")
	    public ResponseEntity<ResponseDto> getDataBySearch(@PathVariable String searchString) {
	       List<AddressBookData> addressBookData= service.getDataSearch(searchString);
	        ResponseDto responseDto = new ResponseDto("Data retrived by search ",addressBookData);
	        return new ResponseEntity<>(responseDto, HttpStatus.OK);
	    }
	 
	 

}
