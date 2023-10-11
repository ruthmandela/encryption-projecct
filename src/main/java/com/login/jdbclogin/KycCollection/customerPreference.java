package com.login.jdbclogin.KycCollection;

import java.util.ArrayList;
import java.util.List;

public class customerPreference {
    String countryOfResidence;
    String bankBranchCode;
    String referralName;
    String currencyCode;
    String dividendDisposalPreference;
    String clientCategory;
   BankDetailModel bankDetails;
   String currency;

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getBankBranchCode() {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }

    public String getReferralName() {
        return referralName;
    }

    public void setReferralName(String referralName) {
        this.referralName = referralName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDividendDisposalPreference() {
        return dividendDisposalPreference;
    }

    public void setDividendDisposalPreference(String dividendDisposalPreference) {
        this.dividendDisposalPreference = dividendDisposalPreference;
    }

    public String getClientCategory() {
        return clientCategory;
    }

    public void setClientCategory(String clientCategory) {
        this.clientCategory = clientCategory;
    }

    public BankDetailModel getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetailModel bankDetails) {
        this.bankDetails = bankDetails;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
