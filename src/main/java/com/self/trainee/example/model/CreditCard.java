package com.self.trainee.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "credit_card")
public class CreditCard implements Serializable {

    private static final long serialVersionUID = - 2458874341846950257L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cardNumber;
    private LocalDate lastPay;

    public CreditCard() {
        //fetcher
    }

    @Override
    public String toString() {
        return "CreditCard{" + "id=" + id + ", cardNumber=" + cardNumber + ", lastPay=" + lastPay + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getLastPay() {
        return lastPay;
    }

    public void setLastPay(LocalDate lastPay) {
        this.lastPay = lastPay;
    }
}
