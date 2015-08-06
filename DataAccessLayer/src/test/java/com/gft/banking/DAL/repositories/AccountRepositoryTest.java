package com.gft.banking.dal.repositories;

import com.gft.banking.dal.entities.AccountEntity;
import com.gft.banking.dal.sql.AccountSQLQueries;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class AccountRepositoryTest {
    @Test
    public void parseListShouldReturnProperList() throws SQLException{
        final String accNumber = "11222233334444555566667777";
        final int acconutId = 1;
        final int clientId = 1;
        final AccountEntity expected = new AccountEntity(acconutId, clientId, accNumber);
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getInt(AccountSQLQueries.ACCOUNT_ID_COLUMN)).thenReturn(acconutId);
        when(resultSet.getInt(AccountSQLQueries.CLIENT_ID_COLUMN)).thenReturn(clientId);
        when(resultSet.getString(AccountSQLQueries.ACCOUNT_NUMBER_COLUMN)).thenReturn(accNumber);
        List<AccountEntity> result = AccountRepository.parseList(resultSet);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), expected);
    }
}