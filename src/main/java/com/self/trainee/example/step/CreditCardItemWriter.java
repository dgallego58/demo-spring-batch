package com.self.trainee.example.step;



import com.self.trainee.example.model.CreditCardRisk;
import com.self.trainee.example.repo.CreditCardRiskRepository;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class CreditCardItemWriter implements ItemWriter<CreditCardRisk> {

    private final CreditCardRiskRepository repository;

    public CreditCardItemWriter(CreditCardRiskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void write(List<? extends CreditCardRisk> items) {
        repository.saveAll(items);
    }
}
