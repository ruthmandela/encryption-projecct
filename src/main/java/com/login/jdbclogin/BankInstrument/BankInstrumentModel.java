package com.login.jdbclogin.BankInstrument;

import java.util.List;

public class BankInstrumentModel {

    Object chequeBook;
   Object debitCard;
    Object businessOnline;
    Object internetBanking;

    public Object getChequeBook() {
        return chequeBook;
    }

    public void setChequeBook(Object chequeBook) {
        this.chequeBook = chequeBook;
    }

    public Object getDebitCard() {
        return debitCard;
    }

    public void setDebitCard(Object debitCard) {
        this.debitCard = debitCard;
    }

    public Object getBusinessOnline() {
        return businessOnline;
    }

    public void setBusinessOnline(Object businessOnline) {
        this.businessOnline = businessOnline;
    }

    public Object getInternetBanking() {
        return internetBanking;
    }

    public void setInternetBanking(Object internetBanking) {
        this.internetBanking = internetBanking;
    }
}
