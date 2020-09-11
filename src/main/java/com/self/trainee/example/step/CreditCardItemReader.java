package com.self.trainee.example.step;


import com.self.trainee.example.model.CreditCard;
import com.self.trainee.example.repo.CreditCardRepository;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

public class CreditCardItemReader implements ItemReader<CreditCard> {

    private final CreditCardRepository repository;
    private Iterator<CreditCard> usersIterator;

    @Autowired
    public CreditCardItemReader(CreditCardRepository repository) {
        this.repository = repository;
    }

    @BeforeStep
    public void before(StepExecution stepExecution) {
        usersIterator = repository.findAll().iterator();
    }

    @Override
    public CreditCard read() {
        if (usersIterator != null && usersIterator.hasNext()) {
            return usersIterator.next();
        }
        else {
            return null;
        }

    }
}
