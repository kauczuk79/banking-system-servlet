package com.gft.banking.DAL.sql;

/**
 * Created by rowesolowski on 2015-08-05.
 */
public class AccountSQLQueries {

    public static final String ACCOUNT_ID_COLUMN = "accountId";
    public static final String CLIENT_ID_COLUMN = "clientId";
    public static final String ACCOUNT_NUMBER_COLUMN = "accountNumber";

    public static String getAllAccountsQuery() {
        return "SELECT * FROM Accounts";
    }

    public static String getAccountsByClientIdQuery(final int clientId) {
        final StringBuilder sb = new StringBuilder("SELECT * FROM Accounts WHERE clientId = ");
        sb.append(clientId).append(";");
        return sb.toString();
    }
}
