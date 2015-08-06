package com.gft.banking.DAL.sql;

/**
 * Created by rowesolowski on 2015-08-05.
 */
public class ClientSQLQueries {

    public static final String CLIENT_ID_COLUMN = "clientId";
    public static final String FIRST_NAME_COLUMN = "firstName";
    public static final String LAST_NAME_COLUMN = "lastName";

    public static String getAllClientsQuery() {
        return "SELECT * FROM Clients;";
    }

    public static String getClientByIdQuery(final int id) {
        final StringBuilder sb = new StringBuilder("SELECT * FROM Clients WHERE clientId = ");
        sb.append(id).append(";");
        return sb.toString();
    }
}
