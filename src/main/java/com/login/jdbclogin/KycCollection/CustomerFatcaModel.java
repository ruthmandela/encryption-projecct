package com.login.jdbclogin.KycCollection;

public class CustomerFatcaModel {
    String  unitedStatesMailingAddress;
    String socialSecurityNumber;

    String unitedStatesPostalAddress;

    public String getUnitedStatesMailingAddress() {
        return unitedStatesMailingAddress;
    }

    public void setUnitedStatesMailingAddress(String unitedStatesMailingAddress) {
        this.unitedStatesMailingAddress = unitedStatesMailingAddress;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getUnitedStatesPostalAddress() {
        return unitedStatesPostalAddress;
    }

    public void setUnitedStatesPostalAddress(String unitedStatesPostalAddress) {
        this.unitedStatesPostalAddress = unitedStatesPostalAddress;
    }
}
