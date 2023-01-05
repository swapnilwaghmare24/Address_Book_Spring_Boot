package com.bridgelabz.addressbook.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.addressbook.dto.ResponseDto;
import java.util.stream.Collectors;

@ControllerAdvice
public class AddressBookExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessage = errorList.stream().map(objectError -> objectError.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDto responseDTO = new ResponseDto("Exception found", errorMessage);
		return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<ResponseDto> handleAddressBookException(AddressBookException exception) {
		ResponseDto responseDto = new ResponseDto("Exception caught", exception.getMessage());
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
	}

}
