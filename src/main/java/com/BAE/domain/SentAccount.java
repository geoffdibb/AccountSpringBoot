package com.BAE.domain;

public class SentAccount {

    private Long accountId;

    private String firstName;

    private String lastName;

    private String accountNumber;
    
    private String prizewinner;
    
    

    public SentAccount(){}

    public SentAccount(Account account){
        this.accountId = account.getId();
        this.firstName = account.getFirstName();
        this.lastName = account.getlastName();
        this.accountNumber = account.getaccountNumber();
		this.prizewinner = account.getprizewinner();

    }

    

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getprizewinner() {
        return prizewinner;
    }

    public void setprizewinner(String prizewinner) {
        this.prizewinner = prizewinner;
    }

}