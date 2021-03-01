package com.accessjobs.pjp.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorsService {

    public ResponseEntity<?> mapValidationService(BindingResult result) {
        //using field errors validation , we can return the list of errors in the input object as a useful msg
        if (result.hasErrors()) {
            //to display a map as a key value for the errors fields , the field that have an error will displays on the screen with the msg
            //as following "field":"msg"
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            //return the response entity as a map of field : description format and  the status code
            return new ResponseEntity<Map<String,String>>( errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
