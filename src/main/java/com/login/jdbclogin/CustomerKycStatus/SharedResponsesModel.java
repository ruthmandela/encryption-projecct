package com.login.jdbclogin.CustomerKycStatus;

public class SharedResponsesModel {
    int responseCode;
    String message;
    Object data;
    public SharedResponsesModel(){

    }
    public SharedResponsesModel(int responseCode, String message){
        this.responseCode=responseCode;
        this.message=message;

    }
    public SharedResponsesModel(int responseCode, String message,Object data){
        this.responseCode=responseCode;
        this.message=message;
        this.data=data;

    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
