create table credit_card
(
    id          bigint auto_increment,
    card_number bigint,
    last_pay    date
);

alter table credit_card
    add constraint pk_credit_card
        primary key (id);

create table credit_card_risk
(
    id          bigint auto_increment,
    date      date,
    risk        int,
    credit_card bigint
);
alter table credit_card_risk
    add primary key (id);
alter table credit_card_risk
    add constraint fk_credit_card foreign key (credit_card) references credit_card (id);

