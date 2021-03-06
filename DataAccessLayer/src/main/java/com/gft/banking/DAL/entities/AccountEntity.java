package com.gft.banking.dal.entities;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        if (accountId != that.accountId) return false;
        if (clientId != that.clientId) return false;
        return !(accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null);

    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + clientId;
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        return result;
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
