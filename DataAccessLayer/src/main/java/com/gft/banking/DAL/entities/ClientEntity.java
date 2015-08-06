package com.gft.banking.dal.entities;

/**
 * Created by rowesolowski on 2015-08-05.
 */
public class ClientEntity {
    private final int clientId;
    private final String firstName;
    private final String lastName;

    public int getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ClientEntity(int clientId, String firstName, String lastName) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity entity = (ClientEntity) o;

        if (clientId != entity.clientId) return false;
        if (firstName != null ? !firstName.equals(entity.firstName) : entity.firstName != null) return false;
        return !(lastName != null ? !lastName.equals(entity.lastName) : entity.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
