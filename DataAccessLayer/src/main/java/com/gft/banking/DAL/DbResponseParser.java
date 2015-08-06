package com.gft.banking.dal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by rowesolowski on 2015-08-05.
 */
public abstract class DbResponseParser<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbResponseParser.class);

    public T doQuery(final String query) {
        T result = null;
        final DataAccess dataAccess = new DataAccess();
        try {
            final Statement statement = dataAccess.getConnection().createStatement();
            final ResultSet resultSet = statement.executeQuery(query);
            result = parse(resultSet);
            if (!resultSet.isClosed())
                resultSet.close();
            statement.close();
        } catch (SQLException e) {
            LOGGER.error("[Database Error] " + e.getMessage());
        }
        dataAccess.closeConnection();
        return result;
    }

    public abstract T parse(final ResultSet resultSet) throws SQLException;
}
