package com.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.service.util.IConstants;

@ControllerAdvice("com.service.controller")
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<CustomException> toResponse(Exception exception) {
		ResponseEntity<CustomException> exceptionResponse = null;

		if (exception instanceof CustomException && ((CustomException) exception).getExceptionBean() != null) {
			CustomException customException = (CustomException) exception;

			if (null != customException.getExceptionBean().getExceptionCode())

			{
				switch (customException.getExceptionBean().getExceptionCode()) {
				case IConstants.VALIDATIONEXCEPTION: {
					exceptionResponse = new ResponseEntity(customException.getExceptionBean(), HttpStatus.BAD_REQUEST);
				}

				case IConstants.NODATAFOUNDEXCEPTION: {
					exceptionResponse = new ResponseEntity(customException.getExceptionBean(), HttpStatus.NOT_FOUND);
				}

				}
			} 
		}
		else if(exception instanceof MethodArgumentTypeMismatchException)
		{
			exceptionResponse = new ResponseEntity((new ExceptionBean()).setExceptionCode(IConstants.SERVICE_REQUEST_MALFORMED_ERROR_OCCURED)
					.setExceptionMessage(IConstants.SERVICE_REQUEST_MALFORMED_ERROR_OCCURED_DESCR),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		else if(exception instanceof MissingServletRequestParameterException)
		{
			exceptionResponse = new ResponseEntity((new ExceptionBean()).setExceptionCode(IConstants.SERVICE_REQUEST_PARAM_ERROR_OCCURED)
					.setExceptionMessage(IConstants.SERVICE_REQUEST_PARAM_ERROR_OCCURED_DESCR),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		else {
			exceptionResponse = new ResponseEntity((new ExceptionBean()).setExceptionCode(IConstants.ERROR_OCCURED)
					.setExceptionMessage(IConstants.ERROR_OCCURED_CONTACT_ADMIN_DESCR),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return exceptionResponse;
	}

}
