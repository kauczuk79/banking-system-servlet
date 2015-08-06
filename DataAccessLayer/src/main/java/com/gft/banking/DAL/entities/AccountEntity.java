package com.gft.banking.DAL.entities;

/**
 * Created by rowesolowski on 2015-08-05.
 */
public class AccountEntity {
    private final int accountId;
    private final int clientId;
    private final String accountNumber;

    public AccountEntity(int accountId, int clientId, String accountNumber) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "accountId=" + accountId +
                ", clientId=" + clientId +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
