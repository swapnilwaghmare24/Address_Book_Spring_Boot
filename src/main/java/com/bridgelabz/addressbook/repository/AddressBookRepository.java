package com.bridgelabz.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbook.model.AddressBookData;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {
	
	@Query(value="select * from address_book_data where email=:email", nativeQuery=true)
	AddressBookData findDataByEmail(String email);
	
	@Query(value = "select * from address_book_data order by city", nativeQuery = true)
	List<AddressBookData> addressInAsc();
	
	@Query(value = "select * from address_book_data order by city desc", nativeQuery = true)
	List<AddressBookData> addressInDsc();
	@Query(value = "select * from address_book_data order by state", nativeQuery = true)
	List<AddressBookData> stateInAsc();
	
	@Query(value = "select * from address_book_data order by state desc", nativeQuery = true)
	List<AddressBookData> stateInDsc();
	
	@Query(value = "SELECT * FROM address_book_data WHERE full_name LIKE %:name% OR city LIKE %:name% OR state LIKE %:name% "
			+ "OR phone_number LIKE %:name%", nativeQuery = true)
	    List<AddressBookData> findContactsBySearchString(@Param("name") String searchString);

}
