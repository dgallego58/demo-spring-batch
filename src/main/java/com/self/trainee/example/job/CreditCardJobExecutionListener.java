package com.self.trainee.example.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class CreditCardJobExecutionListener implements JobExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCardJobExecutionListener.class);

    @Override
    public void beforeJob(JobExecution var1) {
        LOGGER.info("beforeJob");
    }

    @Override
    public void afterJob(JobExecution var1) {
        LOGGER.info("afterJob: {}", var1.getStatus());
    }
}
