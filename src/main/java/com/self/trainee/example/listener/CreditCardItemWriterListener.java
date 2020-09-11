package com.self.trainee.example.listener;


import com.self.trainee.example.model.CreditCardRisk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class CreditCardItemWriterListener implements ItemWriteListener<CreditCardRisk> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCardItemWriterListener.class);

    @Override
    public void beforeWrite(List<? extends CreditCardRisk> items) {
        LOGGER.info("beforeWrite: {}", items);
    }

    @Override
    public void afterWrite(List<? extends CreditCardRisk> items) {
        items.forEach(item -> LOGGER.info("afterWrite: {}", item));
    }

    @Override
    public void onWriteError(Exception exception, List<? extends CreditCardRisk> items) {
        LOGGER.info("onWriteError: {}, items: {}", exception.getLocalizedMessage(), items);
    }
}
