package com.gft.banking.dal.entities;

import java.sql.Date;

/**
 * Created by rowesolowski on 2015-08-05.
 */
public class TransactionEntity {
    private final int transactionId;
    private final int fromAccount;
    private final int toAccount;
    private final Date date;
    private final double amount;

    public TransactionEntity(int transactionId, int fromAccount, int toAccount, Date date, double amount) {
        this.transactionId = transactionId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.date = date;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

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
        return "TransactionEntity{" +
                "transactionId=" + transactionId +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", date=" + date.toLocalDate().toString() +
                ", amount=" + amount +
                '}';
    }
}
