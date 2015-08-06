package com.gft.banking.business.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class ClientDTO {
    private int clientId;
    private String firstName;
    private String lastName;
    private List<AccountDTO> accounts;

    public ClientDTO() {
        this.accounts = new ArrayList<>();
    }

    public ClientDTO(int clientId, String firstName, String lastName) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void addAccount(final AccountDTO account) {
        accounts.add(account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientDTO clientDTO = (ClientDTO) o;

        if (clientId != clientDTO.clientId) return false;
        if (firstName != null ? !firstName.equals(clientDTO.firstName) : clientDTO.firstName != null) return false;
        if (lastName != null ? !lastName.equals(clientDTO.lastName) : clientDTO.lastName != null) return false;
        return !(accounts != null ? !accounts.equals(clientDTO.accounts) : clientDTO.accounts != null);

    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
