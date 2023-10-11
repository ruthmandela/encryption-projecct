package com.login.jdbclogin.KycCollection;

public class CustomerKycRequestModel {
    customerPreference customerPreference;
    CustomerContactModel customerContactInfo;
    CustomerEmploymentMOdel customerEmploymentInfo;
    CustomerEmergencyContactModel customerEmergencyContactInfo;
    CustomerFatcaModel customerFatca;
    CustomerProductSelectionModel customerProductSelection;

    public customerPreference getCustomerPreference() {
        return customerPreference;
    }

    public void setCustomerPreference(customerPreference customerPreference) {
        this.customerPreference = customerPreference;
    }

    public CustomerContactModel getCustomerContactInfo() {
        return customerContactInfo;
    }

    public void setCustomerContactInfo(CustomerContactModel customerContactInfo) {
        this.customerContactInfo = customerContactInfo;
    }

    public CustomerEmploymentMOdel getCustomerEmploymentInfo() {
        return customerEmploymentInfo;
    }

    public void setCustomerEmploymentInfo(CustomerEmploymentMOdel customerEmploymentInfo) {
        this.customerEmploymentInfo = customerEmploymentInfo;
    }

    public CustomerEmergencyContactModel getCustomerEmergencyContactInfo() {
        return customerEmergencyContactInfo;
    }

    public void setCustomerEmergencyContactInfo(CustomerEmergencyContactModel customerEmergencyContactInfo) {
        this.customerEmergencyContactInfo = customerEmergencyContactInfo;
    }

    public CustomerFatcaModel getCustomerFatca() {
        return customerFatca;
    }

    public void setCustomerFatca(CustomerFatcaModel customerFatca) {
        this.customerFatca = customerFatca;
    }

    public CustomerProductSelectionModel getCustomerProductSelection() {
        return customerProductSelection;
    }

    public void setCustomerProductSelection(CustomerProductSelectionModel customerProductSelection) {
        this.customerProductSelection = customerProductSelection;
    }

    @Override
    public String toString() {
        return "CustomerKycRequestModel{" +
                "customerPreference=" + customerPreference +
                ", customerContactInfo=" + customerContactInfo +
                ", customerEmploymentInfo=" + customerEmploymentInfo +
                ", customerEmergencyContactInfo=" + customerEmergencyContactInfo +
                ", customerFatca=" + customerFatca +
                ", customerProductSelection=" + customerProductSelection +
                '}';
    }
}
