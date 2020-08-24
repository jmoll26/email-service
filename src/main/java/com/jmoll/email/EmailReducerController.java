package com.jmoll.email;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jmoll
 *
 */
@RestController
@RequestMapping("email")
public class EmailReducerController {
	
	private static final String SUCCESS_RESPONSE = "Success: calculated unique addresses";

	@Autowired
	private EmailReducerService emailReducer;
	
	@PostMapping("/reduce")
	@ResponseBody
	public EmailResponse calculateDistinctEmails(@Valid @RequestBody EmailRequest request) {

		int uniqueAddresses = emailReducer.getUniqueAddresses(request.getAddresses());
		
		return new EmailResponse(SUCCESS_RESPONSE, request.getAddresses().size(), uniqueAddresses);
	}
	
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
       
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        return new ErrorResponse(errors);
    }
}
