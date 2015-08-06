package com.gft.banking.business.services;

import com.gft.banking.dal.DbResponseParser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class AccountService {
    public Boolean createAccountForClient(final int clientId) {
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        for(int i=0; i<26; i++) {
            sb.append(rnd.nextInt(10));
        }
        DbResponseParser<Boolean> parser = new DbResponseParser<Boolean>() {
            @Override
            public Boolean parse(ResultSet resultSet) throws SQLException {
                return true;
            }
        };
        return parser.doQuery("INSERT INTO Accounts (clientId, accountNumber) VALUES ('"+clientId+"','"+sb.toString()+"');");
    }
}
