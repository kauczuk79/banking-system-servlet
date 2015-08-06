package com.gft.banking.dal.repositories;

import com.gft.banking.dal.DbResponseParser;
import com.gft.banking.dal.entities.AccountEntity;
import com.gft.banking.dal.sql.AccountSQLQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
;
/**
 * Created by rowesolowski on 2015-08-05.
 */
public class AccountRepository {

    protected static List<AccountEntity> parseList(final ResultSet resultSet) throws SQLException {
        final List<AccountEntity> queryResult = new ArrayList<>();
        while (resultSet.next()) {
            final int accountId = resultSet.getInt(AccountSQLQueries.ACCOUNT_ID_COLUMN);
            final int clientId = resultSet.getInt(AccountSQLQueries.CLIENT_ID_COLUMN);
            final String accountNumber = resultSet.getString(AccountSQLQueries.ACCOUNT_NUMBER_COLUMN);
            final AccountEntity account = new AccountEntity(accountId, clientId, accountNumber);
            queryResult.add(account);
        }
        return queryResult;
    }

    public List<AccountEntity> getAllAccounts() {
        final DbResponseParser<List<AccountEntity>> parser = new DbResponseParser<List<AccountEntity>>() {
            @Override
            public List<AccountEntity> parse(ResultSet resultSet) throws SQLException {
                return parseList(resultSet);
            }
        };
        return parser.doQuery(AccountSQLQueries.getAllAccountsQuery());
    }

    public List<AccountEntity> getAccountsByClientId(final int clientId) {
        final DbResponseParser<List<AccountEntity>> parser = new DbResponseParser<List<AccountEntity>>() {
            @Override
            public List<AccountEntity> parse(ResultSet resultSet) throws SQLException {
                return parseList(resultSet);
            }
        };
        return parser.doQuery(AccountSQLQueries.getAccountsByClientIdQuery(clientId));
    }
}
