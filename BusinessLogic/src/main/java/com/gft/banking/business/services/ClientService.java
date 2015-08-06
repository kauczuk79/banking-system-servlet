package com.gft.banking.business.services;

import com.gft.banking.business.converters.ClientServiceConverter;
import com.gft.banking.business.dto.ClientDTO;
import com.gft.banking.dal.converters.ClientEntityConverter;
import com.gft.banking.dal.dto.ClientServiceDTO;
import com.gft.banking.dal.entities.ClientEntity;
import com.gft.banking.dal.repositories.ClientRepository;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class ClientService {
    public ClientDTO getClient(int id) {
        final ClientRepository clientRepository = new ClientRepository();
        final ClientEntity entity = clientRepository.getClientById(id);
        final ClientEntityConverter entityConverter = new ClientEntityConverter();
        final ClientServiceConverter serviceConverter = new ClientServiceConverter();
        try {
            final ClientServiceDTO clientServiceDTO = entityConverter.convert(entity);
            final ClientDTO clientDTO = serviceConverter.convert(clientServiceDTO);
            return clientDTO;
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createClient(final String firstName, final String lastName) {
        final ClientRepository clientRepository = new ClientRepository();
        AccountService accountService = new AccountService();
        clientRepository.createUser(firstName, lastName);
        int clientId = clientRepository.findClientIdByUsername(firstName, lastName);
        accountService.createAccountForClient(clientId);
        return true;
    }
}
