package com.self.trainee.example.listener;


import com.self.trainee.example.model.CreditCard;
import com.self.trainee.example.model.CreditCardRisk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;

public class CreditCardItemProcessListener implements ItemProcessListener<CreditCard, CreditCardRisk> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCardItemProcessListener.class);

    @Override
    public void beforeProcess(CreditCard item) {
        LOGGER.info("beforeProcess");
    }

    @Override
    public void afterProcess(CreditCard item, CreditCardRisk result) {
        LOGGER.info("afterProcess: {} --> {}", item, result);
    }

    @Override
    public void onProcessError(CreditCard item, Exception e) {
        LOGGER.info("onProcessorError");
    }
}
