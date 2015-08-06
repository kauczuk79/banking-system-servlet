package com.gft.banking.business.dto;

import java.sql.Date;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class TransactionDTO {
    private int transactionId;
    private int fromAccount;
    private int toAccount;
    private Date date;
    private double amount;

    public TransactionDTO(int transactionId, int fromAccount, int toAccount, Date date, double amount) {
        this.transactionId = transactionId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.date = date;
        this.amount = amount;
    }

    public TransactionDTO() {
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionDTO that = (TransactionDTO) o;

        if (transactionId != that.transactionId) return false;
        if (fromAccount != that.fromAccount) return false;
        if (toAccount != that.toAccount) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        return !(date != null ? !date.equals(that.date) : that.date != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = transactionId;
        result = 31 * result + fromAccount;
        result = 31 * result + toAccount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "transactionId=" + transactionId +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
