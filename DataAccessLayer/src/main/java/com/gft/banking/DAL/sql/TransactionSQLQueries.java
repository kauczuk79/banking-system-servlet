package com.gft.banking.dal.sql;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class TransactionSQLQueries {

    public static final String TRANSACTION_ID_COLUMN = "transactionId";
    public static final String FROM_ACCOUNT_COLUMN = "fromAccount";
    public static final String TO_ACCOUNT_COLUMN = "toAccount";
    public static final String DATE_COLUMN = "date";
    public static final String AMOUNT_COLUMN = "amount";

    public static String getAllTransactionsQuery() {
        return "SELECT * FROM Transactions";
    }

    public static String getTransactionsByAccountId(int accountId) {
        final StringBuilder sb = new StringBuilder("SELECT * FROM Transactions WHERE (toAccount = ");
        sb.append(accountId).append(" AND amount>0) OR (fromAccount = ").append(accountId).append(" AND amount<=0);");
        return sb.toString();
    }
}
