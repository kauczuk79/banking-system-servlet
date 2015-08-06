package com.gft.banking.dal.converters;

import com.gft.banking.dal.dto.ClientServiceDTO;
import com.gft.banking.dal.entities.ClientEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class ClientEntityConverter implements IEntityConverter<ClientEntity, ClientServiceDTO> {
    @Override
    public ClientServiceDTO convert(final ClientEntity entity) throws InvocationTargetException, IllegalAccessException {
        final ClientServiceDTO client = new ClientServiceDTO();
        BeanUtils.copyProperties(client, entity);
        return client;
    }
}
