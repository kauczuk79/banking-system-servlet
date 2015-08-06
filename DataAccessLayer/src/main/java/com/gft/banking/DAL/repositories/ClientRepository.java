package com.gft.banking.dal.repositories;

import com.gft.banking.dal.DbResponseParser;
import com.gft.banking.dal.entities.ClientEntity;
import com.gft.banking.dal.sql.ClientSQLQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rowesolowski on 2015-08-05.
 */
public class ClientRepository {

    protected static List<ClientEntity> parseList(final ResultSet resultSet) throws SQLException{
        final List<ClientEntity> queryResult = new ArrayList<>();
        while (resultSet.next()) {
            final int clientId = resultSet.getInt(ClientSQLQueries.CLIENT_ID_COLUMN);
            final String firstName = resultSet.getString(ClientSQLQueries.FIRST_NAME_COLUMN);
            final String lastName = resultSet.getString(ClientSQLQueries.LAST_NAME_COLUMN);
            final ClientEntity user = new ClientEntity(clientId, firstName, lastName);
            queryResult.add(user);
        }
        return queryResult;
    }

    private ClientEntity parseSingle(final ResultSet resultSet) throws SQLException {
        if(resultSet.next()) {
            final int clientId = resultSet.getInt(ClientSQLQueries.CLIENT_ID_COLUMN);
            final String firstName = resultSet.getString(ClientSQLQueries.FIRST_NAME_COLUMN);
            final String lastName = resultSet.getString(ClientSQLQueries.LAST_NAME_COLUMN);
            return new ClientEntity(clientId, firstName, lastName);
        }
        return null;
    }

    public final List<ClientEntity> getAllUsers() {
        final DbResponseParser<List<ClientEntity>> parser = new DbResponseParser<List<ClientEntity>>() {
            @Override
            public List<ClientEntity> parse(ResultSet resultSet) throws SQLException {
                return parseList(resultSet);
            }
        };
        return parser.doQuery(ClientSQLQueries.getAllClientsQuery());
    }

    public final ClientEntity getClientById(final int id) {
        final DbResponseParser<ClientEntity> parser = new DbResponseParser<ClientEntity>() {
            @Override
            public ClientEntity parse(ResultSet resultSet) throws SQLException {
                return parseSingle(resultSet);
            }
        };
        return parser.doQuery(ClientSQLQueries.getClientByIdQuery(id));
    }
}
