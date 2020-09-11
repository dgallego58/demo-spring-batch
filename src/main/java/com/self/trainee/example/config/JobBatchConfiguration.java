package com.self.trainee.example.config;


import com.self.trainee.example.job.CreditCardJobExecutionListener;
import com.self.trainee.example.listener.CreditCardItemProcessListener;
import com.self.trainee.example.listener.CreditCardItemReaderListener;
import com.self.trainee.example.listener.CreditCardItemWriterListener;
import com.self.trainee.example.model.CreditCard;
import com.self.trainee.example.model.CreditCardRisk;
import com.self.trainee.example.repo.CreditCardRepository;
import com.self.trainee.example.repo.CreditCardRiskRepository;
import com.self.trainee.example.step.CreditCardItemProcessor;
import com.self.trainee.example.step.CreditCardItemReader;
import com.self.trainee.example.step.CreditCardItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobBatchConfiguration {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardRiskRepository creditCardRiskRepository;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public JobBatchConfiguration(CreditCardRepository creditCardRepository,
                                 CreditCardRiskRepository creditCardRiskRepository, JobBuilderFactory jobBuilderFactory,
                                 StepBuilderFactory stepBuilderFactory) {
        this.creditCardRepository = creditCardRepository;
        this.creditCardRiskRepository = creditCardRiskRepository;
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public CreditCardItemReader reader() {
        return new CreditCardItemReader(creditCardRepository);
    }

    @Bean
    public CreditCardItemProcessor processor() {
        return new CreditCardItemProcessor();
    }

    @Bean
    public CreditCardItemWriter writer() {
        return new CreditCardItemWriter(creditCardRiskRepository);
    }

    @Bean
    public CreditCardJobExecutionListener jobExecutionListener() {
        return new CreditCardJobExecutionListener();
    }

    @Bean
    public CreditCardItemReaderListener readerListener() {
        return new CreditCardItemReaderListener();
    }

    @Bean
    public CreditCardItemProcessListener processListener() {
        return new CreditCardItemProcessListener();
    }

    @Bean
    public CreditCardItemWriterListener writerListener() {
        return new CreditCardItemWriterListener();
    }

    @Bean
    public Job job1(@Qualifier("step1") Step step,
                    CreditCardJobExecutionListener jobExecutionListener) {

        return jobBuilderFactory.get("job1").listener(jobExecutionListener).flow(step).end().build();
    }

    @Bean
    public Step step1(CreditCardItemReader reader, CreditCardItemProcessor processor, CreditCardItemWriter writer,
                      CreditCardItemReaderListener readerListener, CreditCardItemProcessListener processListener,
                      CreditCardItemWriterListener writerListener) {

        return stepBuilderFactory.get("step1").<CreditCard, CreditCardRisk>chunk(1000).faultTolerant()
                                                                                      .reader(reader)
                                                                                      .processor(processor)
                                                                                      .writer(writer)
                                                                                      .listener(readerListener)
                                                                                      .listener(processListener)
                                                                                      .listener(writerListener)
                                                                                      .build();
    }




}
