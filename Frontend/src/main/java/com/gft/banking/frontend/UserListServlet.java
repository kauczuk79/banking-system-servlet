package com.gft.banking.frontend;

import com.gft.banking.DAL.entities.AccountEntity;
import com.gft.banking.DAL.entities.ClientEntity;
import com.gft.banking.DAL.entities.TransactionEntity;
import com.gft.banking.DAL.repositories.AccountRepository;
import com.gft.banking.DAL.repositories.ClientRepository;
import com.gft.banking.DAL.repositories.TransactionRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by rowesolowski on 2015-08-05.
 */
public class UserListServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final ClientRepository clientRepository = new ClientRepository();
        final AccountRepository accountRepository = new AccountRepository();
        final TransactionRepository transactionRepository = new TransactionRepository();
        List<ClientEntity> userList = clientRepository.getAllUsers();
        PrintWriter writer = resp.getWriter();
        writer.println("Clients");
        for(ClientEntity entity : userList) {
            writer.println(entity.toString());
        }
        writer.println("Accounts");
        List<AccountEntity> accountList = accountRepository.getAllAccounts();
        for(AccountEntity entity : accountList) {
            writer.println(entity.toString());
        }
        writer.println("Transactions");
        List<TransactionEntity> transactionList = transactionRepository.getAllTransactions();
        for(TransactionEntity entity : transactionList) {
            writer.println(entity.toString());
        }
    }
}
