package com.login.jdbclogin.BankInstrument;

public class ChequeBookModel {
    String pickUpBranch;
    String noOfleaves;
    String  chequebookUsers;

    public String getPickUpBranch() {
        return pickUpBranch;
    }

    public void setPickUpBranch(String pickUpBranch) {
        this.pickUpBranch = pickUpBranch;
    }

    public String getNoOfleaves() {
        return noOfleaves;
    }

    public void setNoOfleaves(String noOfleaves) {
        this.noOfleaves = noOfleaves;
    }

    public String getChequebookUsers() {
        return chequebookUsers;
    }

    public void setChequebookUsers(String chequebookUsers) {
        this.chequebookUsers = chequebookUsers;
    }
}
