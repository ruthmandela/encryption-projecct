package com.login.jdbclogin.CustomerKycStatus;

public class CustomerKycStatusModel {
    String identificationNumber;
    String legalIdType;

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getLegalIdType() {
        return legalIdType;
    }

    public void setLegalIdType(String legalIdType) {
        this.legalIdType = legalIdType;
    }
}
