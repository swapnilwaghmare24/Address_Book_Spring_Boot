package com.bridgelabz.addressbook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto {
	
	private String message;
    private Object data;

   
    public ResponseDto (String  message, Object data) {
        this.message = message;
        this.data = data;
    }

}
