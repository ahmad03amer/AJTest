package com.accessjobs.pjp.services;

import com.accessjobs.pjp.domain.Job;
import com.accessjobs.pjp.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Job add(Job job){
        //logic , validation and handling
        return jobRepository.save(job);
    }
}
