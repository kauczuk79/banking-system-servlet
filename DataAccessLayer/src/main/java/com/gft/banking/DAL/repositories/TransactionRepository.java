package com.gft.banking.dal.repositories;

import com.gft.banking.dal.DbResponseParser;
import com.gft.banking.dal.entities.TransactionEntity;
import com.gft.banking.dal.sql.TransactionSQLQueries;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rowesolowski on 2015-08-05.
 */
public class TransactionRepository {

    protected static List<TransactionEntity> parseList(final ResultSet resultSet) throws SQLException {
        final List<TransactionEntity> queryResult = new ArrayList<>();
        while(resultSet.next()) {
            final int transactionId = resultSet.getInt(TransactionSQLQueries.TRANSACTION_ID_COLUMN);
            final int fromAccount = resultSet.getInt(TransactionSQLQueries.FROM_ACCOUNT_COLUMN);
            final int toAccount = resultSet.getInt(TransactionSQLQueries.TO_ACCOUNT_COLUMN);
            final Date date = resultSet.getDate(TransactionSQLQueries.DATE_COLUMN);
            final double amount = resultSet.getDouble(TransactionSQLQueries.AMOUNT_COLUMN);
            final TransactionEntity account = new TransactionEntity(transactionId, fromAccount, toAccount, date, amount);
            queryResult.add(account);
        }
        return queryResult;
    }

    public final List<TransactionEntity> getAllTransactions() {
        final DbResponseParser<List<TransactionEntity>> parser = new DbResponseParser<List<TransactionEntity>>() {
            @Override
            public List<TransactionEntity> parse(ResultSet resultSet) throws SQLException{
                return parseList(resultSet);
            }
        };
        return parser.doQuery(TransactionSQLQueries.getAllTransactionsQuery());
    }
}
