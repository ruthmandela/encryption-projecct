package com.login.jdbclogin.KycCollection;

public class CustomerEmploymentMOdel {
    String occupationCode="";
    String industryCode="";
    String employerName="";
    String salaryRangeCode="";
    String sourceOfFunds="";
    String employerCode="";

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getSalaryRangeCode() {
        return salaryRangeCode;
    }

    public void setSalaryRangeCode(String salaryRangeCode) {
        this.salaryRangeCode = salaryRangeCode;
    }

    public String getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(String sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public String getEmployerCode() {
        return employerCode;
    }

    public void setEmployerCode(String employerCode) {
        this.employerCode = employerCode;
    }
}
