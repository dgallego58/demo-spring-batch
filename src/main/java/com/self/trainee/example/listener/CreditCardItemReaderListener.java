package com.self.trainee.example.listener;


import com.self.trainee.example.model.CreditCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;

public class CreditCardItemReaderListener implements ItemReadListener<CreditCard> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditCardItemReaderListener.class);

    @Override
    public void beforeRead() {
        LOGGER.info("beforeRead");
    }

    @Override
    public void afterRead(CreditCard item) {
        LOGGER.info("afterRead: {}", item);
    }

    @Override
    public void onReadError(Exception ex) {
        LOGGER.info("onReadError: {}", ex.getLocalizedMessage());
    }
}
