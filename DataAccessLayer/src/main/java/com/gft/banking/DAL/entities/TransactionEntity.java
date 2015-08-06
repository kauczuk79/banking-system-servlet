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
