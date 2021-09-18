package com.self.trainee.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "credit_card_risk")
public class CreditCardRisk implements Serializable {
    private static final long serialVersionUID = 5443824651044825479L;

    public static final int HIGH = 3;
    public static final int LOW = 2;
    public static final int NORMAL = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private int risk;

    @OneToOne(optional = false)
    private CreditCard creditCard;

    public CreditCardRisk() {
    }

    public CreditCardRisk(LocalDate date, int risk, CreditCard creditCard) {
        this.date = date;
        this.risk = risk;
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "CreditCardRisk{" + "id=" + id + ", date=" + date + ", risk=" + risk + ", creditCard=" + creditCard + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
