package com.accessjobs.pjp.controllers;

import com.accessjobs.pjp.domain.Job;
import com.accessjobs.pjp.services.JobService;
import com.accessjobs.pjp.validation.MapValidationErrorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;
    @Autowired
    private MapValidationErrorsService mapValidationErrorsService;

    //@valid annotation to validate the object attributes and , i used the following code FieldErrors to display the list of errors from validation
    @PostMapping("")
    public ResponseEntity<?> add(@Valid @RequestBody Job job, BindingResult result){

       ResponseEntity<?> errorMap = mapValidationErrorsService.mapValidationService(result);
       if(errorMap != null) return errorMap;
       
        Job tempJob =  jobService.add(job);
        return new ResponseEntity<Job>(tempJob, HttpStatus.CREATED);
    }
}
