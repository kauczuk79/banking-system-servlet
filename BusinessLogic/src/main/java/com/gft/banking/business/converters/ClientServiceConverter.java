package com.gft.banking.business.converters;

import com.gft.banking.business.dto.AccountDTO;
import com.gft.banking.business.dto.ClientDTO;
import com.gft.banking.dal.converters.AccountEntityConverter;
import com.gft.banking.dal.dto.AccountServiceDTO;
import com.gft.banking.dal.dto.ClientServiceDTO;
import com.gft.banking.dal.entities.AccountEntity;
import com.gft.banking.dal.repositories.AccountRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class ClientServiceConverter implements IServiceConverter<ClientServiceDTO, ClientDTO> {

    private List<AccountServiceDTO> convertAccountEntityListToAccountServiceDTOList(final List<AccountEntity> entities) {
        final AccountEntityConverter accountEntityConverter = new AccountEntityConverter();
        final List<AccountServiceDTO> result = new ArrayList<>();
        CollectionUtils.collect(entities, (entity) -> {
            final AccountEntity en = (AccountEntity) entity;
            try {
                return accountEntityConverter.convert(en);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }, result);
        return result;
    }

    private List<AccountDTO> convertAccountServiceDTOListToAccountDTOList(final List<AccountServiceDTO> dtos) {
        final AccountServiceConverter accountServiceConverter = new AccountServiceConverter();
        final List<AccountDTO> result = new ArrayList<>();
        CollectionUtils.collect(dtos, (dto) -> {
            final AccountServiceDTO singleDto = (AccountServiceDTO) dto;
            try {
                return accountServiceConverter.convert(singleDto);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return new AccountServiceDTO();
        }, result);
        return result;
    }

    public ClientDTO convert(ClientServiceDTO serviceDto) throws InvocationTargetException, IllegalAccessException {
        final ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(clientDTO, serviceDto);
        final AccountRepository accountRepository = new AccountRepository();
        final List<AccountEntity> accountEntityList = accountRepository.getAccountsByClientId(clientDTO.getClientId());
        final List<AccountServiceDTO> accountServiceDTOList = convertAccountEntityListToAccountServiceDTOList(accountEntityList);
        final List<AccountDTO> accountDTOList = convertAccountServiceDTOListToAccountDTOList(accountServiceDTOList);
        accountDTOList.forEach(clientDTO::addAccount);

        return clientDTO;
    }
}
