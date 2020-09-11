package com.self.trainee.example.step;


import com.self.trainee.example.model.CreditCard;
import com.self.trainee.example.model.CreditCardRisk;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.ZoneId;

import static java.time.temporal.ChronoUnit.DAYS;

public class CreditCardItemProcessor implements ItemProcessor<CreditCard, CreditCardRisk> {
    @Override
    public CreditCardRisk process(CreditCard item) {

        LocalDate today = LocalDate.now();
        LocalDate lastDate = item.getLastPay().atStartOfDay(ZoneId.systemDefault()).toLocalDate();
        long daysBetween = DAYS.between(today, lastDate);

        int risk;
        if (daysBetween >= 20) {
            risk = CreditCardRisk.HIGH;
        }
        else if (daysBetween > 10) {
            risk = CreditCardRisk.LOW;
        }
        else {
            risk = CreditCardRisk.NORMAL;
        }

        return new CreditCardRisk(LocalDate.now(), risk, item);

    }
}
