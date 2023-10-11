package com.login.jdbclogin.CustomerKycTermination;

public class CustomerKycQueueModel {
    String nationalId;
    String appCode;
    public CustomerKycQueueModel(){

    }
    public CustomerKycQueueModel(String nationalId,String appCode){
        this.nationalId=nationalId;
        this.appCode=appCode;

    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
}
