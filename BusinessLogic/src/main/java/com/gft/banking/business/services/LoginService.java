package com.gft.banking.business.services;

import com.gft.banking.dal.repositories.ClientRepository;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class LoginService {

    public int tryLogin(String firsName, String lastName, String password) {
        final ClientRepository clientRepository = new ClientRepository();
        if (!password.equals("123456"))
            return -1;
        final int clientId = clientRepository.findClientIdByUsername(firsName, lastName);
        return clientId;
    }
}
