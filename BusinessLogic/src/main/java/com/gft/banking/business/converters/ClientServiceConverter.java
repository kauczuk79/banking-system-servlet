package com.gft.banking.business.converters;

import com.gft.banking.business.dto.ClientDTO;
import com.gft.banking.dal.dto.ClientServiceDTO;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class ClientServiceConverter implements IServiceConverter<ClientServiceDTO, ClientDTO> {
    public ClientDTO convert(ClientServiceDTO clientServiceDto) throws InvocationTargetException, IllegalAccessException {
        final ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(clientDTO, clientServiceDto);
        return clientDTO;
    }
}
