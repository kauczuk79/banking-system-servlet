package com.gft.banking.dal.dto;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class AccountServiceDTO {
    private int accountId;
    private int clientId;
    private String accountNumber;

    public AccountServiceDTO() {}

    public AccountServiceDTO(int accountId, int clientId, String accountNumber) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "AccountServiceDTO{" +
                "accountId=" + accountId +
                ", clientId=" + clientId +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountServiceDTO that = (AccountServiceDTO) o;

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
}
