package com.gft.banking.business.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class AccountDTO {
    private int accountId;
    private int clientId;
    private String accountNumber;
    private List<TransactionDTO> transactions;

    public AccountDTO() {
        this.transactions = new ArrayList<>();
    }

    public AccountDTO(int accountId, int clientId, String accountNumber) {

        this.accountId = accountId;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<>();
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

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountDTO that = (AccountDTO) o;

        if (accountId != that.accountId) return false;
        if (clientId != that.clientId) return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        return !(transactions != null ? !transactions.equals(that.transactions) : that.transactions != null);

    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + clientId;
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (transactions != null ? transactions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + accountId +
                ", clientId=" + clientId +
                ", accountNumber='" + accountNumber + '\'' +
                ", transactions=" + transactions +
                '}';
    }

    public void addTransaction(TransactionDTO transactionDTO) {
        transactions.add(transactionDTO);
    }
}
